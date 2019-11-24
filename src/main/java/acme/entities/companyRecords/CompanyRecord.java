
package acme.entities.companyRecords;

import javax.persistence.Entity;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Range;
import org.hibernate.validator.constraints.URL;

import acme.framework.entities.DomainEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class CompanyRecord extends DomainEntity {

	private static final long	serialVersionUID	= 1L;

	@NotBlank
	private String				company;

	@NotBlank
	private String				sector;

	@NotBlank
	private String				ceoName;

	@NotBlank
	private String				description;

	@NotBlank
	@URL
	private String				webSite;

	@Pattern(regexp = "^([+]([1-9][0-9]{0,2})\\s)?([(][0-9]{1,4}[)]\\s)?[0-9].{5,9}$")
	@NotBlank
	private String				phoneNumber;

	@NotBlank
	@Email
	private String				email;

	private boolean				incorporated;

	@Range(min = 0, max = 5)
	private Double				stars;


	// Derived 

	@Transient
	public String getCompanyIncName() {
		String res;
		String aux = ", Inc.";
		if (!this.isIncorporated()) {
			aux = ", LLC";
		}
		res = this.getCompany() + aux;
		return res;
	}
}
