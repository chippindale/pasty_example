package com.chip;

import com.chip.domain.entities.User;
import com.chip.domain.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.chip")
public class MainApplication implements CommandLineRunner{

	@Autowired
	private UserRepository userRepo;

	public static void main(String[] args) {
		SpringApplication.run(MainApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception{
		userRepo.deleteAll();
		userRepo.save(new User("username1","bob","pacman","password","bob@email.com"));
		userRepo.save(new User("username2","emma","stone","password","emma@email.com"));
		userRepo.save(new User("username3","brad","pitt","password","brad@email.com"));

		System.out.println("Users found with findall");
		System.out.println("____________________________");
		for(User user : userRepo.findAll()){
			System.out.println(user.toString());
		}
		System.out.println("");
		System.out.println("User found with findByFirstName 'bob'");
		System.out.println("____________________________");
		System.out.println(userRepo.findByFirstName("bob").toString());
	}

}
