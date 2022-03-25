package com.raniagus.library;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class LibraryApplication {
  private BookRepository bookRepository;

  @Autowired
  public LibraryApplication(BookRepository bookRepository) {
    this.bookRepository = bookRepository;
  }

  @Component
  class DataSetup implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments args) throws Exception {
      bookRepository.save(
          Book.builder()
              .title("Gone with the Wind")
              .isbn("DSAF7534")
              .build()
      );
      bookRepository.save(
          Book.builder()
              .title("Effective Java")
              .isbn("FASF5223")
              .build()
      );
    }
  }

  public static void main(String[] args) {
    SpringApplication.run(LibraryApplication.class, args);
  }
}
