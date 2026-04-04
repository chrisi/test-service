package com.airplus.test.service.service;

import com.airplus.test.service.model.GreetingRecord;
import com.airplus.test.service.repository.GreetingRepository;
import io.micrometer.observation.annotation.Observed;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
@Slf4j
@Observed
public class GreetingService {
  @Value("${spring.application.name}")
  private String applicationName;

  private final GreetingRepository greetingRepository;

  public String saveAndGetEcho(String name) {
    log.info("Saving greeting record for name: {}", name);
    GreetingRecord record = GreetingRecord.builder()
        .name(name)
        .applicationName(applicationName)
        .timestamp(LocalDateTime.now())
        .build();
    greetingRepository.save(record);
    return "hello " + name;
  }
}
