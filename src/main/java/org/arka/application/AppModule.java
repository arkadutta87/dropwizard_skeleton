package org.arka.application;

import com.google.inject.name.Names;

import java.util.concurrent.TimeUnit;

import javax.sql.DataSource;

import org.arka.configuration.AppConfig;
import org.arka.configuration.ConfigService;
import org.arka.service.BooksService;
import org.arka.service.PartsService;
import org.cfg4j.provider.ConfigurationProvider;
import org.cfg4j.provider.ConfigurationProviderBuilder;
import org.cfg4j.source.ConfigurationSource;
import org.cfg4j.source.context.environment.Environment;
import org.cfg4j.source.context.environment.ImmutableEnvironment;
import org.cfg4j.source.git.GitConfigurationSourceBuilder;
import org.cfg4j.source.reload.ReloadStrategy;
import org.cfg4j.source.reload.strategy.PeriodicalReloadStrategy;
import org.skife.jdbi.v2.DBI;

public class AppModule extends SkeletonDropwizardAwareModule<AppConfig> {

  private static final String SQL = "sql";

  @Override
  protected void configure() {

    bindPartsService();
    bindConfigurationProvider();
    bind(BooksService.class).asEagerSingleton();
    bind(ConfigService.class).asEagerSingleton();

  }

  private void bindConfigurationProvider() {
    String configRepoPath = configuration().getGitConfig().getConfigRepoPath();
    String branch = configuration().getGitConfig().getBranch();

    ConfigurationSource source = new GitConfigurationSourceBuilder()
        .withRepositoryURI(configRepoPath)
        .build();

    // Select branch to use (use new DefaultEnvironment()) for master
    Environment environment = new ImmutableEnvironment(branch);

    // Reload configuration every 5 seconds
    ReloadStrategy reloadStrategy = new PeriodicalReloadStrategy(2, TimeUnit.MINUTES);

    // Create provider
    ConfigurationProvider configurationProvider = new ConfigurationProviderBuilder()
        .withConfigurationSource(source)
        .withEnvironment(environment)
        .withReloadStrategy(reloadStrategy)
        .build();
    bind(ConfigurationProvider.class).annotatedWith(Names.named("configProvider")).toInstance(configurationProvider);

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
