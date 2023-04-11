package com.platzi.market.web.controller;

import com.platzi.market.domain.ProductDTO;
import com.platzi.market.domain.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/all")
    public ResponseEntity<List<ProductDTO>> getAll() {
        return new ResponseEntity<>(productService.getAll(), HttpStatus.OK);
//        return productService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> getProduct(@PathVariable("id") int productId) {
        return productService.getProduct(productId)
                .map(productDTO -> new ResponseEntity<>(productDTO, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
//        return productService.getProduct(productId);
    }

    @GetMapping("/category/{id}")
    public ResponseEntity<List<ProductDTO>> getByCategory(@PathVariable("id") int categoryId) {
        return productService.getByCategory(categoryId)
                .map(productDTOS -> new ResponseEntity<>(productDTOS, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
//        return productService.getByCategory(categoryId);
    }

    @PostMapping("/save")
    public ResponseEntity<ProductDTO> save(@RequestBody ProductDTO productDTO) {
        return new ResponseEntity<>(productService.save(productDTO), HttpStatus.CREATED);
//        return productService.save(productDTO);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable("id") int productId) {
        return new ResponseEntity(productService.delete(productId) ? HttpStatus.OK : HttpStatus.NOT_FOUND);
//        return productService.delete(productId);
    }
}
