package org.arka.model;

import java.util.List;
import java.util.Map;

import org.cfg4j.provider.ConfigMeta;

@ConfigMeta(configKey="reksio",bindedFileName="app-config.yml" )
public class TestConfigV2 {

  private boolean awake;

  private String bornIn;

  private int birthYear;

  private List<String> friends;

  private String homepage;

  private Map<String, Character> grades;

  public boolean isAwake() {
    return awake;
  }

  public void setAwake(boolean awake) {
    this.awake = awake;
  }

  public String getBornIn() {
    return bornIn;
  }

  public void setBornIn(String bornIn) {
    this.bornIn = bornIn;
  }

  public int getBirthYear() {
    return birthYear;
  }

  public void setBirthYear(int birthYear) {
    this.birthYear = birthYear;
  }

  public List<String> getFriends() {
    return friends;
  }

  public void setFriends(List<String> friends) {
    this.friends = friends;
  }

  public String getHomepage() {
    return homepage;
  }

  public void setHomepage(String homepage) {
    this.homepage = homepage;
  }

  public Map<String, Character> getGrades() {
    return grades;
  }

  public void setGrades(Map<String, Character> grades) {
    this.grades = grades;
  }
}
