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
			throw new NoSuchElementException("Utilisateur with this Id is not found");
		
		return entity;
	}

	@Override
	public  UtilisateursEntity createUtilisateurs(UtilisateursEntity utilisateurRequest) {
		// TODO Auto-generated method stub
		
	
		return reposUtili.save(utilisateurRequest);
	}

	@Override
	public UtilisateursEntity rechargeSolde(long id, UtilisateursEntity newUtilisateur) {
		UtilisateursEntity oldUtilisateur =this.getEntityById(id);
		double s = 0;
		if(newUtilisateur.getId()!= 0) {
			s+= oldUtilisateur.getSolde()+newUtilisateur.getSolde();
		    oldUtilisateur.setSolde(s);
		}else
			throw new NoSuchElementException("Utilisateur with this Id is not found");
		
		
		return reposUtili.save(oldUtilisateur);
	}

	@Override
	public UtilisateursEntity modifyUtilisateur(long id, UtilisateursEntity newUtilisateur) {
		UtilisateursEntity oldUtilisateur=this.getEntityById(id);
		if(newUtilisateur.getNom()!=null)
			oldUtilisateur.setNom(newUtilisateur.getNom());
		if(newUtilisateur.getPrenom()!=null)
			oldUtilisateur.setPrenom(newUtilisateur.getPrenom());
		if(newUtilisateur.getEmail()!=null)
			oldUtilisateur.setEmail(newUtilisateur.getEmail());
		if(newUtilisateur.getDate_naiss()!=null)
			oldUtilisateur.setDate_naiss(newUtilisateur.getDate_naiss());
		if(newUtilisateur.getPassword()!=null)
			oldUtilisateur.setPassword(newUtilisateur.getPassword());
			
		
		
		return reposUtili.save(oldUtilisateur);
	}

	

	
	
	
	

}
