
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

	@Query("select avg(select count(j) from Job j where e.id = j.employer.id) from Employer e")
	Double avgJobsPerEmployer();

	@Query("select avg(select count(a) from Application a where e.id = a.job.employer) from Employer e")
	Double avgApplicationsPerEmployer();

	@Query("select avg(select count(a) from Application a where w.id = a.worker.id) from Worker w")
	Double avgApplicationsPerWorker();

	@Query("select 1.0*(select count(j1) from Job j1 where j1.draft = true and j1.deadline > CURRENT_TIMESTAMP)/count(j), 1.0*(select count(j2) from Job j2 where j2.draft = false or j2.deadline < CURRENT_TIMESTAMP)/count(j) from Job j")
	Collection<Object[]> ratioOfJobsByStatus();

	@Query("select 1.0*(select count(a1) from Application a1 where a1.status = 'accepted')/count(a), 1.0*(select count(a2) from Application a2 where a2.status = 'pending')/count(a), 1.0*(select count(a3) from Application a3 where a3.status = 'rejected')/count(a) from Application a")
	Collection<Object[]> ratioOfApplicationsByStatus();
}
