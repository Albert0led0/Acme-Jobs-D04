
package acme.features.authenticated.job;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.auditRecords.AuditRecord;
import acme.entities.jobs.Job;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AuthenticatedJobRepository extends AbstractRepository {

	@Query("select j from Job j where j.id = ?1")
	Job findOneJobById(int id);

	@Query("select j from Job j")
	Collection<Job> findAllJobs();

	@Query("select ar from AuditRecord ar where ar.auditor.id = ?1")
	Collection<AuditRecord> findByMyAuditor(int auditorId);

	@Query("select ar from AuditRecord ar where ar.auditor.id <> ?1")
	Collection<AuditRecord> findNotMyAuditor(int auditorId);

}
