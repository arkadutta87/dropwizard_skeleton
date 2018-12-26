package org.arka.healthcheck;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.google.inject.name.Named;

import org.arka.service.PartsService;
import org.skife.jdbi.v2.DBI;

import ru.vyarus.dropwizard.guice.module.installer.feature.health.NamedHealthCheck;

@Singleton
public class DropwizardBlogApplicationHealthCheck extends NamedHealthCheck {

  private static final String HEALTHY = "The Dropwizard blog Service is healthy for read and write";
  private static final String UNHEALTHY = "The Dropwizard blog Service is not healthy. ";
  private static final String MESSAGE_PLACEHOLDER = "{}";

  @Inject
  @Named("partsService")
  private PartsService partsService;

  public DropwizardBlogApplicationHealthCheck() {
  }

  @Override
  public String getName() {
    return "Health-check of the Application: Whether DB is reachable or not";
  }

  @Override
  public Result check() throws Exception {
    String mySqlHealthStatus = partsService.performHealthCheck();

    if (mySqlHealthStatus == null) {
      return Result.healthy(HEALTHY);
    }
    else {
      return Result.unhealthy(UNHEALTHY + MESSAGE_PLACEHOLDER, mySqlHealthStatus);
    }
  }
}
