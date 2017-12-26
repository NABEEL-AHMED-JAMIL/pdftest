package com.example.mongodbdemo;

import com.example.mongodbdemo.model.Company;
import com.example.mongodbdemo.model.Contact;
import com.example.mongodbdemo.model.Product;
import com.example.mongodbdemo.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;
import java.util.*;
@SpringBootApplication
public class MongoDbDemoApplication implements CommandLineRunner {

	@Autowired
	private CompanyRepository companyRepository;

	public static void main(String[] args) {
		SpringApplication.run(MongoDbDemoApplication.class, args);
	}

	@Override
	public void run(String... strings) throws Exception {



//		System.out.println("==========Delete all company entities==========");
//		companyRepository.deleteAll();

		// save Documents to MongoDB
		System.out.println("==========Save list of company entities==========");
		companyRepository.save(Arrays.asList(
				// Apple company & products
				new Company("Apple",
						// list of products
						Arrays.asList(new Product("A-123", "Iphone 7", "Price: 649.00 USD & FREE shipping"),
								new Product("A-456", "IPadPro", "Price: 417.67 USD & FREE shipping")),
						// contact
						new Contact("Cupertino, CA 95014", "1-408-996-1010")),

				// Samsung company & products
				new Company("Samsung",
						// list of products
						Arrays.asList(new Product("S-012", "GalaxyJ7", "Price: 219.00 USD & FREE shipping"),
								new Product("S-456", "GalaxyTabA", "Price: 299.99 USD & FREE shipping")),
						// contact
						new Contact("Seocho District, Seoul, South Korea", "+82-2-2053-3000"))));

		// initial List Companies variable
		List<Company> companies = null;

		// fetch all documents
		System.out.println("==========Fetch aLL companies:==========");
		companies = companyRepository.findAll();
		companies.forEach(System.out::println);

		// find Company by name
		System.out.println("==========Find a company by name:==========");
		companies = companyRepository.findByName("Samsung");
		companies.forEach(System.out::println);

		// find Company by address
		System.out.println("==========Find a company by address:==========");
		companies = companyRepository.findByAddress("Cupertino, CA 95014");
		companies.forEach(System.out::println);

	}
}
