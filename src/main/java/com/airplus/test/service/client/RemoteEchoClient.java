package com.airplus.test.service.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "remoteEchoClient", url = "${remote.echo.url}")
public interface RemoteEchoClient {

  @GetMapping("/echo")
  String remoteEcho(@RequestParam(name = "name") String name);
}
