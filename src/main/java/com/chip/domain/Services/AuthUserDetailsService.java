package com.chip.domain.services;

import com.chip.domain.classes.SecUserDetails;
import com.chip.domain.repositories.UserRepository;
import com.chip.domain.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
//        if (user == null){
//            throw new UsernameNotFoundException(username);
//        }else {
//            UserDetails details = new SecUserDetails(user);
//            return details;
//        }

//        log.debug("Found user from repository {}",user.getUsername());

        final List<GrantedAuthority> auths = new ArrayList<GrantedAuthority>();
        auths.add(new SimpleGrantedAuthority(user.getRole()));

        UserDetails details = new SecUserDetails(user,user.getUsername(),user.getPassword(),auths);
        return details;

    }
}
