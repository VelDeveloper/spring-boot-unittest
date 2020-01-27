package com.example.springbootunittest.controller;

import com.example.springbootunittest.model.lego.AvgRatingModel;
import com.example.springbootunittest.model.lego.LegoSet;
import com.example.springbootunittest.service.LegoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/lego")
@RequiredArgsConstructor
@CrossOrigin
public class LegoController {

    private final LegoService legoService;

    @GetMapping(value = "/list")
    public ResponseEntity<List<LegoSet>> listLegosets() {
        return ResponseEntity.ok(legoService.listLegoSets());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<LegoSet> getLegosetById(@PathVariable String id) {
        return ResponseEntity.ok(legoService.getLegoset(id));
    }

    @PostMapping
    public ResponseEntity<LegoSet> createLegoset(@RequestBody LegoSet legoSet) {
        return ResponseEntity.ok(legoService.createLegoset(legoSet));
    }

    @PutMapping
    public ResponseEntity<LegoSet> updateLegoset(@RequestBody LegoSet employee) {
        return ResponseEntity.ok(legoService.updateLegoset(employee));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLegoset(@PathVariable String id) {
        legoService.deleteLegoset(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/batchInsert")
    public ResponseEntity<List<LegoSet>> createAllLegoset(@RequestBody List<LegoSet> legoSet) {
        return ResponseEntity.ok(legoService.createAllLegoset(legoSet));
    }

    @GetMapping(value = "/byTheme/{theme}")
    public ResponseEntity<LegoSet> getLegosetByTheme(@PathVariable String theme) {
        return ResponseEntity.ok(legoService.getLegosetByTheme(theme));
    }

    @GetMapping(value = "/byThemeContains/{theme}")
    public ResponseEntity<List<LegoSet>> getLegosetByThemeContains(@PathVariable String theme) {
        return ResponseEntity.ok(legoService.getLegosetByThemeContains(theme));
    }

    @GetMapping(value = "/byHardDifficultyAndNameContains/{name}")
    public ResponseEntity<List<LegoSet>> getLegosetByHardDifficultyAndNameContains(@PathVariable String name) {
        return ResponseEntity.ok(legoService.getLegosetByHardDifficultyAndNameContains(name));
    }

    @GetMapping(value = "/byDeliveryPriceLessThan/{price}")
    public ResponseEntity<List<LegoSet>> getLegosetByHardDifficultyAndNameContains(@PathVariable Integer price) {
        return ResponseEntity.ok(legoService.getLegosetByDeliveryPriceLessThan(price));
    }

    @GetMapping(value = "/byRatingGreater/{rating}")
    public ResponseEntity<List<LegoSet>> getLegosetByRatingGreaterThan(@PathVariable Integer rating) {
        return ResponseEntity.ok(legoService.getLegosetByRatingGreaterThan(rating));
    }

    @GetMapping(value = "/greatReviews")
    public ResponseEntity<List<LegoSet>> getGreatReviews() {
        return ResponseEntity.ok(legoService.getGreatReviews());
    }

    @GetMapping(value = "/bestBuys")
    public ResponseEntity<List<LegoSet>> getBestBuys() {
        return ResponseEntity.ok(legoService.getBestBuys());
    }

    //--Projection--
    @GetMapping(value = "/avgRatingReports")
    public ResponseEntity<List<AvgRatingModel>> getReports() {
        return ResponseEntity.ok(legoService.getReports());
    }

    @GetMapping(value = "/fullTextSearch/{text}")
    public ResponseEntity<List<LegoSet>> getFullTextSearch(@PathVariable String text) {
        return ResponseEntity.ok(legoService.fullTextSearch(text));
    }

    //Query from nested mongo document(DBref)
    @GetMapping(value = "/paymentOptionById/{id}")
    public ResponseEntity<List<LegoSet>> getLegosetByPaymentOptions(@PathVariable String id) {
        return ResponseEntity.ok(legoService.getLegosetByPaymentOptions(id));
    }
}
