package org.o7planning.sbjdbc.repository;

import org.o7planning.sbjdbc.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepo extends JpaRepository<Transaction, String> {

}
