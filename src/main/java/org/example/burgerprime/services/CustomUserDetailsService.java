package org.example.burgerprime.services;

import lombok.AllArgsConstructor;
import org.example.burgerprime.interfaces.AccountRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
    private final AccountRepository accountRepository;
    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        return accountRepository.findByName(name);
    }
}
