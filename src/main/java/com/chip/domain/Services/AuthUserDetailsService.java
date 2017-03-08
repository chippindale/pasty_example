package com.chip.domain.Services;

import com.chip.domain.Classes.SecUserDetails;
import com.chip.domain.Repositories.UserRepository;
import com.chip.domain.Entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Created by Chloe on 08/03/2017.
 */
@Service
public class AuthUserDetailsService implements UserDetailsService{
    @Autowired
    private UserRepository userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.findByUsername(username);
        if (user == null){
            throw new UsernameNotFoundException(username);
        }else {
            UserDetails details = new SecUserDetails(user);
            return details;
        }
    }
}
