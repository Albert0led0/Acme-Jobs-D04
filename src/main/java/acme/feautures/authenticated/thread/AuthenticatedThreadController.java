
package acme.feautures.authenticated.thread;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import acme.components.CustomCommand;
import acme.framework.components.BasicCommand;
import acme.framework.controllers.AbstractController;
import acme.framework.entities.Authenticated;

@Controller
@RequestMapping("/authenticated/thread/")
public class AuthenticatedThreadController extends AbstractController<Authenticated, Thread> {

	@Autowired
	private AuthenticatedThreadListInvolvedService	listActiveService;

	@Autowired
	private AuthenticatedThreadShowService			showService;


	@PostConstruct
	private void initialise() {
		super.addCustomCommand(CustomCommand.LIST_INVOLVED, BasicCommand.LIST, this.listActiveService);
		super.addBasicCommand(BasicCommand.SHOW, this.showService);
	}

}
