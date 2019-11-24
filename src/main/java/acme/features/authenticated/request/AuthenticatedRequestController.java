
package acme.features.authenticated.request;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import acme.components.CustomCommand;
import acme.entities.requests.Request;
import acme.framework.components.BasicCommand;
import acme.framework.controllers.AbstractController;
import acme.framework.entities.Authenticated;

@Controller
@RequestMapping("/authenticated/request/")
public class AuthenticatedRequestController extends AbstractController<Authenticated, Request> {

	@Autowired
	private AuthenticatedRequestListActiveService	listActiveService;

	@Autowired
	private AuthenticatedRequestShowService			showService;


	@PostConstruct
	private void initialise() {
		super.addCustomCommand(CustomCommand.LIST_ACTIVE, BasicCommand.LIST, this.listActiveService);
		super.addBasicCommand(BasicCommand.SHOW, this.showService);
	}

}
