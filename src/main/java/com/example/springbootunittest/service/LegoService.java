package com.example.springbootunittest.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LegoService {

//    private final LegoRepository legoRepository;
//    private final ReportService reportService;

//    public List<LegoSet> listLegoSets() {
//        Sort sortByThemeAsc = Sort.by("theme").ascending();
//        return legoRepository.findAll(sortByThemeAsc);
//    }
//
//    public LegoSet getLegoset(String legoSetId) {
//        return legoRepository.findById(legoSetId)
//                .orElseThrow(() -> new EmployeeException("Legoset with ID: "+legoSetId+" Not found"));
//    }
//
//    public LegoSet createLegoset(LegoSet legoSet) {
//        return legoRepository.insert(legoSet);
//    }
//
//    public List<LegoSet> createAllLegoset(List<LegoSet> legoSets) {
//        return legoRepository.saveAll(legoSets);
//    }
//
//    public LegoSet updateLegoset(LegoSet legoSet) {
//        return legoRepository.findById(legoSet.getId())
//                .map(legoSet1 -> legoRepository.save(legoSet))
//                .orElseGet(() -> legoRepository.insert(legoSet));
//    }
//
//    public void deleteLegoset(String legoSetId) {
//        legoRepository.delete(
//                legoRepository.findById(legoSetId)
//                        .orElseThrow(() -> new EmployeeException("LegoSet with ID: "+legoSetId+" Not found")));
//    }
//
//    public LegoSet getLegosetByTheme(String legoSetId) {
//        return legoRepository.findByTheme(legoSetId);
//    }
//
//    public List<LegoSet> getLegosetByThemeContains(String legoSetId) {
//        Sort sortByThemeAsc = Sort.by("theme").ascending();
//        return legoRepository.findAllByThemeContains(legoSetId, sortByThemeAsc);
//    }
//
//    public List<LegoSet> getLegosetByHardDifficultyAndNameContains(String name) {
//        return legoRepository.findAllByDifficultyAndNameStartsWith(LegoSetDifficulty.HARD,name);
//    }
//
//    public List<LegoSet> getLegosetByDeliveryPriceLessThan(int price) {
//        return legoRepository.findAllByDeliveryPriceLessThan(price);
//    }
//
//    public List<LegoSet> getLegosetByRatingGreaterThan(int rating) {
//        return legoRepository.findAllByRatingGreaterThan(rating);
//    }
//
//    public List<LegoSet> getGreatReviews() {
//        return legoRepository.findAllByGreatReviews();
//    }
//
//    public List<LegoSet> getBestBuys() {
//        QLegoSet query = new QLegoSet("query"); //we can give any name
//        BooleanExpression inStockFilter = query.deliveryInfo.inStock.isTrue();
//        Predicate smallDeliveryFeeFilter = query.deliveryInfo.deliveryFee.lt(400);
//        Predicate hasGreatReviews = query.reviews.any().rating.eq(10);
//
//        Predicate bestBuysFilter = inStockFilter.and(smallDeliveryFeeFilter).and(hasGreatReviews);
//
//        return (List<LegoSet>)legoRepository.findAll(bestBuysFilter);
//    }
//
//    public List<AvgRatingModel> getReports() {
//        return reportService.getAvgRatingReport();
//    }
//
//    public List<LegoSet> fullTextSearch(String text) {
//        TextCriteria textCriteria = TextCriteria.forDefaultLanguage().matching(text);
//        return legoRepository.findAllBy(textCriteria);
//    }
//
//    public List<LegoSet> getLegosetByPaymentOptions(String id) {
//        return legoRepository.findByPaymentOptionsId(id);
//    }

}
