
package acme.features.anonymous.investorRecord;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.investorRecords.InvestorRecord;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AnonymousInvestorRecordRepository extends AbstractRepository {

	@Query("select c from InvestorRecord c where c.id = ?1")
	InvestorRecord findOneById(int id);

	@Query("select c from InvestorRecord c")
	Collection<InvestorRecord> findManyAll();

	@Query("select c from InvestorRecord c where c.stars=5")
	Collection<InvestorRecord> findManyAllTop();
}
