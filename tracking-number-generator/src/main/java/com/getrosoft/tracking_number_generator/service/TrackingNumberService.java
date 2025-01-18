package com.getrosoft.tracking_number_generator.service;

import com.getrosoft.tracking_number_generator.repositories.TrackingNumber;
import com.getrosoft.tracking_number_generator.repositories.TrackingNumberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Random;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TrackingNumberService {

    private final TrackingNumberRepository trackingNumberRepository;

    public String generateTrackingNumber(
            String originCountryId,
            String destinationCountryId,
            Double weight,
            Instant orderCreatedAt,
            String customerId,
            String customerName,
            String customerSlug
    ) {
        String trackingNumber;
        do {
            trackingNumber = generateRandomTrackingNumber();
        } while (trackingNumberRepository.findByTrackingNumber(trackingNumber).isPresent());

        TrackingNumber trackingNumberEntity = TrackingNumber.builder()
                .trackingNumber(trackingNumber)
                .createdAt(Instant.now())
                .originCountryId(originCountryId)
                .destinationCountryId(destinationCountryId)
                .weight(weight)
                .orderCreatedAt(orderCreatedAt)
                .customerId(customerId)
                .customerName(customerName)
                .customerSlug(customerSlug)
                .build();

        trackingNumberRepository.save(trackingNumberEntity);

        return trackingNumber;
    }

    private String generateRandomTrackingNumber() {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 16; i++) {
            int charOrDigit = random.nextInt(2);
            if (charOrDigit == 0) {
                sb.append((char) ('A' + random.nextInt(26)));
            } else {
                sb.append(random.nextInt(10));
            }
        }
        return sb.toString();
    }
}