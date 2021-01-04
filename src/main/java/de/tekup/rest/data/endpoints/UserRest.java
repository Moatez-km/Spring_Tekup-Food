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

import de.tekup.rest.data.repositories.UserRepository;
import de.tekup.rest.data.services.UserService;


@Controller
public class UserRest {
	@Autowired
	private UserService UserService;
	@Autowired
	private UserRepository UserRepository;
	
	
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
	@PostMapping("/updateSold")
	public String changeSold(@RequestParam("id") Long id, @RequestParam("sold") Double solde) {
		
		Double s=(double) 0;
		User p =new User();
		p=UserRepository.findById(id).get();
		s=p.getSolde()+solde;
		p.setSolde(s);
		UserRepository.save(p);
		
		
		
		return "redirect:/users";
		
		
	} 
	@GetMapping("/deleteById/{id}")
	public String deleteById(@PathVariable(value = "id") long id) {
		this.UserService.deleteUserById(id);
		return "redirect:/users";
		
		
		
		
	}
	@PostMapping("/login")
	public String userbyemail(@RequestParam("email") String email, @RequestParam("password")String password,HttpSession  session ,Model model) {
		
		User user=UserService.getUserByEmailAndPassword(email, password);
		
		if(user!=null) {
			if(user.getType().equals("admin")) {
				
				session.setAttribute("sold",user.getNom());
				
				return "redirect:/users";
			}if(user.getType().equals("partenaire")) {
				model.addAttribute("users", user);
			
				session.setAttribute("sold",user.getNom());
				session.setAttribute("users", user);
				return "redirect:/listProduct.html";
			}if(user.getType().equals("client")) {
				
				session.setAttribute("sold",user.getSolde());
				session.setAttribute("email",user.getEmail());
				session.setAttribute("users", user);
				return "redirect:/menu";
			}
			
		}
		return "redirect:/login";
		
	} 
	

}
