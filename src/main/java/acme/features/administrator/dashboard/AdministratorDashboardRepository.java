
package acme.features.administrator.dashboard;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.framework.repositories.AbstractRepository;

@Repository
public interface AdministratorDashboardRepository extends AbstractRepository {

	@Query("select count(a) from Announcement a")
	Integer numberOfAnnouncements();

	@Query("select count(cr) from CompanyRecord cr")
	Integer numberOfCompanyRecords();

	@Query("select count(ir) from InvestorRecord ir")
	Integer numberOfInvestorRecords();

	@Query("select min(r.reward.amount), max(r.reward.amount), avg(r.reward.amount), stddev(r.reward.amount) from Request r where r.deadline > CURRENT_TIMESTAMP")
	Collection<Object[]> activeRequestsRewardStats();

	@Query("select min(o.minReward.amount), max(o.minReward.amount), avg(o.minReward.amount), stddev(o.minReward.amount) from Offer o  where o.deadline > CURRENT_TIMESTAMP")
	Collection<Object[]> activeOffersMinRewardStats();

	@Query("select min(o.maxReward.amount), max(o.maxReward.amount), avg(o.maxReward.amount), stddev(o.maxReward.amount) from Offer o where o.deadline > CURRENT_TIMESTAMP")
	Collection<Object[]> activeOffersMaxRewardStats();

	@Query("select cr.sector, count(cr) from CompanyRecord cr group by cr.sector")
	Collection<Object[]> companiesBySector();

	@Query("select ir.sector, count(ir) from InvestorRecord ir group by ir.sector")
	Collection<Object[]> investorsBySector();

}
