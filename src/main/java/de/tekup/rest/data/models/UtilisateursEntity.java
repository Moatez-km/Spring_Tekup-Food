package de.tekup.rest.data.models;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;


@Data
@Entity
@Table(name = "utilisateurs")
public class UtilisateursEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
    @Column(name = "nom",length = 50,nullable = false)
	private String nom;
    @Column(name = "prenom",length = 50,nullable = false)
	private String prenom;
	
    
    private LocalDate date_naiss;
    
	@Column(name = "email",length = 50,nullable = false,unique = true)
	private String email;
	
	private String password;
	
	

}
