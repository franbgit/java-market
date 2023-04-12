package com.platzi.market.persistence.mapper;

import com.platzi.market.domain.PurchaseDTO;
import com.platzi.market.persistence.entity.Purchase;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {PurchaseItemMapper.class})
public interface PurchaseMapper {
    @Mappings({
            @Mapping(source = "customerId", target = "clientId"),
            @Mapping(source = "halfPay", target = "paymentMethod"),
            @Mapping(source = "commentary", target = "comment"),
            @Mapping(source = "products", target = "items"),
    })
    PurchaseDTO toPurchase(Purchase purchase);
    List<PurchaseDTO> toPurchases(List<Purchase> purchases);

    @InheritInverseConfiguration
    @Mapping(target = "customer", ignore = true)
    Purchase toInversePurchase(PurchaseDTO purchaseDTO);
}
