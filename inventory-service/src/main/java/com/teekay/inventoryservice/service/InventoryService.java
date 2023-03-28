package com.teekay.inventoryservice.service;

import com.teekay.inventoryservice.dto.InventoryResponse;
import com.teekay.inventoryservice.repository.InventoryRepository;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class InventoryService{
    private final InventoryRepository inventoryRepository;
    @Transactional(readOnly=true)
    @SneakyThrows
    public List<InventoryResponse> isInStock(List<String> barcode){
        log.info("Wait started");
        Thread.sleep(10000);
        log.info("Endded");

        return inventoryRepository.findByBarcodeIn(barcode).stream()
                .map(inventory->
                    InventoryResponse.builder().barcode(inventory.getBarcode())
                            .isInStock(inventory.getQuantity()>0)
                            .build()
                ).toList();
    }
}
