package org.arka.configuration;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GitConfig {

  private String configRepoPath;
  private String branch;

  public String getConfigRepoPath() {
    return configRepoPath;
  }

  public String getBranch() {
    return branch;
  }
}
