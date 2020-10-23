package com.sobuj.principle;

import com.sobuj.models.Account;
import com.sobuj.service.account.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private AccountService accountService;
    @Override
    @Transactional
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Account user = accountService.findByEmail(email).orElseThrow(
                () -> new UsernameNotFoundException("User not found with username or email : " + email));
        if (user != null) {
            return UserPrinciple.create(user);
        }
        throw new UsernameNotFoundException("User '" + email + "' not found");
    }
}
