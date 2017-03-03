package com.chip.domain.repositories;

import com.chip.domain.entities.User;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by Chloe on 03/03/2017.
 */
public interface UserRepository extends MongoRepository<User, String>{
    User findByFirstName(String firstName);
}
