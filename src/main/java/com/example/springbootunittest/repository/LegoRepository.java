package com.example.springbootunittest.repository;

import com.example.springbootunittest.model.lego.LegoSet;
import com.example.springbootunittest.model.lego.LegoSetDifficulty;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.query.TextCriteria;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.util.List;

public interface LegoRepository extends MongoRepository<LegoSet, String>, QuerydslPredicateExecutor<LegoSet> {
    LegoSet findByTheme(String theme);
    List<LegoSet> findAllByThemeContains(String theme, Sort asc);
    List<LegoSet> findAllByDifficultyAndNameStartsWith(LegoSetDifficulty difficulty, String name);
    @Query("{'delivery.deliveryFee' : {$lt : ?0}}")
    List<LegoSet> findAllByDeliveryPriceLessThan(int price);
    @Query("{'reviews.rating': {$eq : $0}}")
    List<LegoSet> findAllByRatingGreaterThan(int rating);
    @Query("{'reviews.rating': {$gt : 10}}")
    List<LegoSet> findAllByGreatReviews();
    List<LegoSet> findAllBy(TextCriteria textCriteria);
    // @Query("{'paymentOptions.id: ?0'}")
    List<LegoSet> findByPaymentOptionsId(String id);
}
