package com.example.springbootunittest.controller;

import com.example.springbootunittest.model.lego.PaymentOptions;
import com.example.springbootunittest.repository.PaymentOptionsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/paymentOptions")
@RequiredArgsConstructor
@CrossOrigin
public class PaymentOptionsController {

    private final PaymentOptionsRepository paymentOptionsRepository;

    @GetMapping(value = "/list")
    public ResponseEntity<List<PaymentOptions>> listPaymentOptions() {
        return ResponseEntity.ok(paymentOptionsRepository.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<PaymentOptions> getLegosetById(@PathVariable String id) {
        return ResponseEntity.ok(paymentOptionsRepository.findById(id).orElse(null));
    }

    @PostMapping
    public ResponseEntity<PaymentOptions> createLegoset(@RequestBody PaymentOptions paymentOptions) {
        return ResponseEntity.ok(paymentOptionsRepository.insert(paymentOptions));
    }

    @PutMapping
    public ResponseEntity<PaymentOptions> updateLegoset(@RequestBody PaymentOptions paymentOptions) {
        return ResponseEntity.ok(paymentOptionsRepository.save(paymentOptions));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<PaymentOptions> deleteLegoset(@PathVariable String id) {
        paymentOptionsRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
