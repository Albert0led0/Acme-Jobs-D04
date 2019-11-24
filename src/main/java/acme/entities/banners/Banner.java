
package acme.entities.banners;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.URL;

import acme.framework.entities.DomainEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public abstract class Banner extends DomainEntity {

	//Serialisation identifier -------------------------------------------

	private static final long	serialVersionUID	= 1L;

	//Attributes ---------------------------------------------------------

	@URL
	@NotBlank
	private String				pictureURL;

	@NotBlank
	private String				slogan;

	@URL
	@NotBlank
	private String				targetURL;
}
