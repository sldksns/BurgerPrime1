package org.example.burgerprime.interfaces;


import org.example.burgerprime.models.Account;
import org.example.burgerprime.models.Basket;
import org.example.burgerprime.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;

public interface BasketRepository extends JpaRepository<Basket, Integer> {

    boolean existsByAccount(Account account);

    Basket findByAccount(Account account);

}
