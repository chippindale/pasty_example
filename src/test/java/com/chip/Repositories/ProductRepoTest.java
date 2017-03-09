package com.chip.Repositories;

import com.chip.domain.entities.Product;
import com.chip.domain.repositories.ProductRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static com.chip.domain.entities.ProductType.Cold;
import static com.chip.domain.entities.ProductType.Drink;
import static com.chip.domain.entities.ProductType.Hot;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by Chloe on 03/03/2017.
 */
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class ProductRepoTest {
    @Autowired
    ProductRepository productRepo;

    Product pasty = new Product(Hot,"Pasty",3.99,"A nice pasty",1.99);
    Product bakewell = new Product(Cold,"Bakewell",1.99,"A nice bakewell slice yummy",0.99);
    Product lucazade = new Product(Drink,"Lucazade",2.99,"A lucazade the best drink",1.99);

    @Test
    public void insertProduct(){
        productRepo.deleteAll();
        productRepo.save(pasty);
        assertEquals(productRepo.findByName("Pasty").toString(),pasty.toString());
        productRepo.deleteAll();
    }

    @Test
    public void insertMultipleProduct(){
        productRepo.deleteAll();
        productRepo.save(pasty);
        productRepo.save(bakewell);
        productRepo.save(lucazade);
        assertEquals(productRepo.findAll().size(),3);
        productRepo.deleteAll();
    }

    @Test
    public void idAssigned(){
        productRepo.deleteAll();
        productRepo.save(pasty);
        assertNotNull(pasty.getId());
        productRepo.deleteAll();
    }
}
