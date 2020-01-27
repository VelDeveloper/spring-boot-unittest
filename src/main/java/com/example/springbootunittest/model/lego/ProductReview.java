package com.example.springbootunittest.model.lego;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.index.TextIndexed;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class ProductReview {
    @TextIndexed
    private String userName;
    private int rating;
}
