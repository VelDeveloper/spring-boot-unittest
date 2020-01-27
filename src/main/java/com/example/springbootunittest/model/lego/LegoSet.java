package com.example.springbootunittest.model.lego;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.Collection;

//@Document(collection = "legosets")
@Data
@RequiredArgsConstructor
@AllArgsConstructor
//@TypeAlias("legosets")
public class LegoSet {
//    @Id
    private String id;
//    @TextIndexed
    private String name;
    private LegoSetDifficulty difficulty;
//    @TextIndexed
//    @Indexed(direction = IndexDirection.ASCENDING)
    private String theme;
    private Collection<ProductReview> reviews = new ArrayList<>();

//    @Field("delivery")
    private DeliveryInfo deliveryInfo;

//    @DBRef
    private PaymentOptions paymentOptions;

}
