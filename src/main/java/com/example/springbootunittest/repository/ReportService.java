package com.example.springbootunittest.repository;

import com.example.springbootunittest.model.lego.AvgRatingModel;
import com.example.springbootunittest.model.lego.LegoSet;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.ProjectionOperation;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.springframework.data.mongodb.core.aggregation.Aggregation.newAggregation;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.project;

@Service
@RequiredArgsConstructor
public class ReportService {

    private final MongoTemplate mongoTemplate;

    public List<AvgRatingModel> getAvgRatingReport() {
        ProjectionOperation projectionOperation = project()
                .andExpression("name").as("productName")
                .andExpression("{$avg : '$reviews.rating'}").as("avgRating");
        Aggregation aggregation = newAggregation(LegoSet.class,projectionOperation);
        return this.mongoTemplate
                .aggregate(aggregation, LegoSet.class, AvgRatingModel.class)
                .getMappedResults();
    }
}
