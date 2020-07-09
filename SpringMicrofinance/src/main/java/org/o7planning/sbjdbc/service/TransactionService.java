package org.o7planning.sbjdbc.service;

import java.util.List;

import org.o7planning.sbjdbc.model.TransacInfo;

public interface TransactionService {
	
	public TransacInfo saveTransaction(TransacInfo transaction);
	
	public TransacInfo getTransacByCode(String codeTransac);
	
	public List<TransacInfo> getAllTransac();

}
