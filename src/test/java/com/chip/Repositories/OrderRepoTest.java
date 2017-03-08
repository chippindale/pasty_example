package com.chip.Repositories;

import com.chip.domain.Entities.Order;
import com.chip.domain.Entities.Product;
import com.chip.domain.Entities.User;
import com.chip.domain.Repositories.OrderRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static com.chip.domain.Entities.ProductType.Cold;
import static com.chip.domain.Entities.ProductType.Drink;
import static com.chip.domain.Entities.ProductType.Hot;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class OrderRepoTest {
    @Autowired
    OrderRepository orderRepo;

    User bob = new User("username2","bob","pacman","password","bob@email.com");
    User emma = new User("username2","emma","stone","password","emma@email.com");
    User brad = new User("username3","brad","pitt","password","brad@email.com");

    Product pasty = new Product(Hot,"Pasty",3.99,"A nice pasty",1.99);
    Product bakewell = new Product(Cold,"Bakewell",1.99,"A nice bakewell slice yummy",0.99);
    Product lucazade = new Product(Drink,"Lucazade",2.99,"A lucazade the best drink",1.99);


    Order order1 = new Order(bob.getAccountNumber(),new Product[]{pasty},new int[]{1},"15/06/1991");
    Order order2 = new Order(emma.getAccountNumber(),new Product[]{bakewell},new int[]{3},"14/06/1991");
    Order order3 = new Order(brad.getAccountNumber(),new Product[]{lucazade},new int[]{5},"13/06/1991");
    @Test
    public void insertOrder(){
        orderRepo.deleteAll();
        orderRepo.save(order1);
        assertNotNull(orderRepo.findAll());
        assertEquals(order1.toString(),orderRepo.findByuserAccountNum(bob.getAccountNumber()).toString());
    }

    @Test
    public void insertMultipleProduct(){
        orderRepo.deleteAll();
        orderRepo.save(order1);
        orderRepo.save(order2);
        orderRepo.save(order3);
        assertEquals(3,orderRepo.findAll().size());
    }

    @Test
    public void idAssigned(){
        orderRepo.deleteAll();
        orderRepo.save(order3);
        assertNotNull(order3.getId());
    }
}
