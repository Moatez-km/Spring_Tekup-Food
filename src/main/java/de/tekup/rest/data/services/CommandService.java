package de.tekup.rest.data.services;



import de.tekup.rest.data.models.Commande;

public interface CommandService {
	void saveCommandToDB(String nom_prod,String desco,Double montant,String email_usr,String date_cmd,String nom_part,long idu);
	Commande getEntityById(long id);

}
