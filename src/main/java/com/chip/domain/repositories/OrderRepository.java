package com.chip.domain.repositories;

import com.chip.domain.entities.Order;
import com.chip.domain.entities.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * Created by Chloe on 03/03/2017.
 */
public interface OrderRepository extends MongoRepository<Order, String> {
    Order findByuserAccountNum(String userAccountNum);
}
