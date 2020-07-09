package org.o7planning.sbjdbc.service.impl;

import java.util.List;

import org.o7planning.sbjdbc.model.ClientInfo;
import org.o7planning.sbjdbc.repository.ClientRepo;
import org.o7planning.sbjdbc.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceImpl implements ClientService {
	
	@Autowired
	private ClientRepo clientRepository;

	@Override
	public ClientInfo saveClient(ClientInfo client) {
		ClientInfo clientBean = new ClientInfo(clientRepository.save(client.toClientEntity()));
		return clientBean;
	}

	@Override
	public ClientInfo getClientById(String codeClient) {
		
		return null;
	}

	@Override
	public List<ClientInfo> getClients() {
		
		return null;
	}
	
	

}
