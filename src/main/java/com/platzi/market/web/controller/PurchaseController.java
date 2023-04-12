package com.platzi.market.web.controller;

import com.platzi.market.domain.PurchaseDTO;
import com.platzi.market.domain.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.function.Predicate;

@RestController
@RequestMapping("/purchases")
public class PurchaseController {
    @Autowired
    private PurchaseService purchaseService;

    @GetMapping("/all")
    public ResponseEntity<List<PurchaseDTO>> getAll() {
        return new ResponseEntity<>(purchaseService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<PurchaseDTO>> getByClientId(@PathVariable("id") String clientId) {
        return purchaseService.getByClient(clientId).filter(Predicate.not(List::isEmpty))
                .map(purchaseDTOS -> new ResponseEntity<>(purchaseDTOS, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/save")
    public ResponseEntity<PurchaseDTO> save(@RequestBody PurchaseDTO purchaseDTO) {
        return new ResponseEntity<>(purchaseService.save(purchaseDTO), HttpStatus.OK);
    }
}
