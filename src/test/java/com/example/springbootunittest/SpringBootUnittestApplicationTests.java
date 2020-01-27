package com.example.springbootunittest;

import com.example.springbootunittest.model.lego.*;
import com.example.springbootunittest.repository.LegoRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@DataMongoTest
class LegoStoreDatabaseTest {

    @Test
    void contextLoads() {
    }

    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    private LegoRepository legoRepository;

    @BeforeEach
    public void before() {
        this.legoRepository.deleteAll();
        PaymentOptions creditCardPayment = new PaymentOptions("CreditCard", PaymentType.CreditCard, 0);
        LegoSet milleniumFalcon = new LegoSet(
                "Millennium Falcon",
                "Star Wars",
                LegoSetDifficulty.HARD,
                "star wars",
                Arrays.asList(
                        new ProductReview("Dan", 7),
                        new ProductReview("Anna", 12),
                        new ProductReview("John", 8)
                ),
                new DeliveryInfo(LocalDate.now().plusDays(1), 30, true),
                creditCardPayment);

        LegoSet skyPolice = new LegoSet(
                "Sky Police Air Base",
                "City",
                LegoSetDifficulty.MEDIUM,
                "x-men",
                Arrays.asList(
                        new ProductReview("Dan", 5),
                        new ProductReview("Andrew", 8)
                ),
                new DeliveryInfo(LocalDate.now().plusDays(3), 50, true),
                creditCardPayment);
        this.legoRepository.saveAll(Arrays.asList(milleniumFalcon, skyPolice));
    }

    @Test
    public void findAllByGreatReviews_should_return_products_that_have_a_review_with_a_rating_of_ten() {
        List<LegoSet> results = this.legoRepository.findAllByGreatReviews();
        Collection<String> s = Collections.emptyList();
        if (s == null) {

        }

        Assertions.assertEquals(1, results.size());
        Assertions.assertEquals("Millennium Falcon", results.get(0).getId());
    }

}
