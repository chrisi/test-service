package com.airplus.test.service.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Builder
@Document(collection = "greetings")
public class GreetingRecord {
    @Id
    private String id;
    private String name;
    private LocalDateTime timestamp;
}
