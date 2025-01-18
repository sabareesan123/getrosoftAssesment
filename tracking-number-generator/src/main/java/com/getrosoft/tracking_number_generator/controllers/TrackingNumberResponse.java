package com.getrosoft.tracking_number_generator.controllers;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.Instant;

@Data
@AllArgsConstructor
public class TrackingNumberResponse {
    private String trackingNumber;
    private Instant createdAt;
}