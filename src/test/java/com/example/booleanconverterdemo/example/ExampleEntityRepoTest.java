package com.example.booleanconverterdemo.example;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ExampleEntityRepoTest {

  @Autowired ExampleEntityRepo repo;

  @BeforeEach
  void init() {
    repo.deleteAll();
    repo.save(ExampleEntity.builder().active(true).build());
    repo.save(ExampleEntity.builder().active(false).build());
    repo.save(ExampleEntity.builder().active(false).build());
  }

  @Test
  void findByActiveFalse() {
    List<ExampleEntity> byActiveFalse = repo.findByActiveFalse();
    /* Error:
    org.springframework.dao.DataIntegrityViolationException: JDBC exception executing SQL [select e1_0.id,e1_0.active from example_entity e1_0 where e1_0.active=0]; SQL [n/a]
    */
    assertEquals(2, byActiveFalse.size());
  }

  @Test
  void findByActiveIsFalse() {
    List<ExampleEntity> byActiveFalse = repo.findByActiveFalse();
    /* Error:
    org.springframework.dao.DataIntegrityViolationException: JDBC exception executing SQL [select e1_0.id,e1_0.active from example_entity e1_0 where e1_0.active=0]; SQL [n/a]
    */
    assertEquals(2, byActiveFalse.size());
  }

  @Test
  void findByActive() {
    List<ExampleEntity> byActiveFalse = repo.findByActive(false);
    assertEquals(2, byActiveFalse.size());
  }
}
