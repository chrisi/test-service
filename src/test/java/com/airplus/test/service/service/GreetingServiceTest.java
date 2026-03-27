package com.airplus.test.service.service;

import com.airplus.test.service.model.GreetingRecord;
import com.airplus.test.service.repository.GreetingRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class GreetingServiceTest {

    @Mock
    private GreetingRepository greetingRepository;

    @InjectMocks
    private GreetingService greetingService;

    @Test
    void shouldSaveRecordAndReturnEcho() {
        String name = "Junie";
        
        String result = greetingService.saveAndGetEcho(name);
        
        assertEquals("hello Junie", result);
        verify(greetingRepository).save(any(GreetingRecord.class));
    }
}
