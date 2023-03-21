package com.teekay.inventoryservice.service;

import com.teekay.inventoryservice.repository.InventoryRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class InventoryService{

    private final InventoryRepository inventoryRepository;

    @Transactional(readOnly=true)
    public boolean isInStock(String barcode){
        return inventoryRepository.findByBarcode(barcode).isPresent();
    }
}
