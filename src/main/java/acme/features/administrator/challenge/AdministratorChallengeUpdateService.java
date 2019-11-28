
package acme.features.administrator.challenge;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.challenges.Challenge;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Administrator;
import acme.framework.services.AbstractUpdateService;

@Service
public class AdministratorChallengeUpdateService implements AbstractUpdateService<Administrator, Challenge> {

	// Internal state

	@Autowired
	AdministratorChallengeRepository repository;


	// AbstractUpdateService<R, E> interface

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

		request.unbind(entity, model, "title", "deadline", "deadline", "description", "goldReward", "silverReward", "bronzeReward");

	}

	@Override
	public Challenge findOne(final Request<Challenge> request) {
		assert request != null;

		Challenge result;
		int id = request.getModel().getInteger("id");
		result = this.repository.findOneChallengeById(id);

		return result;
	}

	@Override
	public void validate(final Request<Challenge> request, final Challenge entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		Boolean validDeadline = true;
		Boolean nullGSRewards = false;
		Boolean nullSBRewards = false;
		Date now = new Date(System.currentTimeMillis());

		try {
			entity.getGoldReward().getCurrency();
		} catch (NullPointerException e) {
			errors.state(request, false, "goldReward", "administrator.challenge.form.error.null-currency");
			nullGSRewards = true;
		}
		try {
			entity.getSilverReward().getCurrency();
		} catch (NullPointerException e) {
			errors.state(request, false, "silverReward", "administrator.challenge.form.error.null-currency");
			nullGSRewards = true;
			nullSBRewards = true;
		}
		try {
			entity.getBronzeReward().getCurrency();
		} catch (NullPointerException e) {
			errors.state(request, false, "bronzeReward", "administrator.challenge.form.error.null-currency");
			nullSBRewards = true;
		}

		if (!nullGSRewards) {
			errors.state(request, entity.getGoldReward().getAmount().doubleValue() >= entity.getSilverReward().getAmount().doubleValue(), "goldReward", "administrator.challenge.form.error.gold-reward");
		}
		if (!nullSBRewards) {
			errors.state(request, entity.getSilverReward().getAmount().doubleValue() >= entity.getBronzeReward().getAmount().doubleValue(), "silverReward", "administrator.challenge.form.error.silver-reward");
		}

		try {
			assert entity.getDeadline() != null;
		} catch (AssertionError e1) {
			validDeadline = false;
			errors.state(request, false, "deadline", "administrator.challenge.form.error.timestamp");
		}

		if (validDeadline) {
			errors.state(request, entity.getDeadline().after(now), "deadline", "administrator.challenge.form.error.past-deadline");
		}

	}

	@Override
	public void update(final Request<Challenge> request, final Challenge entity) {
		assert request != null;
		assert entity != null;

		this.repository.save(entity);
	}

}
