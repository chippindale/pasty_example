package com.chip.domain.services;

import com.chip.domain.entities.User;
import com.chip.domain.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Chloe on 08/03/2017.
 */
@Service
public class UserService {
    @Autowired
    private UserRepository userRepo;

    public void registerUser(User inUser){
        userRepo.save(new User(inUser.getUsername(),inUser.getFirstName(),inUser.getLastName(),inUser.getPassword(),inUser.getEmail()));
    }
}
