package com.example.grh.entity;
import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table( name = "user" )
public class User implements Serializable{

	    
		@Id
	    @GeneratedValue
	    private Long   id;
	    private String nom;
	    private String prenom;
	    private String login;
	    private String password;
	    
	
	    public User() {
			super();
			// TODO Auto-generated constructor stub
		}


		public User(String nom, String prenom, String login, String password) {
			super();
			this.nom = nom;
			this.prenom = prenom;
			this.login = login;
			this.password = password;
		}


		public Long getId() {
			return id;
		}


		public void setId(Long id) {
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


		public String getLogin() {
			return login;
		}


		public void setLogin(String login) {
			this.login = login;
		}


		public String getPassword() {
			return password;
		}


		public void setPassword(String password) {
			this.password = password;
		}
	    
		
		
	    
	
}
