package org.o7planning.sbjdbc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication

//@EnableAutoConfiguration(exclude = { //
//		DataSourceAutoConfiguration.class, //
//		DataSourceTransactionManagerAutoConfiguration.class, //
//		HibernateJpaAutoConfiguration.class })

public class SpringBootJdbcApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootJdbcApplication.class, args);
	}
}
