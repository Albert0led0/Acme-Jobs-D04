
package acme.entities.configurations;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Range;

import acme.framework.entities.DomainEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Configuration extends DomainEntity {

	//Serialisation identifier -------------------------------------------

	private static final long	serialVersionUID	= 1L;

	//Attributes----------------------------------------------------------

	private String				spamwords;

	@Range(min = 0, max = 1)
	private double				spamThreshold;

	@NotBlank
	private String				language;

}
