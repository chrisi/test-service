package com.airplus.test.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class TestServiceApplicationTests {

  @Autowired
  private MongoTemplate mongoTemplate;

  @Test
  void contextLoads() {
    assertNotNull(mongoTemplate);
    mongoTemplate.getDb().listCollectionNames().first();
  }

}
