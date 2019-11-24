
package acme.features.authenticated.offer;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import acme.components.CustomCommand;
import acme.entities.offers.Offer;
import acme.framework.components.BasicCommand;
import acme.framework.controllers.AbstractController;
import acme.framework.entities.Authenticated;

@Controller
@RequestMapping("/authenticated/offer/")
public class AuthenticatedOfferController extends AbstractController<Authenticated, Offer> {

	@Autowired
	private AuthenticatedOfferListActiveService	listActiveService;

	@Autowired
	private AuthenticatedOfferShowService		showService;


	@PostConstruct
	private void initialise() {
		super.addCustomCommand(CustomCommand.LIST_ACTIVE, BasicCommand.LIST, this.listActiveService);
		super.addBasicCommand(BasicCommand.SHOW, this.showService);
	}

}
