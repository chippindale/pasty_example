package com.chip;

import com.chip.domain.entities.Order;
import com.chip.domain.entities.Product;
import com.chip.domain.entities.User;
import com.chip.domain.repositories.OrderRepository;
import com.chip.domain.repositories.ProductRepository;
import com.chip.domain.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import static com.chip.domain.entities.ProductType.*;

@SpringBootApplication
@ComponentScan("com.chip")
public class MainApplication implements CommandLineRunner{

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private ProductRepository productRepo;

	@Autowired
	private OrderRepository orderRepo;

	public static void main(String[] args) {
		SpringApplication.run(MainApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception{
		userRepo.deleteAll();
		User bob = new User("username1","bob","pacman","password","bob@email.com");
		userRepo.save(bob);
		userRepo.save(new User("username2","emma","stone","password","emma@email.com"));
		userRepo.save(new User("username3","brad","pitt","password","brad@email.com"));

		productRepo.deleteAll();
		Product pasty = new Product(Hot,"Pasty",3.99,"A nice pasty",1.99);
		productRepo.save(pasty);
		productRepo.save(new Product(Cold,"Bakewell",2.99,"A nice bakewell",0.99));
		productRepo.save(new Product(Drink,"Lucazade",4.99,"A nice cold lucazade",1.99));

		orderRepo.deleteAll();
		orderRepo.save(new Order(bob.getAccountNumber(),new Product[]{pasty},new int[]{1},"15/06/1991"));

	}

}
