package de.tekup.rest.data.services;

import java.time.LocalDate;

import org.springframework.web.multipart.MultipartFile;

public interface ProductService {
	void saveProductToDB(MultipartFile file,String name,String description,Double prix,String quantity);

}
