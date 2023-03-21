package com.teekay.orderservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderLineItemsDto {
    private UUID id;
    private String barcode;
    private BigDecimal price;
    private Integer quantity;
}
