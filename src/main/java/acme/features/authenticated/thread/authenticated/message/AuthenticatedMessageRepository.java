
package acme.features.authenticated.thread.authenticated.message;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.messages.Message;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AuthenticatedMessageRepository extends AbstractRepository {

	@Query("select m from Message m where m.id = ?1")
	Message findOneById(int id);

	@Query("select m from Message m")
	Collection<Message> findAllMessages();

	@Query("select t from Thread t where t.authenticated.id = ?1")
	Collection<acme.entities.messages.Thread> findThreadMine(int authenticatedId);

}
