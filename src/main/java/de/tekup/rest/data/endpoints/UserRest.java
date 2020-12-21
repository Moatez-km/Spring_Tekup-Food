package de.tekup.rest.data.endpoints;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import de.tekup.rest.data.models.User;
import de.tekup.rest.data.services.UserService;


@Controller
public class UserRest {
	@Autowired
	private UserService UserService;
	
	@GetMapping("/users")
	public String viewHomePage(Model model,String keyword) {
		if(keyword!=null) {
			model.addAttribute("listUsers", UserService.findByKeyword(keyword));
		}else {
			model.addAttribute("listUsers", UserService.getAllUsers());
		}
		
		return "listUser";
		}
	@GetMapping("/showNewUserForm")
	public String showNewUserForm(Model model) {
		User user =new User();
		model.addAttribute("user", user);
		return "newUser";
		
		
	}
	@PostMapping("/saveUser")
	public String saveUser(@ModelAttribute("user") User user) {
		UserService.saveUser(user);
		return "redirect:/users";
		
		
		
		
	}
	@GetMapping("/showFormForUpdate/{id}")
	public String showFormForUpdate(@PathVariable(value = "id") long id,Model model) {
		User user =UserService.getUserById(id);
		model.addAttribute("user", user);
		return "update_user";
		
		}
	@GetMapping("/deleteById/{id}")
	public String deleteById(@PathVariable(value = "id") long id) {
		this.UserService.deleteUserById(id);
		return "redirect:/users";
		
		
		
		
	}

}
