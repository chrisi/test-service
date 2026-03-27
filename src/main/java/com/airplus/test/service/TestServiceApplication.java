package com.airplus.test.service;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableFeignClients
public class TestServiceApplication {

  static void main(String[] args) {
    SpringApplication.run(TestServiceApplication.class, args);
  }

}
