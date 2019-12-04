
package acme.features.authenticated.thread;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Authenticated;
import acme.framework.entities.Principal;
import acme.framework.services.AbstractListService;

@Service
public class AuthenticatedThreadListMineService implements AbstractListService<Authenticated, acme.entities.messages.Thread> {

	@Autowired
	AuthenticatedThreadRepository repository;


	@Override
	public boolean authorise(final Request<acme.entities.messages.Thread> request) {
		assert request != null;

		return true;
	}

	@Override
	public void unbind(final Request<acme.entities.messages.Thread> request, final acme.entities.messages.Thread entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "moment", "title");

	}

	@Override
	public Collection<acme.entities.messages.Thread> findMany(final Request<acme.entities.messages.Thread> request) {
		assert request != null;

		Collection<acme.entities.messages.Thread> result;
		Principal principal;

		principal = request.getPrincipal();
		result = this.repository.findAuthenticatedInvolved(principal.getActiveRoleId());

		return result;
	}

}
