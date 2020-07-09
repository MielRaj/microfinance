package org.o7planning.sbjdbc.service;

import java.util.List;
import java.util.Optional;

import org.o7planning.sbjdbc.entity.Client;
import org.o7planning.sbjdbc.entity.Compteclient;
import org.o7planning.sbjdbc.repository.CompteClientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class CptClientDAO {
	
	@Autowired
    private CompteClientRepo cptRepository;
 
    
	public Compteclient createCompte(Compteclient cptToInsert) {
    	return this.cptRepository.save(cptToInsert);
    }
    
    public Compteclient updateCompte(Compteclient cptClient) {
        Optional < Compteclient > cptDb = this.cptRepository.findById(cptClient.getNumCompte());

        if (cptDb.isPresent()) {
        	Compteclient cptUpdate = cptDb.get();
        	cptUpdate.setNumCompte(cptClient.getNumCompte());
        	cptUpdate.setDateOuverture(cptClient.getDateOuverture());
        	cptUpdate.setEtat(cptClient.getEtat());
        	cptUpdate.setClient(cptClient.getClient());
            return cptUpdate;
        } else {
            //throw new ResourceNotFoundException("Record not found with id : " + client.getCodeClient());
        	System.err.println("no compte found");
        	return null;
        }
    }
    
    public List < Compteclient > getAllCompte() {
        return this.cptRepository.findAll();
    }


    public Compteclient getCptById(String numCpt) {

        Optional < Compteclient > cptDb = this.cptRepository.findById(numCpt);

        if (cptDb.isPresent()) {
            return cptDb.get();
        } else {
            //throw new ResourceNotFoundException("Record not found with id : " + productId);
        	System.err.println("no compte found");
        	return null;
        }
    }
    
    public List<Compteclient> getCptByClient(Client client) {

        List< Compteclient > cptDb = this.cptRepository.findByClient(client);

        if (!(cptDb.isEmpty())) {
            return cptDb;
        } else {
            //throw new ResourceNotFoundException("Record not found with id : " + productId);
        	System.err.println("no compte found");
        	return null;
        }
    }


    public void deleteClient(String numCompte) {
        Optional < Compteclient > cptDb = this.cptRepository.findById(numCompte);

        if (cptDb.isPresent()) {
            this.cptRepository.delete(cptDb.get());
        } else {
            //throw new ResourceNotFoundException("Record not found with id : " + productId);
        	System.err.println("no client found");
        }

    }

}
