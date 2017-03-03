package com.chip.domain.repositories;

import com.chip.domain.entities.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by Chloe on 03/03/2017.
 */
public interface ProductRepository extends MongoRepository<Product, String>{
    Product findByName(String name);
}
