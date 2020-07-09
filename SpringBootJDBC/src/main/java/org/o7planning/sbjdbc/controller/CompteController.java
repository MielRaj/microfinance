package org.o7planning.sbjdbc.controller;

import java.util.List;

import org.o7planning.sbjdbc.dao.ClientDAO;
import org.o7planning.sbjdbc.dao.CptClientDAO;
import org.o7planning.sbjdbc.entity.Compteclient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class CompteController {
	
	@Autowired
	private CptClientDAO cptDao;
	
	@Autowired
	private ClientDAO clientDao;
	
	@RequestMapping(path = "/createCpt/{codeClt}", method = RequestMethod.POST, headers="Accept=application/json")
	@ResponseBody
	public ResponseEntity<Compteclient> createCpt(@RequestBody String compte, @PathVariable String codeClt) {
		ObjectMapper objectMapper = new ObjectMapper();
		Compteclient cptClt = new Compteclient();
		
		List<Compteclient> listCpt = this.cptDao.getAllCompte();
		
		long nbr;
		if(!(listCpt).equals(null) && !(listCpt).isEmpty()) {
			nbr  = listCpt.size();
		}
		else {
			nbr = 0;
		}
		Long index = ++nbr;
		String code = "Cp"+ String.format("%05d", index);
		
		try {
			cptClt = objectMapper.readValue(compte, Compteclient.class);
			cptClt.setNumCompte(code);
			cptClt.setClient(clientDao.getClientById(codeClt));
			this.cptDao.createCompte(cptClt);
			return new ResponseEntity<Compteclient>(cptClt, new HttpHeaders(), HttpStatus.OK);
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(compte);
		
		return null;
	}
	
	@GetMapping("/compte/{codeClt}")
	public List<Compteclient> getCptByClient(@PathVariable String codeClt){
		return this.cptDao.getCptByClient(this.clientDao.getClientById(codeClt));
	}

}
