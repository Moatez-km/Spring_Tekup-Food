package de.tekup.rest.data.endpoints;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import de.tekup.rest.data.repositories.ContactRepository;
import de.tekup.rest.data.services.ContactService;

@Controller
public class ContactRest {
	@Autowired
	ContactService contactService;
	@Autowired
	ContactRepository contactRepo;
	
	@PostMapping("/addcontact")
	public String saveContact(@RequestParam("email")String email,@RequestParam("message")String message,@RequestParam("date")String date) {
		
		contactService.saveContactToDB(email, message,date);

		return "redirect:/";
		
		
		
		
	}

	

	@GetMapping("/ViewContact")
	public String viewContactPage(Model model) {
		
		
			model.addAttribute("listContact", contactService.getAllContact());
		
		
		return "Contact";
		}
}
