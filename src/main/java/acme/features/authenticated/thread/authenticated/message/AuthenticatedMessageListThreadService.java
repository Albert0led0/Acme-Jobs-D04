
package acme.features.authenticated.thread.authenticated.message;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.messages.Message;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Authenticated;
import acme.framework.services.AbstractListService;

@Service
public class AuthenticatedMessageListThreadService implements AbstractListService<Authenticated, Message> {

	@Autowired
	AuthenticatedMessageRepository repository;


	@Override
	public boolean authorise(final Request<Message> request) {
		assert request != null;

		return true;
	}

	@Override
	public void unbind(final Request<Message> request, final Message entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "moment", "title");

	}

	@Override
	public Collection<Message> findMany(final Request<Message> request) {
		assert request != null;

		Collection<Message> result;
		List<acme.entities.messages.Thread> threads;
		int principal = request.getPrincipal().getActiveRoleId();

		result = this.repository.findAllMessages();
		threads = result.stream().map(x -> x.getThread()).collect(Collectors.toList());

		Collection<acme.entities.messages.Thread> ids = this.repository.findThreadMine(principal);

		List<acme.entities.messages.Thread> threads2 = threads.stream().filter(x -> ids.contains(x)).collect(Collectors.toList());

		result = result.stream().filter(x -> threads2.contains(x.getThread())).collect(Collectors.toList());

		return result;
	}

}
