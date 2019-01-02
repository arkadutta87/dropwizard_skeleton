package org.arka.model;

import java.util.List;

public class BookConfigV2 {

  private int id;

  private String title;
  private List<Author> authors;

  private String dateOfPublish;

  public static class Author{

    private int id;
    private String name;

    private String dateOfBirth;

    private String nationality;

    public int getId() {
      return id;
    }

    public void setId(int id) {
      this.id = id;
    }

    public String getName() {
      return name;
    }

    public void setName(String name) {
      this.name = name;
    }

    public String getDateOfBirth() {
      return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
      this.dateOfBirth = dateOfBirth;
    }

    public String getNationality() {
      return nationality;
    }

    public void setNationality(String nationality) {
      this.nationality = nationality;
    }
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public List<Author> getAuthors() {
    return authors;
  }

  public void setAuthors(List<Author> authors) {
    this.authors = authors;
  }

  public String getDateOfPublish() {
    return dateOfPublish;
  }

  public void setDateOfPublish(String dateOfPublish) {
    this.dateOfPublish = dateOfPublish;
  }
}
