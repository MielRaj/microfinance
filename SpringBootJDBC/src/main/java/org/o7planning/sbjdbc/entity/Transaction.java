package org.o7planning.sbjdbc.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


/**
 * The persistent class for the transaction database table.
 * 
 */
@Entity
//@NamedQuery(name="Transaction.findAll", query="SELECT t FROM Transaction t")
public class Transaction implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String codeTransac;

	private String dateTransac;

	private double montant;

	private String typeTransac;

	//bi-directional many-to-one association to Compteclient
	@ManyToOne
	private Compteclient compteclient;

	public Transaction() {
	}

	public String getCodeTransac() {
		return this.codeTransac;
	}

	public void setCodeTransac(String codeTransac) {
		this.codeTransac = codeTransac;
	}

	public String getDateTransac() {
		return this.dateTransac;
	}

	public void setDateTransac(String dateTransac) {
		this.dateTransac = dateTransac;
	}

	public double getMontant() {
		return this.montant;
	}

	public void setMontant(double montant) {
		this.montant = montant;
	}

	public String getTypeTransac() {
		return this.typeTransac;
	}

	public void setTypeTransac(String typeTransac) {
		this.typeTransac = typeTransac;
	}

	public Compteclient getCompteclient() {
		return this.compteclient;
	}

	public void setCompteclient(Compteclient compteclient) {
		this.compteclient = compteclient;
	}

}