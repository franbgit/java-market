package com.platzi.market.persistence.mapper;

import com.platzi.market.domain.ProductDTO;
import com.platzi.market.persistence.entity.Product;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {CategoryMapper.class}) // categoryMapper for category attribute
public interface ProductMapper {
    @Mappings({
//            @Mapping(source = "productId", target = "productId"),
//            @Mapping(source = "name", target = "name"),
//            @Mapping(source = "categoryId", target = "categoryId"),
//            @Mapping(source = "price", target = "price"),
            @Mapping(source = "stockQuantity", target = "stock"),
            @Mapping(source = "state", target = "active"),
            @Mapping(source = "category", target = "categoryDTO"),
    })
    ProductDTO toProduct(Product product);
    List<ProductDTO> toProducts(List<Product> products);

    @InheritInverseConfiguration
    @Mapping(target = "barcode", ignore = true)
    Product toInverseProduct(ProductDTO productDTO);
}
