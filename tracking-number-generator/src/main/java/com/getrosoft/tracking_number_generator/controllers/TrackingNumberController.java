package com.getrosoft.tracking_number_generator.controllers;

import com.getrosoft.tracking_number_generator.service.TrackingNumberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;

@RestController
@RequiredArgsConstructor
public class TrackingNumberController {

    private final TrackingNumberService trackingNumberService;

    @GetMapping("/next-tracking-number")
    public ResponseEntity<TrackingNumberResponse> getNextTrackingNumber(
            @RequestParam String originCountryId,
            @RequestParam String destinationCountryId,
            @RequestParam Double weight,
            @RequestParam Instant orderCreatedAt,
            @RequestParam String customerId,
            @RequestParam String customerName,
            @RequestParam String customerSlug
    ) {
        String trackingNumber = trackingNumberService.generateTrackingNumber(
                originCountryId, destinationCountryId, weight, orderCreatedAt, customerId, customerName, customerSlug
        );
        return ResponseEntity.ok(new TrackingNumberResponse(trackingNumber, Instant.now()));
    }
}