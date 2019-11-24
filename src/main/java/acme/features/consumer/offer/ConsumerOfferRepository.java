
package acme.features.consumer.offer;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.offers.Offer;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface ConsumerOfferRepository extends AbstractRepository {

	@Query("select o from Offer o where o.id = ?1")
	Offer findOneById(int id);

	@Query("select o from Offer o where o.deadline > CURRENT_TIMESTAMP")
	Collection<Offer> findAllActive();

	@Query("select case when count(o) > 0 then true else false end from Offer o where o.ticker = ?1")
	boolean checkUniqueTicker(String ticker);

}
