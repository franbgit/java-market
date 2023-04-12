package com.platzi.market.domain.service;

import com.platzi.market.domain.ProductDTO;
import com.platzi.market.domain.repository.ProductDTORepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//@Component
@Service
public class ProductService {
    @Autowired
    private ProductDTORepository productDTORepository;

    public List<ProductDTO> getAll() {
        return productDTORepository.getAll();
    }

    public Optional<ProductDTO> getProduct(int productId) {
        return productDTORepository.getProduct(productId);
    }

    public Optional<List<ProductDTO>> getByCategory(int categoryId) {
        return productDTORepository.getByCategory(categoryId);
    }

    public ProductDTO save(ProductDTO productDTO) {
        return productDTORepository.save(productDTO);
    }

    public boolean delete(int productId) {
//        if (getProduct(productId).isPresent()) {
//            productDTORepository.delete(productId);
//            return true;
//        } else {
//            return true;
//        }
//        return getProduct(productId).map(productDTO -> {
//            productDTORepository.delete(productId);
//            return true;
//        }).orElse(false);
        try {
            productDTORepository.delete(productId);
            return true;
        } catch (EmptyResultDataAccessException e) {
            return false;
        }
    }
}
