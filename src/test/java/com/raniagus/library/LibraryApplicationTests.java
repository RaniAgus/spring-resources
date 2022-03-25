package com.raniagus.library;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.emptyIterable;
import static org.hamcrest.CoreMatchers.not;

@SpringBootTest
class LibraryApplicationTests {

  @Autowired
  private BookRepository bookRepository;

  @Test
  public void contextLoads() {
  }

  @Test
  public void persistenceWorks() {
    assertThat(bookRepository.findAll(), not(emptyIterable()));
  }

}
