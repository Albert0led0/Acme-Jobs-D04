
package acme.features.provider.request;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.requests.Request;
import acme.entities.roles.Provider;
import acme.framework.components.Errors;
import acme.framework.components.HttpMethod;
import acme.framework.components.Model;
import acme.framework.services.AbstractCreateService;

@Service
public class ProviderRequestCreateService implements AbstractCreateService<Provider, Request> {

	@Autowired
	ProviderRequestRepository repository;


	@Override
	public boolean authorise(final acme.framework.components.Request<Request> request) {
		assert request != null;

		return true;
	}

	@Override
	public void bind(final acme.framework.components.Request<Request> request, final Request entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors, "moment");

	}

	@Override
	public void unbind(final acme.framework.components.Request<Request> request, final Request entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "title", "deadline", "description", "reward", "ticker");

		if (request.isMethod(HttpMethod.GET)) {
			model.setAttribute("accept", "false");
		} else {
			request.transfer(model, "accept");
		}

	}

	@Override
	public Request instantiate(final acme.framework.components.Request<Request> request) {
		Request result;

		result = new Request();

		return result;
	}

	@Override
	public void validate(final acme.framework.components.Request<Request> request, final Request entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		boolean isAccepted;
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
			errors.state(request, false, "deadline", "provider.request.form.error.timestamp");
		} catch (RuntimeException e2) {
			errors.state(request, entity.getDeadline().after(now), "deadline", "provider.request.form.error.past-deadline");
		}
		// Makes sure the reward (Money) is not null
		try {
			entity.getReward().getAmount();
		} catch (NullPointerException e) {
			errors.state(request, false, "reward", "provider.request.form.error.null-currency");
		}

		if (tickerAux) {
			errors.state(request, !tickerAux, "ticker", "provider.request.form.error.duplicated-ticker");
		}

		isAccepted = request.getModel().getBoolean("accept");
		errors.state(request, isAccepted, "accept", "provider.request.error.must-accept");

	}

	@Override
	public void create(final acme.framework.components.Request<Request> request, final Request entity) {
		Date moment;

		moment = new Date(System.currentTimeMillis() - 1);
		entity.setMoment(moment);
		this.repository.save(entity);

	}

}
