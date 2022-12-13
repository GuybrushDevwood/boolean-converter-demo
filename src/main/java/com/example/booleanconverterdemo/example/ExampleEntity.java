package com.example.booleanconverterdemo.example;

import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.type.YesNoConverter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Table
@Entity
public class ExampleEntity {

  @Id
  @GeneratedValue(generator = "system-uuid")
  @GenericGenerator(name = "system-uuid", strategy = "uuid")
  @Column(nullable = false, updatable = false)
  private String id;

  @Convert(converter = YesNoConverter.class)
  private boolean active;
}
