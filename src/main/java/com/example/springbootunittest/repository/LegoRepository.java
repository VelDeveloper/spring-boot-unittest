package com.example.springbootunittest.repository;

//public interface LegoRepository extends MongoRepository<LegoSet, String>, QuerydslPredicateExecutor<LegoSet> {
//    LegoSet findByTheme(String theme);
//    List<LegoSet> findAllByThemeContains(String theme, Sort asc);
//    List<LegoSet> findAllByDifficultyAndNameStartsWith(LegoSetDifficulty difficulty, String name);
//    @Query("{'delivery.deliveryFee' : {$lt : ?0}}")
//    List<LegoSet> findAllByDeliveryPriceLessThan(int price);
//    @Query("{'reviews.rating': {$eq : $0}}")
//    List<LegoSet> findAllByRatingGreaterThan(int rating);
//    @Query("{'reviews.rating': {$gt : 10}}")
//    List<LegoSet> findAllByGreatReviews();
//    List<LegoSet> findAllBy(TextCriteria textCriteria);
//    // @Query("{'paymentOptions.id: ?0'}")
//    List<LegoSet> findByPaymentOptionsId(String id);
public interface LegoRepository {
}
