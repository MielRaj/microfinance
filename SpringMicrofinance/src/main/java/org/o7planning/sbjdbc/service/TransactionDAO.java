package org.o7planning.sbjdbc.service;

import java.util.List;
import java.util.Optional;

import org.o7planning.sbjdbc.entity.Transaction;
import org.o7planning.sbjdbc.repository.TransactionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TransactionDAO {
	
	@Autowired
    private TransactionRepo transacRepository;
 
    
	public void createTransac(Transaction transac) {
		this.transacRepository.save(transac);
    }
    
    public Transaction updateTransac(Transaction transac) {
        Optional < Transaction > transacDb = this.transacRepository.findById(transac.getCodeTransac());

        if (transacDb.isPresent()) {
        	Transaction transacUpdate = transacDb.get();
        	transacUpdate.setCodeTransac(transac.getCodeTransac());
        	transacUpdate.setDateTransac(transac.getDateTransac());
        	transacUpdate.setMontant(transac.getMontant());
        	transacUpdate.setTypeTransac(transac.getTypeTransac());
        	transacUpdate.setCompteclient(transac.getCompteclient());
            return transacUpdate;
        } else {
            //throw new ResourceNotFoundException("Record not found with id : " + client.getCodeClient());
        	System.err.println("no transaction found");
        	return null;
        }
    }
    
    public List < Transaction > getAllTransac() {
        return this.transacRepository.findAll();
    }


    public Transaction getTransacById(String transacId) {

        Optional < Transaction > transacDb = this.transacRepository.findById(transacId);

        if (transacDb.isPresent()) {
            return transacDb.get();
        } else {
            //throw new ResourceNotFoundException("Record not found with id : " + productId);
        	System.err.println("no transaction found");
        	return null;
        }
    }


    public void deleteClient(String codeClient) {
        Optional < Transaction > transacDb = this.transacRepository.findById(codeClient);

        if (transacDb.isPresent()) {
            this.transacRepository.delete(transacDb.get());
        } else {
            //throw new ResourceNotFoundException("Record not found with id : " + productId);
        	System.err.println("no transaction found");
        }

    }

}
