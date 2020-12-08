package de.tekup.rest.data.endpoints;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
			@RequestParam("prix") Double prix,@RequestParam("desc") String description,@RequestParam("quantity") String quantity) {
		
		productService.saveProductToDB(file, name, description, prix, quantity);
		
		
		return "redirect:/listProduct.html";
		
		
		
	}
	
	

}
