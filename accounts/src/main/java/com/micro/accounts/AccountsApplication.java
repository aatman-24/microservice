package com.micro.accounts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
public class AccountsApplication {

	/**
	 * This is the main entry point for the accounts service.
	 * @param args The command line arguments passed to the service.
	 */
	public static void main(String[] args) {
		SpringApplication.run(AccountsApplication.class, args);
	}

}
