package com.airplus.test.service;

import com.airplus.test.service.service.GreetingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class EchoController {

    private final GreetingService greetingService;

    @GetMapping("/echo")
    public String echo(@RequestParam(name = "name") String name) {
        return greetingService.saveAndGetEcho(name);
    }
}
