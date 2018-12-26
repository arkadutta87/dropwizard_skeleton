package org.arka.application;

import io.dropwizard.Configuration;
import ru.vyarus.dropwizard.guice.module.support.DropwizardAwareModule;

public abstract class SkeletonDropwizardAwareModule<T extends Configuration> extends DropwizardAwareModule<T> {

  public SkeletonDropwizardAwareModule() {
  }

  protected void importModule(DropwizardAwareModule module) {
    T configuration = this.configuration();
    module.setConfiguration(configuration);
    module.setEnvironment(this.environment());
    module.setBootstrap(this.bootstrap());
    this.install(module);
  }
}
