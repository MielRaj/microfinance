package org.o7planning.sbjdbc.model;

import java.util.Date;
import java.util.List;

public class ClientInfo {
	private String codeClient;

	private String adresse;

	private int age;

	private Date dateSouscription;

	private String nomClient;

	private String prenomClient;

	private String profession;

	private String region;

	private boolean sexe;

	private List<CptClientInfo> compteclients;

	public ClientInfo() {
	}
	public ClientInfo(String code, String adresse, int age, Date dateSouscr, String nom, String prenom,
			String profess, String region, boolean sexe) {
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

	public Date getDateSouscription() {
		return this.dateSouscription;
	}

	public void setDateSouscription(Date dateSouscription) {
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

	public boolean getSexe() {
		return this.sexe;
	}

	public void setSexe(boolean sexe) {
		this.sexe = sexe;
	}

	public List<CptClientInfo> getCompteclients() {
		return this.compteclients;
	}

	public void setCompteclients(List<CptClientInfo> compteclients) {
		this.compteclients = compteclients;
	}

	public CptClientInfo addCompteclient(CptClientInfo compteclient) {
		getCompteclients().add(compteclient);
		compteclient.setClient(this);

		return compteclient;
	}

	public CptClientInfo removeCompteclient(CptClientInfo compteclient) {
		getCompteclients().remove(compteclient);
		compteclient.setClient(null);

		return compteclient;
	}

}
