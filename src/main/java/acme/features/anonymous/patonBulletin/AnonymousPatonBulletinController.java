
package acme.features.anonymous.patonBulletin;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import acme.entities.bulletins.PatonBulletin;
import acme.framework.components.BasicCommand;
import acme.framework.controllers.AbstractController;
import acme.framework.entities.Anonymous;

@Controller
@RequestMapping("/anonymous/paton-bulletin/")
public class AnonymousPatonBulletinController extends AbstractController<Anonymous, PatonBulletin> {

	// Internal State ----------------------------------------------------

	@Autowired
	private AnonymousPatonBulletinListService	listService;

	@Autowired
	private AnonymousPatonBulletinCreateService	createService;


	// Constructors ------------------------------------------------------

	@PostConstruct
	private void initialise() {
		super.addBasicCommand(BasicCommand.LIST, this.listService);
		super.addBasicCommand(BasicCommand.CREATE, this.createService);
	}

}
