package com.chaochis.wind.querywrapper;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * @author chaochis
 * 该类用于将entity对象生成Mybatis-Plus查询所需要的QueryMapper
 */
public class EntityQueryWrapperFactory<T> {
  /**
   * 生成QueryMapper
   * @param entity 生成原始对象
   * @param <T> 原始对象的类属性
   * @return 返回生成的QueryMapper对象
   */
  public static <T> QueryWrapper<T> createQueryWrapper(T entity) {
    QueryWrapper<T> queryWrapper = new QueryWrapper<T>();
    if (null != entity) {
      Field [] fields = entity.getClass().getDeclaredFields();
      try {
        for (Field field : fields) {
          field.setAccessible(true);
          // 如果值不为空，且不是静态的serialVersionUID,就添加进判断条件中
          if (null != field.get(entity) && !Modifier.isStatic(field.getModifiers())) {
            // 目前先不判断TableId, 如果有TableField注解就取TableField注解，没有就取本身那个字段名
            TableField paramName = field.getDeclaredAnnotation(TableField.class);
            String fieldName = null == paramName ? field.getName() : paramName.value();
            queryWrapper.setEntity(entity);
          }
        }
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
    return queryWrapper;
  }

}
