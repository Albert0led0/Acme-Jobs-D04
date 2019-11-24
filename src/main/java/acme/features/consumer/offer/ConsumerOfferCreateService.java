
package acme.features.consumer.offer;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.offers.Offer;
import acme.entities.roles.Consumer;
import acme.framework.components.Errors;
import acme.framework.components.HttpMethod;
import acme.framework.components.Model;
import acme.framework.services.AbstractCreateService;

@Service
public class ConsumerOfferCreateService implements AbstractCreateService<Consumer, Offer> {

	@Autowired
	ConsumerOfferRepository repository;


	@Override
	public boolean authorise(final acme.framework.components.Request<Offer> request) {
		assert request != null;

		return true;
	}

	@Override
	public void bind(final acme.framework.components.Request<Offer> request, final Offer entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors, "moment");

	}

	@Override
	public void unbind(final acme.framework.components.Request<Offer> request, final Offer entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "title", "deadline", "description", "minReward", "maxReward", "ticker");

		if (request.isMethod(HttpMethod.GET)) {
			model.setAttribute("accept", "false");
		} else {
			request.transfer(model, "accept");
		}

	}

	@Override
	public Offer instantiate(final acme.framework.components.Request<Offer> request) {
		Offer result;

		result = new Offer();

		return result;
	}

	@Override
	public void validate(final acme.framework.components.Request<Offer> request, final Offer entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		boolean isAccepted;
		Boolean rewardAux = true;
		Boolean deadlineAux = true;
		Date now = new Date(System.currentTimeMillis());
		boolean tickerAux = this.repository.checkUniqueTicker(entity.getTicker());

		// Checking if the deadline is a valid date and it's in the future
		try {
			assert entity.getDeadline() != null;
			if (deadlineAux) {
				throw new RuntimeException();
			}
		} catch (AssertionError e1) {
			deadlineAux = false;
			errors.state(request, false, "deadline", "consumer.offer.form.error.timestamp");
		} catch (RuntimeException e2) {
			errors.state(request, entity.getDeadline().after(now), "deadline", "consumer.offer.form.error.past-deadline");
		}
		// Makes sure that maxReward >= minReward
		try {
			entity.getMinReward().getAmount();
		} catch (NullPointerException e) {
			errors.state(request, false, "minReward", "consumer.offer.form.error.null-currency");
			rewardAux = false;
		}
		try {
			entity.getMaxReward().getAmount();
		} catch (NullPointerException e) {
			errors.state(request, false, "maxReward", "consumer.offer.form.error.null-currency");
			rewardAux = false;
		}

		if (rewardAux) {
			errors.state(request, entity.getMaxReward().getAmount().doubleValue() >= entity.getMinReward().getAmount().doubleValue(), "maxReward", "consumer.offer.form.error.rewards");
		}

		if (tickerAux) {
			errors.state(request, !tickerAux, "ticker", "consumer.offer.form.error.duplicated-ticker");
		}
		isAccepted = request.getModel().getBoolean("accept");
		errors.state(request, isAccepted, "accept", "consumer.offer.form.error.must-accept");

	}

	@Override
	public void create(final acme.framework.components.Request<Offer> request, final Offer entity) {
		Date moment;

		moment = new Date(System.currentTimeMillis() - 1);
		entity.setMoment(moment);
		this.repository.save(entity);

	}

}
