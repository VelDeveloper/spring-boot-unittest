package com.example.springbootunittest.model.lego;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class DeliveryInfo {
    private LocalDate deliveryDate;
    private int deliveryFee;
    private boolean inStock;
}
