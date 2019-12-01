
package acme.features.auditor.auditRecord;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import acme.components.CustomCommand;
import acme.entities.auditRecords.AuditRecord;
import acme.entities.roles.Auditor;
import acme.framework.components.BasicCommand;
import acme.framework.controllers.AbstractController;

@Controller
@RequestMapping("/auditor/audit-record/")
public class AuditorAuditRecordController extends AbstractController<Auditor, AuditRecord> {

	@Autowired
	private AuditorAuditRecordListMineService		listMineService;

	@Autowired
	private AuditorAuditRecordListNotMineService	listNotMineService;

	@Autowired
	private AuditorAuditRecordShowService			showService;


	@PostConstruct
	private void initialise() {
		super.addCustomCommand(CustomCommand.LIST_WRITTEN, BasicCommand.LIST, this.listMineService);
		super.addCustomCommand(CustomCommand.LIST_NOTWRITTEN, BasicCommand.LIST, this.listNotMineService);
		super.addBasicCommand(BasicCommand.SHOW, this.showService);
	}

}
