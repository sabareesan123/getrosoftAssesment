package com.getrosoft.tracking_number_generator.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TrackingNumberRepository extends MongoRepository<TrackingNumber, String> {

    Optional<TrackingNumber> findByTrackingNumber(String trackingNumber);

}