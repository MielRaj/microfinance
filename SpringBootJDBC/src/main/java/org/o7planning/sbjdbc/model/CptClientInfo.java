package org.o7planning.sbjdbc.model;

import java.util.Date;
import java.util.List;

public class CptClientInfo {
	private String numCompte;

	private Date dateOuverture;

	private String etat;

	private double solde;

	private ClientInfo client;

	private List<TransacInfo> transactions;

	public CptClientInfo() {
	}
	
	public CptClientInfo(String numCpt, Date dateOuv, String etat, double solde, ClientInfo client, List<TransacInfo> transac) {
		this.numCompte = numCpt;
		this.dateOuverture = dateOuv;
		this.etat = etat;
		this.solde = solde;
		this.client = client;
		this.transactions = transac;
	}

	public String getNumCompte() {
		return this.numCompte;
	}

	public void setNumCompte(String numCompte) {
		this.numCompte = numCompte;
	}

	public Date getDateOuverture() {
		return this.dateOuverture;
	}

	public void setDateOuverture(Date dateOuverture) {
		this.dateOuverture = dateOuverture;
	}

	public String getEtat() {
		return this.etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}

	public double getSolde() {
		return this.solde;
	}

	public void setSolde(double solde) {
		this.solde = solde;
	}

	public ClientInfo getClient() {
		return this.client;
	}

	public void setClient(ClientInfo client) {
		this.client = client;
	}

	public List<TransacInfo> getTransactions() {
		return this.transactions;
	}

	public void setTransactions(List<TransacInfo> transactions) {
		this.transactions = transactions;
	}

	public TransacInfo addTransaction(TransacInfo transaction) {
		getTransactions().add(transaction);
		transaction.setCompteclient(this);

		return transaction;
	}

	public TransacInfo removeTransaction(TransacInfo transaction) {
		getTransactions().remove(transaction);
		transaction.setCompteclient(null);

		return transaction;
	}
}
