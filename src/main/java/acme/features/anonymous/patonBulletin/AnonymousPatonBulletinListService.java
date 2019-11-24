
package acme.features.anonymous.patonBulletin;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.bulletins.PatonBulletin;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Anonymous;
import acme.framework.services.AbstractListService;

@Service
public class AnonymousPatonBulletinListService implements AbstractListService<Anonymous, PatonBulletin> {

	//Internal state -------------------------------------------

	@Autowired
	AnonymousPatonBulletinRepository repository;


	//AbstractListService<Administrator, PatonBulletin> interface ------

	@Override
	public boolean authorise(final Request<PatonBulletin> request) {
		assert request != null;

		return true;
	}

	@Override
	public Collection<PatonBulletin> findMany(final Request<PatonBulletin> request) {
		assert request != null;

		Collection<PatonBulletin> result;

		result = this.repository.findMany();

		return result;
	}

	@Override
	public void unbind(final Request<PatonBulletin> request, final PatonBulletin entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "author", "text", "moment", "company");
	}

}
