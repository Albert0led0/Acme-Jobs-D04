
package acme.entities.jobs;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.URL;

import acme.entities.descriptors.Descriptor;
import acme.entities.roles.Employer;
import acme.framework.datatypes.Money;
import acme.framework.entities.DomainEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Job extends DomainEntity {

	private static final long	serialVersionUID	= 1L;

	@NotBlank
	@Size(min = 5, max = 10)
	@Column(unique = true)
	private String				referenceNumber;

	@NotBlank
	private String				title;

	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	private Date				deadline;

	@NotNull
	@Valid
	private Money				salary;

	@URL
	private String				link;

	private boolean				draft;


	//derivados

	@Transient
	public String getStatus() {
		String res = "draft";
		if (!this.isDraft()) {
			res = "published";
		}
		return res;
	}

	@Transient
	public boolean isActive() {
		boolean res = false;
		Date now = new Date(System.currentTimeMillis() - 1);
		if (!this.isDraft() && this.getDeadline().after(now)) {
			res = true;
		}
		return res;
	}


	//relaciones

	@NotNull
	@Valid
	@ManyToOne(optional = false)
	private Employer	employer;

	@NotNull
	@Valid
	@OneToOne(optional = false)
	private Descriptor	descriptor;
}
