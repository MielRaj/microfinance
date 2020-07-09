package org.o7planning.sbjdbc.service;

import java.util.List;
import java.util.Optional;

import org.o7planning.sbjdbc.entity.Client;
import org.o7planning.sbjdbc.repository.ClientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ClientDAO {
	
	@Autowired
    private ClientRepo clientRepository;
 
    
	public Client createClient(Client clientToInsert) {
    	return this.clientRepository.save(clientToInsert);
    }
    
    public Client updateClient(Client client) {
        Optional < Client > clientDb = this.clientRepository.findById(client.getCodeClient());

        if (clientDb.isPresent()) {
            Client clientUpdate = clientDb.get();
            clientUpdate.setCodeClient(client.getCodeClient());
            clientUpdate.setAdresse(client.getAdresse());
            clientUpdate.setAge(client.getAge());
            clientUpdate.setDateSouscription(client.getDateSouscription());
            clientUpdate.setNomClient(client.getNomClient());
            clientUpdate.setPrenomClient(client.getPrenomClient());
            clientUpdate.setProfession(client.getProfession());
            clientUpdate.setRegion(client.getRegion());
            clientUpdate.setSexe(client.getSexe());
            return clientUpdate;
        } else {
            //throw new ResourceNotFoundException("Record not found with id : " + client.getCodeClient());
        	System.err.println("no client found");
        	return null;
        }
    }
    
    public List < Client > getAllClient() {
        return this.clientRepository.findAll();
    }


    public Client getClientById(String clientId) {

        Optional < Client > clientDb = this.clientRepository.findById(clientId);

        if (clientDb.isPresent()) {
            return clientDb.get();
        } else {
            //throw new ResourceNotFoundException("Record not found with id : " + productId);
        	System.err.println("no client found");
        	return null;
        }
    }


    public void deleteClient(String codeClient) {
        Optional < Client > clientDb = this.clientRepository.findById(codeClient);

        if (clientDb.isPresent()) {
            this.clientRepository.delete(clientDb.get());
        } else {
            //throw new ResourceNotFoundException("Record not found with id : " + productId);
        	System.err.println("no client found");
        }

    }
    
}
