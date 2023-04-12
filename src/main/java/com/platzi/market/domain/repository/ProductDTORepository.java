package com.platzi.market.domain.repository;

import com.platzi.market.domain.ProductDTO;

import java.util.List;
import java.util.Optional;

public interface ProductDTORepository {
    List<ProductDTO> getAll();
    Optional<List<ProductDTO>> getByCategory(int categoryId);
    Optional<List<ProductDTO>> getScarseProduct(int quantity);
    Optional<ProductDTO> getProduct(int productId);
    ProductDTO save(ProductDTO productDTO);
    void delete(int productId);
}
