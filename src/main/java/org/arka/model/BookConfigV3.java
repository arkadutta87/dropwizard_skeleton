package org.arka.model;

import java.util.List;

import org.cfg4j.provider.ConfigMeta;

@ConfigMeta(configKey="booksConfig",bindedFileName="books.json" )
public class BookConfigV3 {

  private List<BookConfigV2> books;

  public List<BookConfigV2> getBooks() {
    return books;
  }

  public void setBooks(List<BookConfigV2> books) {
    this.books = books;
  }
}
