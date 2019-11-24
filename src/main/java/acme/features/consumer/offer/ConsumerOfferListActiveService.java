
package acme.features.consumer.offer;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.offers.Offer;
import acme.entities.roles.Consumer;
import acme.framework.components.Model;
import acme.framework.services.AbstractListService;

@Service
public class ConsumerOfferListActiveService implements AbstractListService<Consumer, Offer> {

	@Autowired
	ConsumerOfferRepository repository;


	@Override
	public boolean authorise(final acme.framework.components.Request<Offer> request) {
		assert request != null;

		return true;
	}

	@Override
	public void unbind(final acme.framework.components.Request<Offer> request, final Offer entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "deadline", "moment", "title");

	}

	@Override
	public Collection<Offer> findMany(final acme.framework.components.Request<Offer> request) {
		assert request != null;

		Collection<Offer> result;
		result = this.repository.findAllActive();

		return result;
	}

}
