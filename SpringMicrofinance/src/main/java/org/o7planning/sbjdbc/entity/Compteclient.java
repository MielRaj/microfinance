package org.o7planning.sbjdbc.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;


/**
 * The persistent class for the compteclient database table.
 * 
 */
@Entity
//@NamedQuery(name="Compteclient.findAll", query="SELECT c FROM Compteclient c")
public class Compteclient implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String num_compte;

	private String dateOuverture;

	private String etat;

	private double solde;

	//bi-directional many-to-one association to Client
	@ManyToOne
	private Client client;

	//bi-directional many-to-one association to Transaction
	@OneToMany(mappedBy="compteclient")
	@Transient
	private List<Transaction> transactions;

	public Compteclient() {
	}
	
	public Compteclient(String num, String date, String etat, double solde, Client client) {
		this.num_compte = num;
		this.dateOuverture = date;
		this.etat = etat;
		this.solde = solde;
		this.client = client;
	}

	public String getNumCompte() {
		return this.num_compte;
	}

	public void setNumCompte(String num_compte) {
		this.num_compte = num_compte;
	}

	public String getDateOuverture() {
		return this.dateOuverture;
	}

	public void setDateOuverture(String dateOuverture) {
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

	public Client getClient() {
		return this.client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public List<Transaction> getTransactions() {
		return this.transactions;
	}

	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}

	public Transaction addTransaction(Transaction transaction) {
		getTransactions().add(transaction);
		transaction.setCompteclient(this);

		return transaction;
	}

	public Transaction removeTransaction(Transaction transaction) {
		getTransactions().remove(transaction);
		transaction.setCompteclient(null);

		return transaction;
	}

}