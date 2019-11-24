
package acme.features.consumer.offer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.offers.Offer;
import acme.entities.roles.Consumer;
import acme.framework.components.Model;
import acme.framework.services.AbstractShowService;

@Service
public class ConsumerOfferShowService implements AbstractShowService<Consumer, Offer> {

	@Autowired
	private ConsumerOfferRepository repository;


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

		request.unbind(entity, model, "title", "moment", "deadline", "description", "minReward", "maxReward", "ticker");

	}

	@Override
	public Offer findOne(final acme.framework.components.Request<Offer> request) {
		assert request != null;

		Offer result;
		int id;

		id = request.getModel().getInteger("id");
		result = this.repository.findOneById(id);

		return result;
	}

}
