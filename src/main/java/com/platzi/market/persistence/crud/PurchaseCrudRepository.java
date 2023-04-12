package com.platzi.market.persistence.crud;

import com.platzi.market.persistence.entity.Purchase;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface PurchaseCrudRepository extends CrudRepository<Purchase, Integer> { // type of primary key is Integer
    Optional<List<Purchase>> findByCustomerId(String customerId);
}
