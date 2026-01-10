package org.example.burgerprime.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.burgerprime.interfaces.AccountRepository;
import org.example.burgerprime.models.Account;
import org.example.burgerprime.models.enums.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {
    private final AccountRepository accountRepository;
    private final PasswordEncoder passwordEncoder;


    public boolean createUser(Account account) {
        if(accountRepository.findByName(account.getName()) != null){
            return false;
        }
        account.setActive(true);
        account.getRoles().add(Role.ROLE_USER);
        account.setPassword(passwordEncoder.encode(account.getPassword()));
        log.info("User created:" + account.getName());
        return true;
    }
}
