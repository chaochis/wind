package com.chaochis.wind.config.key_config;

import com.chaochis.wind.util.id_generator.IdGenerator;
import com.chaochis.wind.util.id_generator.IdGeneratorFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 系统中各种键的生成器
 * @author 刘超/chaochis
 */
@Configuration
public class GeneratorKeyConfig {
  /**
   * 主键生成bean
   * @return 主键生成器
   */
  @Bean("mainKeyGenerator")
  public IdGenerator mainKeyGenerator() {
    return IdGeneratorFactory.createIdGenerator(IdGeneratorFactory.IdGeneratorEnum.ID_GENERATOR_UUID_ENUM);
  }

  @Bean("tokenGenerator")
  public IdGenerator tokenKeyGenerator() {
    return IdGeneratorFactory.createIdGenerator(IdGeneratorFactory.IdGeneratorEnum.ID_GENERATOR_JWTTOKEN_ENUM);
  }
}
