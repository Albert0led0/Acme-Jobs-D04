
package acme.features.auditor.auditRecord;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.auditRecords.AuditRecord;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AuditorAuditRecordRepository extends AbstractRepository {

	@Query("select ar from AuditRecord ar where ar.id = ?1")
	AuditRecord findOneById(int id);

	@Query("select ar from AuditRecord ar where ar.auditor.id = ?1")
	Collection<AuditRecord> findByMyAuditor(int auditorId);

	@Query("select ar from AuditRecord ar where ar.auditor.id <> ?1")
	Collection<AuditRecord> findNotMyAuditor(int auditorId);

}
