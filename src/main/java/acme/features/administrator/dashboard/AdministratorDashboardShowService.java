
package acme.features.administrator.dashboard;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.forms.Dashboard;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Administrator;
import acme.framework.services.AbstractShowService;

@Service
public class AdministratorDashboardShowService implements AbstractShowService<Administrator, Dashboard> {

	@Autowired
	private AdministratorDashboardRepository repository;


	@Override
	public boolean authorise(final Request<Dashboard> request) {
		assert request != null;

		return true;
	}

	@Override
	public void unbind(final Request<Dashboard> request, final Dashboard entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		Integer numberOfAnnouncements = this.repository.numberOfAnnouncements();
		Integer numberOfCompanyRecords = this.repository.numberOfCompanyRecords();
		Integer numberOfInvestorRecords = this.repository.numberOfInvestorRecords();

		List<Object[]> rewardActiveRequestsStats = new ArrayList<Object[]>(this.repository.activeRequestsRewardStats());
		Double minimumRewardActiveRequests = (Double) rewardActiveRequestsStats.get(0)[0];
		Double maximumRewardActiveRequests = (Double) rewardActiveRequestsStats.get(0)[1];
		Double averageRewardActiveRequests = (Double) rewardActiveRequestsStats.get(0)[2];
		Double stddevRewardActiveRequests = (Double) rewardActiveRequestsStats.get(0)[3];

		List<Object[]> minRewardActiveOffersStats = new ArrayList<Object[]>(this.repository.activeOffersMinRewardStats());
		Double minimumMinRewardActiveOffers = (Double) minRewardActiveOffersStats.get(0)[0];
		Double maximumMinRewardActiveOffers = (Double) minRewardActiveOffersStats.get(0)[1];
		Double averageMinRewardActiveOffers = (Double) minRewardActiveOffersStats.get(0)[2];
		Double stddevMinRewardActiveOffers = (Double) minRewardActiveOffersStats.get(0)[3];

		List<Object[]> maxRewardActiveOffersStats = new ArrayList<Object[]>(this.repository.activeOffersMaxRewardStats());
		Double minimumMaxRewardActiveOffers = (Double) maxRewardActiveOffersStats.get(0)[0];
		Double maximumMaxRewardActiveOffers = (Double) maxRewardActiveOffersStats.get(0)[1];
		Double averageMaxRewardActiveOffers = (Double) maxRewardActiveOffersStats.get(0)[2];
		Double stddevMaxRewardActiveOffers = (Double) maxRewardActiveOffersStats.get(0)[3];

		Double avgJobsPerEmployer = this.repository.avgJobsPerEmployer();
		Double avgApplicationsPerEmployer = this.repository.avgApplicationsPerEmployer();
		Double avgApplicationsPerWorker = this.repository.avgApplicationsPerWorker();

		List<Object[]> companiesAndSectors = new ArrayList<Object[]>(this.repository.companiesBySector());
		List<String> cSectors = new ArrayList<String>();
		List<Long> companiesBySector = new ArrayList<Long>();
		for (Object[] cs : companiesAndSectors) {
			cSectors.add((String) cs[0]);
			companiesBySector.add((Long) cs[1]);
		}

		List<Object[]> investorsAndSectors = new ArrayList<Object[]>(this.repository.investorsBySector());
		List<String> iSectors = new ArrayList<String>();
		List<Long> investorsBySector = new ArrayList<Long>();
		for (Object[] is : investorsAndSectors) {
			iSectors.add((String) is[0]);
			investorsBySector.add((Long) is[1]);
		}

		List<Object[]> ratioOfJobsByStatus = new ArrayList<Object[]>(this.repository.ratioOfJobsByStatus());
		Double ratioActiveJobs = 100 * (Double) ratioOfJobsByStatus.get(0)[0];
		Double ratioInactiveJobs = 100 * (Double) ratioOfJobsByStatus.get(0)[1];

		List<Object[]> ratioOfApplicationsByStatus = new ArrayList<Object[]>(this.repository.ratioOfApplicationsByStatus());
		Double ratioAcceptedApplications = 100 * (Double) ratioOfApplicationsByStatus.get(0)[0];
		Double ratioPendingApplications = 100 * (Double) ratioOfApplicationsByStatus.get(0)[1];
		Double ratioRejectedApplications = 100 * (Double) ratioOfApplicationsByStatus.get(0)[2];

		entity.setNumberOfAnnouncements(numberOfAnnouncements);
		entity.setNumberOfCompanyRecords(numberOfCompanyRecords);
		entity.setNumberOfInvestorRecords(numberOfInvestorRecords);

		entity.setMinimumRewardActiveRequests(minimumRewardActiveRequests);
		entity.setMaximumRewardActiveRequests(maximumRewardActiveRequests);
		entity.setAverageRewardActiveRequests(averageRewardActiveRequests);
		entity.setStddevRewardActiveRequests(stddevRewardActiveRequests);

		entity.setMinimumMinRewardActiveOffers(minimumMinRewardActiveOffers);
		entity.setMaximumMinRewardActiveOffers(maximumMinRewardActiveOffers);
		entity.setAverageMinRewardActiveOffers(averageMinRewardActiveOffers);
		entity.setStddevMinRewardActiveOffers(stddevMinRewardActiveOffers);

		entity.setMinimumMaxRewardActiveOffers(minimumMaxRewardActiveOffers);
		entity.setMaximumMaxRewardActiveOffers(maximumMaxRewardActiveOffers);
		entity.setAverageMaxRewardActiveOffers(averageMaxRewardActiveOffers);
		entity.setStddevMaxRewardActiveOffers(stddevMaxRewardActiveOffers);

		entity.setAvgJobsPerEmployer(avgJobsPerEmployer);
		entity.setAvgApplicationsPerEmployer(avgApplicationsPerEmployer);
		entity.setAvgApplicationsPerWorker(avgApplicationsPerWorker);

		entity.setCSectors(cSectors);
		entity.setCompaniesBySector(companiesBySector);

		entity.setISectors(iSectors);
		entity.setInvestorsBySector(investorsBySector);

		entity.setRatioActiveJobs(ratioActiveJobs);
		entity.setRatioInactiveJobs(ratioInactiveJobs);

		entity.setRatioAcceptedApplications(ratioAcceptedApplications);
		entity.setRatioPendingApplications(ratioPendingApplications);
		entity.setRatioRejectedApplications(ratioRejectedApplications);

		request.unbind(entity, model, "numberOfAnnouncements", "numberOfCompanyRecords", "numberOfInvestorRecords", "minimumRewardActiveRequests", "maximumRewardActiveRequests", "averageRewardActiveRequests", "stddevRewardActiveRequests",
			"minimumMinRewardActiveOffers", "maximumMinRewardActiveOffers", "averageMinRewardActiveOffers", "stddevMinRewardActiveOffers", "minimumMaxRewardActiveOffers", "maximumMaxRewardActiveOffers", "averageMaxRewardActiveOffers",
			"stddevMaxRewardActiveOffers", "cSectors", "companiesBySector", "iSectors", "investorsBySector", "avgJobsPerEmployer", "avgApplicationsPerEmployer", "avgApplicationsPerWorker", "ratioActiveJobs", "ratioInactiveJobs",
			"ratioAcceptedApplications", "ratioPendingApplications", "ratioRejectedApplications");

	}

	@Override
	public Dashboard findOne(final Request<Dashboard> request) {
		Dashboard d = new Dashboard();
		return d;
	}

}
