
package acme.features.administrator.companyRecord;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.companyRecords.CompanyRecord;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Administrator;
import acme.framework.services.AbstractUpdateService;

@Service
public class AdministratorCompanyRecordUpdateService implements AbstractUpdateService<Administrator, CompanyRecord> {

	@Autowired
	private AdministratorCompanyRecordRepository repository;


	@Override
	public boolean authorise(final Request<CompanyRecord> request) {
		assert request != null;
		return true;
	}

	@Override
	public void bind(final Request<CompanyRecord> request, final CompanyRecord entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors);

	}

	@Override
	public void unbind(final Request<CompanyRecord> request, final CompanyRecord entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "company", "sector", "ceoName", "description", "webSite", "phoneNumber", "email", "stars", "incorporated");

	}

	@Override
	public CompanyRecord findOne(final Request<CompanyRecord> request) {
		assert request != null;

		CompanyRecord res;
		int id;

		id = request.getModel().getInteger("id");
		res = this.repository.findOneCompanyRecordById(id);

		return res;
	}

	@Override
	public void validate(final Request<CompanyRecord> request, final CompanyRecord entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

	}

	@Override
	public void update(final Request<CompanyRecord> request, final CompanyRecord entity) {
		assert request != null;
		assert entity != null;

		this.repository.save(entity);

	}

}
