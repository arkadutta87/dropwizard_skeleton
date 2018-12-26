package org.arka.model;

import java.util.List;

import org.hibernate.validator.constraints.NotEmpty;

public class Book {

  private int id;

  @NotEmpty
  private String title;

  @NotEmpty
  private List<String> authors;

  @NotEmpty
  private String dateOfPublish;

  public int getId() {
    return id;
  }

  public String getTitle() {
    return title;
  }

  public List<String> getAuthors() {
    return authors;
  }

  public String getDateOfPublish() {
    return dateOfPublish;
  }
}
