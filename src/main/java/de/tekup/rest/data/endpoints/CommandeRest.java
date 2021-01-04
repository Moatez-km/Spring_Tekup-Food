package de.tekup.rest.data.endpoints;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import de.tekup.rest.data.models.Commande;


import de.tekup.rest.data.repositories.CommandeRepository;
import de.tekup.rest.data.services.CommandService;


@Controller
public class CommandeRest {
	@Autowired
	CommandService cmd_service;
	@Autowired
	CommandeRepository cmd_repo;

	
	
	@PostMapping("/addCmd")
	public String saveCommande(@RequestParam ("nom_prod")String nom_prod, @RequestParam ("desc") String desco,@RequestParam ("montant") Double montant,@RequestParam ("email_usr") String email_usr,@RequestParam ("date_cmd") String date_cmd,
			@RequestParam ("nom_part") String nom_part,@RequestParam ("idu")long idu) {
				cmd_service.saveCommandToDB(nom_prod, desco, montant, email_usr, date_cmd, nom_part, idu);
				return "redirect:/commandSucc";
	}

	
	@GetMapping("/commandSucc")
	public String showcommandSucc() {
		return "/commandSucc.html";
		
	}
	
	
	@GetMapping("/listCommande")
	public String showlistCmd(Model model) {
		List<Commande> cmd = cmd_repo.findAll();
		model.addAttribute("commande",cmd);
		return "/listCommande.html";
		
	}
}
