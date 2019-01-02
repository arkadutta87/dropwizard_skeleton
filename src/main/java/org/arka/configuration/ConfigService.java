package org.arka.configuration;

import com.google.inject.Inject;
import com.google.inject.name.Named;

import org.arka.model.BookConfigV2;
import org.arka.model.BookConfigV3;
import org.arka.model.BookV2;
import org.arka.model.ReksioConfigV2;
import org.arka.model.TestConfigV2;
import org.cfg4j.provider.ConfigurationProvider;

public class ConfigService {

  ConfigurationProvider configurationProvider;

  @Inject
  public ConfigService(@Named("configProvider") ConfigurationProvider configurationProvider) {
    // Use Git repository as configuration store
    this.configurationProvider = configurationProvider;
//    configurationProvider.bindKey("reksio", TestConfigV2.class);
//    configurationProvider.bindKey("books", BookConfigV2.class);
  }

  private <T> T getConfigObject(String prefix, Class<T> type){
    return this.configurationProvider.extract(prefix, type);
  }

  public TestConfigV2 getReksioConfig() {
    return getConfigObject("reksio",TestConfigV2.class );
  }

  public BookConfigV3 getBookV2() {
    return getConfigObject("booksConfig", BookConfigV3.class);
  }
}
