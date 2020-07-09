package org.o7planning.sbjdbc.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;


/**
 * The persistent class for the client database table.
 * 
 */
@Entity
//@NamedQuery(name="Client.findAll", query="SELECT c FROM Client c")
public class Client implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String codeClient;

	private String adresse;

	private int age;

	private String dateSouscription;

	private String nomClient;

	private String prenomClient;

	private String profession;

	private String region;

	private char sexe;

	//bi-directional many-to-one association to Compteclient
	@OneToMany(mappedBy="client")
	@Transient
	private List<Compteclient> compteclients;

	public Client() {
	}
	
	public Client(String code, String adresse, int age, String dateSouscr, String nom, String prenom,
			String profess, String region, char sexe) {
		super();
		this.codeClient = code;
		this.adresse = adresse;
		this.age = age;
		this.dateSouscription = dateSouscr;
		this.nomClient = nom;
		this.prenomClient = prenom;
		this.profession = profess;
		this.region = region;
		this.sexe = sexe;
	}

	public String getCodeClient() {
		return this.codeClient;
	}

	public void setCodeClient(String codeClient) {
		this.codeClient = codeClient;
	}

	public String getAdresse() {
		return this.adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public int getAge() {
		return this.age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getDateSouscription() {
		return this.dateSouscription;
	}

	public void setDateSouscription(String dateSouscription) {
		
		this.dateSouscription = dateSouscription;
	}

	public String getNomClient() {
		return this.nomClient;
	}

	public void setNomClient(String nomClient) {
		this.nomClient = nomClient;
	}

	public String getPrenomClient() {
		return this.prenomClient;
	}

	public void setPrenomClient(String prenomClient) {
		this.prenomClient = prenomClient;
	}

	public String getProfession() {
		return this.profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

	public String getRegion() {
		return this.region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public char getSexe() {
		return this.sexe;
	}

	public void setSexe(char sexe) {
		this.sexe = sexe;
	}

	public List<Compteclient> getCompteclients() {
		return this.compteclients;
	}

	public void setCompteclients(List<Compteclient> compteclients) {
		this.compteclients = compteclients;
	}

	public Compteclient addCompteclient(Compteclient compteclient) {
		getCompteclients().add(compteclient);
		compteclient.setClient(this);

		return compteclient;
	}

	public Compteclient removeCompteclient(Compteclient compteclient) {
		getCompteclients().remove(compteclient);
		compteclient.setClient(null);

		return compteclient;
	}

}