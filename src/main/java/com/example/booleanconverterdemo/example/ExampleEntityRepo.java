package com.example.booleanconverterdemo.example;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExampleEntityRepo extends JpaRepository<ExampleEntity, String> {

  List<ExampleEntity> findByActiveFalse();
  List<ExampleEntity> findByActiveIsFalse();
  List<ExampleEntity> findByActive(boolean b);
}
