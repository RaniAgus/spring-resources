package com.raniagus.library;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Data
@Entity
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Book {
  @Id
  @GeneratedValue
  private Long id;
  @NotNull
  private String title;
  @NotNull
  private String isbn;


}
