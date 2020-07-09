package org.o7planning.sbjdbc.service;

import java.util.List;

import org.o7planning.sbjdbc.model.CptClientInfo;

public interface CompteService {
	
	public CptClientInfo saveCompte(CptClientInfo compte);
	
	public CptClientInfo getCompteByCode(String numCode);
	
	public List<CptClientInfo> getAllCompte();

}
