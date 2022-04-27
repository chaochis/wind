package com.chaochis.wind.config.key_config;

import com.chaochis.wind.util.id_generator.IdGeneratorFactory;
import com.chaochis.wind.util.id_generator.UuidGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GeneratorKeyConfig {
  @Bean
  public UuidGenerator uuidGenerator() {
    return (UuidGenerator) IdGeneratorFactory.createIdGenerator(IdGeneratorFactory.IdGeneratorEnum.ID_GENERATOR_UUID_ENUM);
  }
}
