package com.chip.domain.services;

import com.chip.domain.entities.User;
import com.chip.domain.enums.Role;
import com.chip.domain.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * Created by Chloe on 08/03/2017.
 */
@Service
public class UserService {
    @Autowired
    private UserRepository userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void registerUser(User inUser){
        User saveUser = new User();
        saveUser.setFirstName(inUser.getFirstName());
        saveUser.setLastName(inUser.getLastName());
        saveUser.setUsername(inUser.getUsername());
        saveUser.setEmail(inUser.getEmail());
        saveUser.setRole(Role.ROLE_USER);
        saveUser.setPassword(passwordEncoder.encode(inUser.getPassword()));

        userRepo.save(saveUser);

        System.out.println(saveUser.toString());
    }
}
