package com.platzi.market.persistence;

import com.platzi.market.domain.ProductDTO;
import com.platzi.market.domain.repository.ProductDTORepository;
import com.platzi.market.persistence.crud.ProductCrudRepository;
import com.platzi.market.persistence.entity.Product;
import com.platzi.market.persistence.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

//@Component // It's a Sprint component
@Repository // It's a Sprint component for databases
public class ProductRepository implements ProductDTORepository {
    @Autowired // we give the responsibility to Spring to create the instance to the component/object
    private ProductCrudRepository productCrudRepository;

    @Autowired
    private ProductMapper mapper;

//    public List<Product> getAll() {
//        return (List<Product>) productCrudRepository.findAll();
//    }

    @Override
    public List<ProductDTO> getAll() {
        List<Product> products = (List<Product>) productCrudRepository.findAll();
        return mapper.toProducts(products);
    }

//    public List<Product> getByCategory(int categoryId) {
//        return productCrudRepository.findByCategoryIdOrderByNameAsc(categoryId);
//    }

    public Optional<List<ProductDTO>> getByCategory(int categoryId) {
        List<Product> products = productCrudRepository.findByCategoryIdOrderByNameAsc(categoryId);
        return Optional.of(mapper.toProducts(products));
    }

//    public Optional<List<Product>> findAtStake(int quantity) {
//        return productCrudRepository.findByStockQuantityLessThanAndState(quantity, true);
//    }

    @Override
    public Optional<List<ProductDTO>> getScarseProduct(int quantity) {
        Optional<List<Product>> products = productCrudRepository.findByStockQuantityLessThanAndState(quantity, true);
        return products.map(prods -> mapper.toProducts(prods));
    }

//    public Optional<Product> getProduct(int productId) {
//        return productCrudRepository.findById(productId);
//    }

    public Optional<ProductDTO> getProduct(int productId) {
        return productCrudRepository.findById(productId).map(product -> {
//            System.out.println("product " + product.getProductId());
//            System.out.println("product " + product.getName());
//            System.out.println("product " + product.getCategoryId());
//            System.out.println("product " + product.getPrice());
//            System.out.println("product " + product.getStockQuantity());
//            System.out.println("product " + product.getState());
//            System.out.println("product " + product.getCategory().getCategoryId());
            return mapper.toProduct(product);
        });
    }

//    public Product save(Product product) {
//        return productCrudRepository.save(product);
//    }

    @Override
    public ProductDTO save(ProductDTO productDTO) {
        Product product = mapper.toInverseProduct(productDTO);
//        System.out.println("product " + product.getProductId());
//        System.out.println("product " + product.getName());
//        System.out.println("product " + product.getCategoryId());
//        System.out.println("product " + product.getPrice());
//        System.out.println("product " + product.getStockQuantity());
//        System.out.println("product " + product.getState());
//        System.out.println("product " + product.getCategory().getCategoryId());
//        return productDTO;
        return mapper.toProduct(productCrudRepository.save(product));
    }

    public void delete(int productId) {
        productCrudRepository.deleteById(productId);
    }
}
