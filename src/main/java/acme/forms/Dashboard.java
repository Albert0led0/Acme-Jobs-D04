
package acme.forms;

import java.io.Serializable;
import java.util.Collection;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Dashboard implements Serializable {

	// Serialisation identifier -------------------------------------------------------
	private static final long	serialVersionUID	= 1L;

	//Attributes ----------------------------------------------------------------------

	Integer						numberOfAnnouncements;
	Integer						numberOfCompanyRecords;
	Integer						numberOfInvestorRecords;

	Double						minimumRewardActiveRequests;
	Double						maximumRewardActiveRequests;
	Double						averageRewardActiveRequests;
	Double						stddevRewardActiveRequests;

	Double						minimumMinRewardActiveOffers;
	Double						maximumMinRewardActiveOffers;
	Double						averageMinRewardActiveOffers;
	Double						stddevMinRewardActiveOffers;

	Double						minimumMaxRewardActiveOffers;
	Double						maximumMaxRewardActiveOffers;
	Double						averageMaxRewardActiveOffers;
	Double						stddevMaxRewardActiveOffers;

	Double						avgJobsPerEmployer;
	Double						avgApplicationsPerEmployer;
	Double						avgApplicationsPerWorker;

	Collection<String>			cSectors;
	Collection<Long>			companiesBySector;

	Collection<String>			iSectors;
	Collection<Long>			investorsBySector;

	Double						ratioActiveJobs;
	Double						ratioInactiveJobs;

	Double						ratioAcceptedApplications;
	Double						ratioPendingApplications;
	Double						ratioRejectedApplications;
}
