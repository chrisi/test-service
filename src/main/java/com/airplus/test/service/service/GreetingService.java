package com.airplus.test.service.service;

import com.airplus.test.service.model.GreetingRecord;
import com.airplus.test.service.repository.GreetingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class GreetingService {

    private final GreetingRepository greetingRepository;

    public String saveAndGetEcho(String name) {
        GreetingRecord record = GreetingRecord.builder()
                .name(name)
                .timestamp(LocalDateTime.now())
                .build();
        greetingRepository.save(record);
        return "hello " + name;
    }
}
