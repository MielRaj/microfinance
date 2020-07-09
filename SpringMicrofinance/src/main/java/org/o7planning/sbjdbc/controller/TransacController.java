package org.o7planning.sbjdbc.controller;

import java.time.LocalDate;
import java.util.List;

import org.o7planning.sbjdbc.entity.Compteclient;
import org.o7planning.sbjdbc.entity.Transaction;
import org.o7planning.sbjdbc.service.CptClientDAO;
import org.o7planning.sbjdbc.service.TransactionDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransacController {
	
	@Autowired
	private TransactionDAO transacDao;
	
	@Autowired
	private CptClientDAO cptDao;
	
	@GetMapping("/listTransac")
	@ResponseBody
	public List<Transaction> getAllTransac() {
		return this.transacDao.getAllTransac();
	}
	
	@PostMapping("/transac/{numCpt}/{typeTransac}/{montant}")
	@ResponseBody
	public void transaction(@PathVariable String numCpt, @PathVariable String typeTransac, @PathVariable double montant) {
		Compteclient cptClient =  cptDao.getCptById(numCpt);
		Transaction transac = new Transaction();
		List<Transaction> listTransac = this.transacDao.getAllTransac();
		
		long nbr;
		if(!(listTransac).equals(null) && !(listTransac).isEmpty()) {
			nbr  = listTransac.size();
		}
		else {
			nbr = 0;
		}
		Long index = ++nbr;
		String code = "T" + String.format("%05d", index);
		
		transac.setCodeTransac(code);
		transac.setCompteclient(cptClient);
		transac.setDateTransac(LocalDate.now().toString());
		transac.setMontant(montant);
		switch(typeTransac) {
			case "DE":
				transac.setTypeTransac("Dépôt");
				cptClient.setSolde(cptClient.getSolde()+montant);
				break;
			case "RE":
				transac.setTypeTransac("Retrait");
				cptClient.setSolde(cptClient.getSolde()-montant);
			default:
				System.err.println("pas de transaction");
		}
		
		cptDao.updateCompte(cptClient);
		transacDao.createTransac(transac);
	}
	
	
	@PostMapping("/virement/{numCptDebit}/{numCptCredit}/{montant}")
	@ResponseBody
	public void virement(@PathVariable String numCptDebit, @PathVariable String numCptCredit, @PathVariable double montant) {
		transaction(numCptDebit, "RE", montant);
		transaction(numCptCredit, "DE", montant);
	}

}
