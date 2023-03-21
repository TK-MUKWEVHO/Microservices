package com.teekay.inventoryservice.controller;

import com.teekay.inventoryservice.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/inventory")
@RestController
@RequiredArgsConstructor
public class InventoryController {

    private  final InventoryService inventoryService;

    @GetMapping("/{barcode}")
    @ResponseStatus(HttpStatus.OK)
    public boolean isInStock(@PathVariable("barcode") String barcode){
        return inventoryService.isInStock(barcode);
    }
}
