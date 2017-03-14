package com.chip.domain.repositories;

import com.chip.domain.entities.Order;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by Chloe on 03/03/2017.
 */
public interface OrderRepository extends MongoRepository<Order, String> {
    Order findByuserAccountNum(String userAccountNum);
}
