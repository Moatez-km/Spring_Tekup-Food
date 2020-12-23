package de.tekup.rest.data.endpoints;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import de.tekup.rest.data.models.User;
import de.tekup.rest.data.services.UserService;


@Controller
public class UserRest {
	@Autowired
	private UserService UserService;
	@GetMapping("/login")
	public String showLoginPage() {
		return "/login.html";
		
	}
	
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
	@PostMapping("/login")
	public String userbyemail(@RequestParam("email") String email, @RequestParam("password")String password,HttpSession  session ,Model model) {
		
		User user=UserService.getUserByEmailAndPassword(email, password);
		System.out.println(user);
		if(user!=null) {
			if(user.getType().equals("admin")) {
				return "redirect:/users";
			}if(user.getType().equals("partenaire")) {
				model.addAttribute("users", user);
			
				session.setAttribute("users", user);
				return "/listProduct.html";
			}
			
		}
		return "redirect:/login";
		
	} 
	

}
