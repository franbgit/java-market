package com.platzi.market.persistence.crud;

import com.platzi.market.persistence.entity.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ProductCrudRepository extends CrudRepository<Product, Integer> {
    // @Query(value = "SELECT * FROM products WHERE id_category = ?", nativeQuery = true)
    // List<Product> findByCategoryId(int categoryId);
    List<Product> findByCategoryIdOrderByNameAsc(int categoryId);

    Optional<List<Product>> findByStockQuantityLessThanAndState(int stockQuantity, boolean state);
}
