package org.o7planning.sbjdbc.service;

import java.util.List;

import org.o7planning.sbjdbc.model.ClientInfo;

public interface ClientService {
	
	public ClientInfo saveClient(ClientInfo client);
	
	public ClientInfo getClientById(String codeClient);
	
	public List<ClientInfo> getClients();

}
