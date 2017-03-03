package com.chip.repositories;

import com.chip.domain.entities.User;
import com.chip.domain.repositories.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by Chloe on 03/03/2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class UserRepoTest {
    @Autowired
    private UserRepository userRepo;
    User bob = new User("username2","bob","pacman","password","bob@email.com");
    User emma = new User("username2","emma","stone","password","emma@email.com");
    User brad = new User("username3","brad","pitt","password","brad@email.com");

    @Test
    public void createUserTest() throws Exception{
        userRepo.deleteAll();
        userRepo.save(bob);

        assertEquals(userRepo.findByFirstName("bob").toString(),bob.toString());
    }

    @Test
    public void createMultipleUserTest() throws Exception{
        userRepo.deleteAll();
        userRepo.save(bob);
        userRepo.save(emma);
        userRepo.save(brad);

        assertEquals(userRepo.findAll().size(),3);
    }

    @Test
    public void accountNumberSetTest() throws Exception{
        userRepo.deleteAll();
        userRepo.save(bob);
        assertNotNull(bob.getAccountNumber());
    }


}
