package org.arka.model;

import java.util.List;

public interface BookV2 {

  Integer id();

  String title();
  List<Author> authors();

  String dateOfPublish();

}
