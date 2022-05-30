package com.chaochis.wind.util.id_generator.generator_impl;

import com.chaochis.wind.util.id_generator.IdGenerator;

import java.util.UUID;

public class UuidGenerator implements IdGenerator {

  @Override
  public String generator() {
    return UUID.randomUUID().toString().replaceAll("-", "");
  }
}
