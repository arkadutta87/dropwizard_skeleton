package org.arka.service;

import com.google.inject.Inject;

import java.util.List;

import org.arka.configuration.AppConfig;
import org.arka.model.Book;

public class BooksService {

  @Inject
  private AppConfig appConfig;

  public List<Book> getBooks() {
    return appConfig.getBooksConfigured();
  }
}
