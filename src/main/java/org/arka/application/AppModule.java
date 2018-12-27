package org.arka.application;

import com.google.inject.name.Names;

import javax.sql.DataSource;

import org.arka.configuration.AppConfig;
import org.arka.service.BooksService;
import org.arka.service.PartsService;
import org.skife.jdbi.v2.DBI;

public class AppModule extends SkeletonDropwizardAwareModule<AppConfig> {

  private static final String SQL = "sql";

  @Override
  protected void configure() {

    bindPartsService();
    bind(BooksService.class).asEagerSingleton();

  }

  private void bindPartsService() {
    // Datasource configuration
    final DataSource dataSource =
        configuration().getDataSourceFactory().build(environment().metrics(), SQL);
    DBI dbi = new DBI(dataSource);

    PartsService partsService = dbi.onDemand(PartsService.class);

    bind(PartsService.class).annotatedWith(Names.named("partsService")).toInstance(partsService);
  }

  @Override
  public int hashCode() {
    return AppModule.class.hashCode();
  }

  @Override
  public boolean equals(Object obj) {
    return obj instanceof AppModule;
  }
}
