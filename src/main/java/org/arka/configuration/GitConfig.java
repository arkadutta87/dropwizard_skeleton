package org.arka.configuration;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GitConfig {

  private String configRepoPath;
  private String branch;

  private List<String> configFiles;

  public String getConfigRepoPath() {
    return configRepoPath;
  }

  public String getBranch() {
    return branch;
  }

  public List<String> getConfigFiles() { return configFiles; }
}
