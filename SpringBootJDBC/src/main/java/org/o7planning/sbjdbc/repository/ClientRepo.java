package org.o7planning.sbjdbc.repository;

import org.o7planning.sbjdbc.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepo extends JpaRepository<Client, String> {

}