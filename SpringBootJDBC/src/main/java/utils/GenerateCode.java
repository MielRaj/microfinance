package utils;

import java.util.List;

import org.o7planning.sbjdbc.dao.TransactionDAO;
import org.o7planning.sbjdbc.entity.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

public class GenerateCode {
	
	@Autowired
	private TransactionDAO transac;
	
	public String genCodeTransac() {
		long nbr;
		List<Transaction> trans = this.transac.getAllTransac();
		if(!(trans).equals(null) && !(trans).isEmpty()) {
			nbr  = trans.size();
		}
		else {
			nbr = 0;
		}
		Long index = nbr++;
		String code = "T00000"+ index.toString();
		return code;
	}

}
