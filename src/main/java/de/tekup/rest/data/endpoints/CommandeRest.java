package de.tekup.rest.data.endpoints;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


import de.tekup.rest.data.services.CommandService;


@Controller
public class CommandeRest {
	@Autowired
	CommandService cmd_service;

	
	
	@PostMapping("/addCmd")
	public String saveCommande(@RequestParam ("nom_prod")String nom_prod, @RequestParam ("desc") String desc,@RequestParam ("montant") Double montant,@RequestParam ("email_usr") String email_usr,@RequestParam ("date_cmd") String date_cmd,
			@RequestParam ("nom_part") String nom_part,@RequestParam ("idu")long idu) {
				cmd_service.saveCommandToDB(nom_prod, desc, montant, email_usr, date_cmd, nom_part, idu);
				return "/menu";
	}

}
