package org.example.burgerprime.interfaces;

import org.example.burgerprime.models.Account;
import org.example.burgerprime.models.AccountInformation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountInformationRepository extends JpaRepository<AccountInformation, Integer> {
    AccountInformation findByAccount(Account account);
}
