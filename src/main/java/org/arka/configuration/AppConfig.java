package org.arka.configuration;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;


import org.arka.model.Book;

import io.dropwizard.Configuration;
import io.dropwizard.db.DataSourceFactory;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AppConfig extends Configuration {

  private static final String DATABASE = "database";

  @JsonProperty
  @NotNull
  @Valid
  private List<Book> booksConfigured;

  @JsonProperty
  @NotNull
  @Valid
  private GitConfig gitConfig;

  @Valid
  @NotNull
  private DataSourceFactory dataSourceFactory = new DataSourceFactory();

  @JsonProperty(DATABASE)
  public DataSourceFactory getDataSourceFactory() {
    return dataSourceFactory;
  }

  @JsonProperty(DATABASE)
  public void setDataSourceFactory(final DataSourceFactory dataSourceFactory) {
    this.dataSourceFactory = dataSourceFactory;
  }

  public List<Book> getBooksConfigured() {
    return booksConfigured;
  }

  public GitConfig getGitConfig() {
    return gitConfig;
  }
}
