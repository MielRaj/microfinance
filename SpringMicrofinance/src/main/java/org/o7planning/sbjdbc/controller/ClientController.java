package org.o7planning.sbjdbc.controller;

import java.util.List;

import org.o7planning.sbjdbc.entity.Client;
import org.o7planning.sbjdbc.service.ClientDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/client")
public class ClientController {
	
	@Autowired
	private ClientDAO clientDao;
	
	/*@Autowired
	private CptClientDAO cptClientDao;*/
	
	@RequestMapping(value = "/bonjour/{msg}", method = RequestMethod.GET)
	@ResponseBody
	public String getMsg(@PathVariable final String msg) {
		return msg;
	}
	
	@GetMapping("/listClient")
	@ResponseBody
	public List<Client> getAllClient() {
		return this.clientDao.getAllClient();
	}
	
	@GetMapping("/getClient")
	@ResponseBody
	public Client getClientById(@RequestParam(defaultValue = "C00001", required=false, value="code") String code) {
		return clientDao.getClientById(code);
	}
	
	@RequestMapping(path = "/insertClient", method = RequestMethod.POST, headers="Accept=application/json")
	@ResponseBody
	public ResponseEntity<Client> createClient(@RequestBody String clientToInsert) {
		ObjectMapper objectMapper = new ObjectMapper();
		Client clt = new Client();
		
		List<Client> listClt = this.clientDao.getAllClient();
		
		long nbr;
		if(!(listClt).equals(null) && !(listClt).isEmpty()) {
			nbr  = listClt.size();
		}
		else {
			nbr = 0;
		}
		Long index = ++nbr;
		String code = "C" + String.format("%05d", index);
		
		try {
			clt = objectMapper.readValue(clientToInsert, Client.class);
			clt.setCodeClient(code);
			this.clientDao.createClient(clt);
				
			return new ResponseEntity<Client>(clt, new HttpHeaders(), HttpStatus.OK);
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(clientToInsert);
		
		return null;
	}
	
	@DeleteMapping("/delete/{codeClt}")
	public void deleteClientByCode(@PathVariable String codeClt) {
		this.clientDao.deleteClient(codeClt);
	}
	
	@PutMapping("/update")
	public ResponseEntity<Client> updateClient(@RequestBody Client client){
		return new ResponseEntity<Client>(client, new HttpHeaders(), HttpStatus.OK);
	}
	
}