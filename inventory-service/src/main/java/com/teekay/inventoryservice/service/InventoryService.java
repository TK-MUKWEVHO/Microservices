package com.teekay.inventoryservice.service;

import com.teekay.inventoryservice.dto.InventoryResponse;
import com.teekay.inventoryservice.repository.InventoryRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InventoryService{
    private final InventoryRepository inventoryRepository;
    @Transactional(readOnly=true)
    public List<InventoryResponse> isInStock(List<String> barcode){
        return inventoryRepository.findByBarcodeIn(barcode).stream()
                .map(inventory->
                    InventoryResponse.builder().barcode(inventory.getBarcode())
                            .isInStock(inventory.getQuantity()>0)
                            .build()
                ).toList();
    }
}
