package com.airplus.test.service.repository;

import com.airplus.test.service.model.GreetingRecord;
import io.micrometer.observation.annotation.Observed;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
@Observed
public interface GreetingRepository extends MongoRepository<GreetingRecord, String> {
}
