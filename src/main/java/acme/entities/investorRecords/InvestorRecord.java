
package acme.entities.investorRecords;

import javax.persistence.Entity;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Range;

import acme.framework.datatypes.Money;
import acme.framework.entities.DomainEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class InvestorRecord extends DomainEntity {

	private static final long	serialVersionUID	= 1L;

	@NotBlank
	private String				investorName;

	@NotBlank
	private String				sector;

	@Valid
	private Money				investingStatement;

	@Range(min = 0, max = 5)
	private Double				stars;

}
