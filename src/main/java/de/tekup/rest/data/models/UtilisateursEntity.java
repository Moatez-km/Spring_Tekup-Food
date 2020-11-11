package de.tekup.rest.data.models;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;



@Entity
@Table(name = "utilisateurs")
public class UtilisateursEntity {
	
	
	public UtilisateursEntity(String nom, String prenom, LocalDate date_naiss, String email, String password) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.date_naiss = date_naiss;
		this.email = email;
		this.password = password;
	}

	public UtilisateursEntity() {
		super();
	}

	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public LocalDate getDate_naiss() {
		return date_naiss;
	}

	public void setDate_naiss(LocalDate date_naiss) {
		this.date_naiss = date_naiss;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


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
