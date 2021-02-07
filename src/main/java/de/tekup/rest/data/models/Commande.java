package de.tekup.rest.data.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "commande")
public class Commande {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
private String nom_prod;
	
	private String desco;
	
	private Double montant;
	
	private String email_usr;
	
	private String date_cmd;
	
	private String nom_part;
	
	private int quatity;
	
	@ManyToOne
	private User user;

}
