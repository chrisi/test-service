package com.airplus.test.service;

import com.mongodb.MongoClientSettings;
import io.micrometer.observation.ObservationRegistry;
import org.springframework.boot.mongodb.autoconfigure.MongoClientSettingsBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MongoObservabilityConfig {

//  @Bean
//  MongoClientSettingsBuilderCustomizer mongoDbObservabilitySettings(ObservationRegistry registry) {
//    return (clientSettingsBuilder) -> {
//      clientSettingsBuilder.observabilitySettings(ObservabilitySettings.micrometerBuilder()
//          .observationRegistry(observationRegistry)
//          .build());
//    };
//  }
}