package de.tekup.rest.data.models;



import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;
@Entity
@Data
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
    @Column(name = "nom",length = 50,nullable = false)
	private String nom;
    @Column(name = "prenom",length = 50,nullable = false)
	private String prenom;
	
    
  
    
	@Column(name = "email",length = 50,nullable = false,unique = true)
	private String email;
	
	private String password;
	
	private Double solde;
	private String type;
	@OneToMany(mappedBy = "user")
	private List<ProductEntity> produit;
	
	@OneToMany(mappedBy = "user")
	private List<Commande> commande;

}
