package com.chaochis.wind.util.id_generator;

import java.util.UUID;

public class UuidGenerator implements IdGenerator {

  @Override
  public String generator() {
    return UUID.randomUUID().toString().replaceAll("-", "");
  }
}
