package com.getrosoft.tracking_number_generator.repositories;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "tracking_numbers")
public class TrackingNumber {

    @Id
    private String id;
    private String trackingNumber;
    private Instant createdAt;
    private String originCountryId;
    private String destinationCountryId;
    private Double weight;
    private Instant orderCreatedAt;
    private String customerId;
    private String customerName;
    private String customerSlug;

}