package com.ballistic.mongodbdemo;

import com.ballistic.mongodbdemo.domain.Address;
import com.ballistic.mongodbdemo.domain.Hotel;
import com.ballistic.mongodbdemo.domain.Product;
import com.ballistic.mongodbdemo.domain.Review;
import com.ballistic.mongodbdemo.repository.HotelRepository;
import com.ballistic.mongodbdemo.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@SpringBootApplication()
public class MongoDbDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MongoDbDemoApplication.class, args);
	}

	public class DbSeeder implements CommandLineRunner{

        private HotelRepository hotelRepository;
        private ProductRepository productRepository;

        public HotelRepository getHotelRepository() { return hotelRepository; }
        public ProductRepository getProductRepository() { return productRepository; }

        @Override
        public void run(String... strings) throws Exception {
            Product product1 = new Product("xyz", new BigDecimal(255), "pakistan");
            Product product2 = new Product("xyz", new BigDecimal(255), "pakistan");
            Product product3 = new Product("xyz", new BigDecimal(255), "pakistan");

            Hotel marriot = new Hotel(
                    "Marriot",
                    130,
                    new Address("Paris", "France"),
                    Arrays.asList(
                            new Review("John", 8, false),
                            new Review("Mary", 7, true)
                    )
            );

            Hotel ibis = new Hotel(
                    "Ibis",
                    90,
                    new Address("Bucharest", "Romania"),
                    Arrays.asList(
                            new Review("Teddy", 9, true)
                    )
            );

            Hotel sofitel = new Hotel(
                    "Sofitel",
                    200,
                    new Address("Rome", "Italy"),
                    new ArrayList<>()
            );

            // drop all hotels
            this.hotelRepository.deleteAll();

            //add our hotels to the database
            List<Hotel> hotels = Arrays.asList(marriot, ibis, sofitel);
            List<Product> products = Arrays.asList(product1,product2,product3);
            this.hotelRepository.save(hotels);
            this.productRepository.save(products);
        }
    }
}
