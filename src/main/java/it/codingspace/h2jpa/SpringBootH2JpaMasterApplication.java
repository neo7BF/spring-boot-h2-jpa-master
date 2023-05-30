package it.codingspace.h2jpa;

import java.util.stream.IntStream;

import org.jeasy.random.EasyRandom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import it.codingspace.h2jpa.model.Customers;
import it.codingspace.h2jpa.model.CustomersRepository;

@SpringBootApplication
public class SpringBootH2JpaMasterApplication implements CommandLineRunner {
	
	@Autowired
	CustomersRepository cr;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootH2JpaMasterApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		EasyRandom er = new EasyRandom();
		
		IntStream counter = IntStream.range(0,10);
		
		counter.forEach((c) -> cr.save(er.nextObject(Customers.class)));
		
	}

}
