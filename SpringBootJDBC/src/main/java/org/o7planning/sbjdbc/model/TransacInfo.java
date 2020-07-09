package org.o7planning.sbjdbc.model;

import java.util.Date;

public class TransacInfo {
	private String codeTransac;

	private Date dateTransac;

	private double montant;

	private String typeTransac;

	private CptClientInfo compteclient;

	public TransacInfo() {
	}
	
	public TransacInfo(String codeTransac, Date dateTransac, double montant, String typeTransac, CptClientInfo cptClient) {
		this.codeTransac = codeTransac;
		this.dateTransac = dateTransac;
		this.montant = montant;
		this.typeTransac = typeTransac;
		this.compteclient = cptClient;
	}

	public String getCodeTransac() {
		return this.codeTransac;
	}

	public void setCodeTransac(String codeTransac) {
		this.codeTransac = codeTransac;
	}

	public Date getDateTransac() {
		return this.dateTransac;
	}

	public void setDateTransac(Date dateTransac) {
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

	public CptClientInfo getCompteclient() {
		return this.compteclient;
	}

	public void setCompteclient(CptClientInfo compteclient) {
		this.compteclient = compteclient;
	}
}
