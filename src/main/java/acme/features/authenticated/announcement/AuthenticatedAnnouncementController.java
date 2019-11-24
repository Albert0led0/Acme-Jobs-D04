
package acme.features.authenticated.announcement;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import acme.components.CustomCommand;
import acme.entities.announcements.Announcement;
import acme.framework.components.BasicCommand;
import acme.framework.controllers.AbstractController;
import acme.framework.entities.Authenticated;

@Controller
@RequestMapping("/authenticated/announcement/")
public class AuthenticatedAnnouncementController extends AbstractController<Authenticated, Announcement> {

	@Autowired
	private AuthenticatedAnnouncementListMonthlyService	listMonthlyService;

	@Autowired
	private AuthenticatedAnnouncementShowService		showService;


	@PostConstruct
	private void initialise() {
		super.addCustomCommand(CustomCommand.LIST_MONTHLY, BasicCommand.LIST, this.listMonthlyService);
		super.addBasicCommand(BasicCommand.SHOW, this.showService);
	}

}
