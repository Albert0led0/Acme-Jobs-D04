
package acme.features.authenticated.job;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.jobs.Job;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AuthenticatedJobRepository extends AbstractRepository {

	@Query("select j from Job j where j.id = ?1")
	Job findOneJobById(int id);

	@Query("select j from Job j")
	Collection<Job> findAllJobs();

	@Query("select ar.job from AuditRecord ar where ar.auditor.id = ?1")
	Collection<Job> findJobsByAuditMine(int auditorId);

	@Query("select distinct ar.job from AuditRecord ar where ar.auditor.id <> ?1")
	Collection<Job> findJobsByAuditNotMine(int auditorId);

}
