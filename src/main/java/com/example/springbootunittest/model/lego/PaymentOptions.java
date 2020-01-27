package com.example.springbootunittest.model.lego;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

//@Document
@Data
@RequiredArgsConstructor
@AllArgsConstructor
//@TypeAlias("paymentOptions")
public class PaymentOptions {
//    @Id
    private String id;
    private PaymentType type;
    private int fee;
}
