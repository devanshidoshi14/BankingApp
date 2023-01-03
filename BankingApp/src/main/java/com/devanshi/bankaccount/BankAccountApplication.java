package com.devanshi.bankaccount;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.devanshi.bankaccount.pojo.Account;
import com.devanshi.bankaccount.service.AccountService;


@SpringBootApplication
public class BankAccountApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankAccountApplication.class, args);
	}

	@Bean
	public CommandLineRunner init(AccountService accountService) {
		return (args) -> {
			// create account
			accountService.save(new Account());
		};
	}
}
