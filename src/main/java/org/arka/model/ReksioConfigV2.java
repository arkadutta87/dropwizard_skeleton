package org.arka.model;

import java.util.List;
import java.util.Map;

public interface ReksioConfigV2 {

  Boolean awake();

  String bornIn();

  Integer birthYear();

  List<String> friends();

  String homepage();

  Map<String, Character> grades();
}
