package com.chaochis.wind.util.id_generator;

public class IdGeneratorFactory {
   public static IdGenerator createIdGenerator(IdGeneratorEnum idGeneratorEnum) {
      if (null == idGeneratorEnum || IdGeneratorEnum.ID_GENERATOR_UUID_ENUM == idGeneratorEnum) {
         return new UuidGenerator();
      }
      return new UuidGenerator();
   }

   public enum IdGeneratorEnum {
      ID_GENERATOR_UUID_ENUM;
   }
}
