package de.tekup.rest.data.services;



import org.springframework.web.multipart.MultipartFile;

import de.tekup.rest.data.models.ProductEntity;
import de.tekup.rest.data.models.UtilisateursEntity;

public interface ProductService {
	void saveProductToDB(MultipartFile file,String name,String description,Double prix,String quantity);
	ProductEntity getEntityById(long id);
	void saveProd(ProductEntity products);
	 

}
