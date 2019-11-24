
package acme.features.administrator.configurations;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import acme.components.CustomCommand;
import acme.entities.configurations.Configuration;
import acme.framework.components.BasicCommand;
import acme.framework.controllers.AbstractController;
import acme.framework.entities.Administrator;

@Controller
@RequestMapping("/administrator/configuration/")
public class AdministratorConfigurationController extends AbstractController<Administrator, Configuration> {

	//Internal state ---------------------------------------
	@Autowired
	private AdministratorConfigurationListService	listService;

	@Autowired
	private AdministratorConfigurationShowService	showService;

	@Autowired
	private AdministratorConfigurationUpdateService	updateService;


	//Constructors -----------------------------------------

	@PostConstruct
	private void initialise() {
		super.addBasicCommand(BasicCommand.SHOW, this.showService);
		super.addCustomCommand(CustomCommand.DISPLAY, BasicCommand.LIST, this.listService);
		super.addBasicCommand(BasicCommand.UPDATE, this.updateService);
	}

}
