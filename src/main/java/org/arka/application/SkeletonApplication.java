package org.arka.application;

import io.dropwizard.Application;
import io.dropwizard.auth.AuthDynamicFeature;
import io.dropwizard.auth.oauth.OAuthCredentialAuthFilter;
import io.dropwizard.configuration.EnvironmentVariableSubstitutor;
import io.dropwizard.configuration.SubstitutingSourceProvider;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import ru.vyarus.dropwizard.guice.GuiceBundle;

import org.arka.authentication.DropwizardBlogAuthenticator;
import org.arka.authentication.DropwizardBlogAuthorizer;
import org.arka.authentication.User;
import org.arka.configuration.AppConfig;
import org.glassfish.jersey.server.filter.RolesAllowedDynamicFeature;

public class SkeletonApplication extends Application<AppConfig> {

  private static final String DROPWIZARD_BLOG_SERVICE = "Dropwizard blog service";
  private static final String BEARER = "Bearer";

  public static void main(String[] args) throws Exception {
    new SkeletonApplication().run(args);
  }

  @Override
  public void initialize(Bootstrap<AppConfig> bootstrap) {
    // Enable variable substitution with environment variables
    bootstrap.setConfigurationSourceProvider(
        new SubstitutingSourceProvider(bootstrap.getConfigurationSourceProvider(), new EnvironmentVariableSubstitutor()));

    bootstrap.addBundle(GuiceBundle.builder().enableAutoConfig("org.arka").modules(new AppModule()).printDiagnosticInfo().build());
  }

  @Override
  public void run(AppConfig configuration, Environment environment) {

    environment.jersey()
               .register(new AuthDynamicFeature(new OAuthCredentialAuthFilter.Builder<User>()
                                                    .setAuthenticator(new DropwizardBlogAuthenticator())
                                                    .setAuthorizer(new DropwizardBlogAuthorizer()).setPrefix(BEARER).buildAuthFilter()));
    environment.jersey().register(RolesAllowedDynamicFeature.class);
  }
}
