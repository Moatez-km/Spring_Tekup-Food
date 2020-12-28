package de.tekup.rest.data.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity
@Data
public class Commande {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String nom_prod;
	
	private String desc;
	
	private Double montant;
	
	private String email_usr;
	
	private String date_cmd;
	
	private String nom_part;
	
	@ManyToOne
	private User user;

}
