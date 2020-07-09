package org.o7planning.sbjdbc.repository;

import java.util.List;

import org.o7planning.sbjdbc.entity.Client;
import org.o7planning.sbjdbc.entity.Compteclient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompteClientRepo extends JpaRepository<Compteclient, String> {

	List<Compteclient> findByClient(Client client);

}
