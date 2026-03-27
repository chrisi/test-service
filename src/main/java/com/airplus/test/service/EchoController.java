package com.airplus.test.service;

import com.airplus.test.service.client.RemoteEchoClient;
import com.airplus.test.service.service.GreetingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class EchoController {

    private final GreetingService greetingService;
    private final RemoteEchoClient remoteEchoClient;

    @GetMapping("/echo")
    public String echo(@RequestParam(name = "name") String name) {
        return greetingService.saveAndGetEcho(name);
    }

    @GetMapping("/remoteecho")
    public String remoteEcho(@RequestParam(name = "name") String name) {
        return remoteEchoClient.remoteEcho(name);
    }
}
