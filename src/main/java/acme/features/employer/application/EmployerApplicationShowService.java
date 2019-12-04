
package acme.features.employer.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.applications.Application;
import acme.entities.jobs.Job;
import acme.entities.roles.Employer;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Principal;
import acme.framework.services.AbstractShowService;

@Service
public class EmployerApplicationShowService implements AbstractShowService<Employer, Application> {

	//internal state -------------------------------------------------------------

	@Autowired
	EmployerApplicationRepository repository;


	// AbstractListService<Employer, Job> interface ------------------------------

	@Override
	public boolean authorise(final Request<Application> request) {
		assert request != null;

		boolean res;
		int applicationId;
		Application app;
		Job job;
		Employer employer;
		Principal principal;

		applicationId = request.getModel().getInteger("id");
		app = this.repository.findOneApplicationById(applicationId);
		job = app.getJob();
		employer = job.getEmployer();
		principal = request.getPrincipal();
		res = employer.getUserAccount().getId() == principal.getAccountId();

		return res;
	}

	@Override
	public void unbind(final Request<Application> request, final Application entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "referenceNumber", "moment", "status");
		request.unbind(entity, model, "statement", "skills", "qualifications", "job");

	}

	@Override
	public Application findOne(final Request<Application> request) {
		assert request != null;

		Application res;
		int id;

		id = request.getModel().getInteger("id");
		res = this.repository.findOneApplicationById(id);

		return res;
	}

}
