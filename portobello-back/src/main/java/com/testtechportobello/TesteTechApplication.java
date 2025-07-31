package com.testtechportobello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(exclude = {
	    org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration.class,
	    org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration.class
	})
public class TesteTechApplication {

	public static void main(String[] args) {
		SpringApplication.run(TesteTechApplication.class, args);
	}

}
