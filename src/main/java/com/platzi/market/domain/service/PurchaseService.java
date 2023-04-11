package com.platzi.market.domain.service;

import com.platzi.market.domain.PurchaseDTO;
import com.platzi.market.domain.repository.PurchaseDTORepository;
import com.platzi.market.persistence.crud.PurchaseCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PurchaseService {
    @Autowired
    private PurchaseDTORepository purchaseDTORepository;

    public List<PurchaseDTO> getAll() {
        return purchaseDTORepository.getAll();
    }

    public Optional<List<PurchaseDTO>> getByClient(String clientId) {
        return purchaseDTORepository.getByClient(clientId);
    }

    public PurchaseDTO save(PurchaseDTO purchaseDTO) {
        return purchaseDTORepository.save(purchaseDTO);
    }
}
