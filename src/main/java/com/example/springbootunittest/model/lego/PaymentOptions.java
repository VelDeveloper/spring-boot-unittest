package com.example.springbootunittest.model.lego;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
@RequiredArgsConstructor
@AllArgsConstructor
@TypeAlias("paymentOptions")
public class PaymentOptions {
    @Id
    private String id;
    private PaymentType type;
    private int fee;
}
