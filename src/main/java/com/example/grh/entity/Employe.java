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
@Table( name = "employe" )
public class Employe implements Serializable{

	@Id
    @GeneratedValue
    private Long   id;
    private String nom;
    private String prenom;
    private double note;
    private int heureAbs;
    @Column( name = "DATE_NAISS" )
    @Temporal( TemporalType.DATE )
    private Date   dateNaissance;
    
	public Employe() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employe(String nom, String prenom, double note, int heureAbs, Date dateNaissance) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.note = note;
		this.heureAbs = heureAbs;
		this.dateNaissance = dateNaissance;
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

	public double getNote() {
		return note;
	}

	public void setNote(double note) {
		this.note = note;
	}

	public int getHeureAbs() {
		return heureAbs;
	}

	public void setHeureAbs(int heureAbs) {
		this.heureAbs = heureAbs;
	}

	public Date getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}
	
    
	
	
	
}
