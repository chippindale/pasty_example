package com.chip.domain.classes;


import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;
import java.util.Set;

/**
 * Created by Chloe on 08/03/2017.
 */
public class SecUserDetails extends User {
    private com.chip.domain.entities.User user;

    private Set<GrantedAuthority> authorities;

    public SecUserDetails(com.chip.domain.entities.User user, String username, String password,
                          Collection<? extends GrantedAuthority> authorities) {
        super(username,password,authorities);
        this.setUser(user);
    }


    public com.chip.domain.entities.User getUser() {
        return user;
    }

    public void setUser(com.chip.domain.entities.User user) {
        this.user = user;
    }
}
