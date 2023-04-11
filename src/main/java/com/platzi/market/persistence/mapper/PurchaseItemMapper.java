package com.platzi.market.persistence.mapper;

import com.platzi.market.domain.PurchaseItem;
import com.platzi.market.persistence.entity.ProductPurchases;
import com.platzi.market.persistence.entity.Purchase;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface PurchaseItemMapper {

    @Mappings({
            @Mapping(source = "id.productId", target = "productId"),
            @Mapping(source = "quantity", target = "quantity"),
            @Mapping(source = "state", target = "active"),
    })
    PurchaseItem toPurchase(ProductPurchases productPurchases);

    @InheritInverseConfiguration
    @Mappings({
            @Mapping(target = "purchase", ignore = true),
            @Mapping(target = "product", ignore = true),
            @Mapping(target = "id.purchaseId", ignore = true),
    })
    ProductPurchases toInversePurchase(PurchaseItem item);
}
