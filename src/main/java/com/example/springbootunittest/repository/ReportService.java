package com.example.springbootunittest.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReportService {

//    private final MongoTemplate mongoTemplate;
//
//    public List<AvgRatingModel> getAvgRatingReport() {
//        ProjectionOperation projectionOperation = project()
//                .andExpression("name").as("productName")
//                .andExpression("{$avg : '$reviews.rating'}").as("avgRating");
//        Aggregation aggregation = newAggregation(LegoSet.class,projectionOperation);
//        return this.mongoTemplate
//                .aggregate(aggregation, LegoSet.class, AvgRatingModel.class)
//                .getMappedResults();
//    }
}
