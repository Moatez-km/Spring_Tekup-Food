package de.tekup.rest.data.endpoints;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import de.tekup.rest.data.models.ProductEntity;
import de.tekup.rest.data.repositories.ProductRepository;
import de.tekup.rest.data.services.ProductService;

@Controller
public class ProductRest {
	@Autowired
	private ProductRepository productRepo;
	@Autowired
	private ProductService productService ;
	
	@GetMapping("/log")
	public String showLogin2Page() {
		return "/login.html";
		
	}
	@GetMapping("/addProduct.html")
	public String showAddProduct() {
		return "/addProduct.html";
		
	}
	@GetMapping("/listProduct.html")
	public String showExampleView(Model model) {
		List<ProductEntity> products = productRepo.findAll();
		model.addAttribute("products", products);
		return "/listProduct.html";
		
	}
	
	@PostMapping("/addP")
	public String saveProduct(@RequestParam("file") MultipartFile file ,@RequestParam("pname") String name,
			@RequestParam("prix") Double prix,@RequestParam("desc") String description,@RequestParam("quantity") int quantity,@RequestParam("idU") long idu) {
		
		productService.saveProductToDB(file, name, description, prix, quantity,idu);
		
		
		return "redirect:/listProduct.html";
		
		
		
	}
	
	/*@GetMapping("/showFromForUpdate/{id}")
	public String showFromForUpdate(@PathVariable(value = "id") long id,Model model) {
		ProductEntity products=productService.getEntityById(id);
		model.addAttribute("products", products);
		
		return "update_product";
		
		
		
	}*/
	@PostMapping("/saveProduct")
	public String saveProduct(@ModelAttribute("products") ProductEntity products) {
		productService.saveProd(products);
		return "redirect:/listProduct.html";
		
		
	}
	@GetMapping("/deleteProd/{id}")
	public String deleteProduct(@PathVariable("id") Long id) {
		
		
		productRepo.deleteById(id);
		return "redirect:/listProduct.html";
		
		
	}
	
	@PostMapping("/updateProd")
	public String changePdesc(@RequestParam("id") Long id, @RequestParam("name") String name, @RequestParam("description") String description, @RequestParam("prix") Double prix, @RequestParam("quantity") int quantity) {
		
		
		ProductEntity p =new ProductEntity();
		p=productRepo.findById(id).get();
		p.setName(name);
		p.setDescription(description);
		p.setPrix(prix);
		p.setQuantity(quantity);
		productRepo.save(p);
		return "redirect:/listProduct.html";
		
		
	} 

}
