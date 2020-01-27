package com.example.springbootunittest.model.lego;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.index.TextIndexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.ArrayList;
import java.util.Collection;

@Document(collection = "legosets")
@Data
@RequiredArgsConstructor
@AllArgsConstructor
@TypeAlias("legosets")
public class LegoSet {
    @Id
    private String id;
    @TextIndexed
    private String name;
    private LegoSetDifficulty difficulty;
    @TextIndexed
    @Indexed(direction = IndexDirection.ASCENDING)
    private String theme;
    private Collection<ProductReview> reviews = new ArrayList<>();

    @Field("delivery")
    private DeliveryInfo deliveryInfo;

    @DBRef
    private PaymentOptions paymentOptions;

}
