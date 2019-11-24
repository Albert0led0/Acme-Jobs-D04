
package acme.features.administrator.challenge;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.challenges.Challenge;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Administrator;
import acme.framework.services.AbstractCreateService;

@Service
public class AdministratorChallengeCreateService implements AbstractCreateService<Administrator, Challenge> {

	// Internal state

	@Autowired
	AdministratorChallengeRepository repository;


	// AbstractCreateService<R, E> interface

	@Override
	public boolean authorise(final Request<Challenge> request) {
		assert request != null;

		return true;
	}

	@Override
	public void bind(final Request<Challenge> request, final Challenge entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors);

	}

	@Override
	public void unbind(final Request<Challenge> request, final Challenge entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "title", "deadline", "description", "goldReward", "silverReward", "bronzeReward");
	}

	@Override
	public Challenge instantiate(final Request<Challenge> request) {
		Challenge result = new Challenge();

		return result;
	}

	@Override
	public void validate(final Request<Challenge> request, final Challenge entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		Boolean deadlineAux = true;
		Date now = new Date(System.currentTimeMillis());

		try {
			entity.getGoldReward().getCurrency();
		} catch (NullPointerException e) {
			errors.state(request, false, "goldReward", "administrator.challenge.form.error.null-currency");
		}
		try {
			entity.getSilverReward().getCurrency();
		} catch (NullPointerException e) {
			errors.state(request, false, "silverReward", "administrator.challenge.form.error.null-currency");
		}
		try {
			entity.getBronzeReward().getCurrency();
		} catch (NullPointerException e) {
			errors.state(request, false, "bronzeReward", "administrator.challenge.form.error.null-currency");
		}
		try {
			assert entity.getDeadline() != null;
			if (deadlineAux) {
				throw new RuntimeException();
			}
		} catch (AssertionError e1) {
			deadlineAux = false;
			errors.state(request, false, "deadline", "administrator.challenge.form.error.timestamp");
		} catch (RuntimeException e2) {
			errors.state(request, entity.getDeadline().after(now), "deadline", "administrator.challenge.form.error.past-deadline");
		}

	}

	@Override
	public void create(final Request<Challenge> request, final Challenge entity) {
		this.repository.save(entity);
	}

}
