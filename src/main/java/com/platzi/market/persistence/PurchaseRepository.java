package com.platzi.market.persistence;

import com.platzi.market.domain.PurchaseDTO;
import com.platzi.market.domain.repository.PurchaseDTORepository;
import com.platzi.market.persistence.crud.PurchaseCrudRepository;
import com.platzi.market.persistence.entity.Purchase;
import com.platzi.market.persistence.mapper.PurchaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class PurchaseRepository implements PurchaseDTORepository {
    @Autowired
    private PurchaseCrudRepository purchaseCrudRepository;

    @Autowired
    private PurchaseMapper mapper;

    @Override
    public List<PurchaseDTO> getAll() {
        return mapper.toPurchases((List<Purchase>) purchaseCrudRepository.findAll());
    }

    @Override
    public Optional<List<PurchaseDTO>> getByClient(String clientId) {
        return purchaseCrudRepository.findByCustomerId(clientId)
                .map(purchases -> mapper.toPurchases(purchases));
    }

    @Override
    public PurchaseDTO save(PurchaseDTO purchaseDTO) {
        Purchase purchase = mapper.toInversePurchase(purchaseDTO);
        purchase.getProducts().forEach(productPurchases -> productPurchases.setPurchase(purchase));

        return mapper.toPurchase(purchaseCrudRepository.save(purchase));
    }
}
