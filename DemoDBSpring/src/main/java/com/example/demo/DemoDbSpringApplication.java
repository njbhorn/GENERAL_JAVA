package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoDbSpringApplication implements CommandLineRunner {

	@Autowired
	AccountRepository accountRepository ;
	
	public static void main(String[] args) {
		SpringApplication.run(DemoDbSpringApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Account ac1 = new Account(100.0, "Joe Smith", 1);
				
		Account	ac2 = new Account(200.0, "Jane Doe", 2);
		
		accountRepository.save(ac1) ;
		accountRepository.save(ac2) ;
		
		List<Account> accs = accountRepository.findAll() ;
		
		for ( Account acc : accs ) {
			acc.deposit(10);
			accountRepository.save(acc) ;
		}
		
	}
	
	

}
