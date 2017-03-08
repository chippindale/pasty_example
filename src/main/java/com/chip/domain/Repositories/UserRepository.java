package com.chip.domain.Repositories;

import com.chip.domain.Entities.User;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by Chloe on 03/03/2017.
 */
public interface UserRepository extends MongoRepository<User, String>{
    User findByFirstName(String firstName);
    User findByUsernameAndPassword(String username,String password);
    User findByUsername(String username);

}
