package com.example.springbootunittest.model.lego;

import lombok.Data;

@Data
public class AvgRatingModel {
    private String id;
    private String productName;
    private double avgRating;
}
