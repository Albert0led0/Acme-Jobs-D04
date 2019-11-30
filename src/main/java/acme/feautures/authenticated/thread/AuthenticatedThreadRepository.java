
package acme.feautures.authenticated.thread;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.framework.repositories.AbstractRepository;

@Repository
public interface AuthenticatedThreadRepository extends AbstractRepository {

	@Query("select t from Thread t where t.id = ?1")
	Thread findOneById(int id);

	@Query("select t from Thread t where t.authenticated.id = ?1")
	Collection<Thread> findAuthenticatedInvolved(int authenticatedId);

}
