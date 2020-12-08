package de.tekup.rest.data.services;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Base64;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


import de.tekup.rest.data.models.ProductEntity;
import de.tekup.rest.data.repositories.ProductRepository;
@Service
public class ProductServiceImp implements ProductService {
	@Autowired
	private ProductRepository productRepo;

	@Override
	public void saveProductToDB(MultipartFile file, String name, String description, Double prix, String quantity
			) {
		// TODO Auto-generated method stub
		ProductEntity p=new ProductEntity();
		String fileName=org.springframework.util.StringUtils.cleanPath(file.getOriginalFilename());
		if(fileName.contains("..")) {
			throw new NoSuchElementException("image not valid");
			}
		try {
			p.setImage(Base64.getEncoder().encodeToString(file.getBytes()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		p.setDescription(description);
		
		p.setPrix(prix);
		p.setQuantity(quantity);
		
		p.setName(name);
		
		productRepo.save(p);
	}

}
