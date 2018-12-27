package org.arka.configuration;

import com.google.inject.Inject;
import com.google.inject.name.Named;

import org.arka.model.ReksioConfig;
import org.cfg4j.provider.ConfigurationProvider;
import org.eclipse.jetty.util.annotation.Name;

public class ConfigService {

  private ReksioConfig reksioConfig;

  @Inject
  public ConfigService(@Named("configProvider") ConfigurationProvider configurationProvider) {
    // Use Git repository as configuration store
    this.reksioConfig = configurationProvider.bind("reksio", ReksioConfig.class);
  }

  public ReksioConfig getReksioConfig() {
    return reksioConfig;
  }
}
