package de.tekup.rest.data.services;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.stereotype.Service;

import de.tekup.rest.data.models.UtilisateursEntity;
import de.tekup.rest.data.repositories.UtilisateursRepository;
@Service
public class UtilisateursServiceImp implements UtilisateursService{
	private UtilisateursRepository reposUtili;
	
	public UtilisateursServiceImp(UtilisateursRepository reposUtili) {
		super();
		this.reposUtili = reposUtili;
	}

	@Override
	public List<UtilisateursEntity> getAllEntities() {
		// TODO Auto-generated method stub
		return reposUtili.findAll();
	}

	@Override
	public UtilisateursEntity getEntityById(long id) {
		// TODO Auto-generated method stub
		Optional<UtilisateursEntity> opt=reposUtili.findById(id);
		UtilisateursEntity entity;
		if(opt.isPresent()) 
			entity=opt.get();
		else
			throw new NoSuchElementException("Person with this Id is not found");
		
		return entity;
	}

	
	
	

}
