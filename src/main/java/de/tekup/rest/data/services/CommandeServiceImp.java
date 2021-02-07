package de.tekup.rest.data.services;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.tekup.rest.data.models.Commande;
import de.tekup.rest.data.models.User;

import de.tekup.rest.data.repositories.CommandeRepository;
import de.tekup.rest.data.repositories.UserRepository;
@Service
public class CommandeServiceImp implements CommandService{
	@Autowired
	CommandeRepository cmdRepo;
	@Autowired
	private UserRepository UserRepository;

	@Override
	public void saveCommandToDB(String nom_prod, String desco, Double montant, String email_usr, String date_cmd,
			String nom_part,long idu,int quantity) {
		// TODO Auto-generated method stub
		
		Commande c=new Commande();
		c.setNom_prod(nom_prod);
		c.setDesco(desco);
		c.setMontant(montant);
		c.setNom_part(nom_part);
		c.setEmail_usr(email_usr);
		c.setDate_cmd(date_cmd);
		c.setQuatity(quantity);
		c.setUser(UserRepository.findById(idu).get());
		Double Q;
		Q=montant*quantity;
		Double s=(double) 0;
		User p =new User();
		p=UserRepository.findById(idu).get();
		if(p.getSolde()>=Q) {
			s=p.getSolde()-Q;
			p.setSolde(s);
			}else {
				
				throw new NoSuchElementException("votre solde est inferieure au montant");
			}


		cmdRepo.save(c);
		}	
		
	

	@Override
	public Commande getEntityById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
