
package acme.entities.messages;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import acme.framework.entities.DomainEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Message extends DomainEntity {

	private final static long	serialVersionUID	= 1L;

	@NotBlank
	private String				title;

	@Temporal(TemporalType.TIMESTAMP)
	private Date				moment;

	private String				tags;

	@NotBlank
	private String				body;

	@NotNull
	@Valid
	@ManyToOne(optional = false)
	private Thread				thread;

}
