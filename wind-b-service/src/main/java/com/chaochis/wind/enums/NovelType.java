package com.chaochis.wind.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import lombok.Getter;

/**
 * 小说类型
 * @author 刘超/chaochis
 */
@Getter
public enum NovelType implements BaseEnum{
  /**
   * 0 - 长篇小说 1 - 短篇小说 2 - 小说片段
   */
  LongNovel(0, "长篇小说"),
  ShortNovel(1, "短篇小说"),
  NovelFragment(2, "小说片段");
  @EnumValue
  private final Integer value;
  private final String text;
  NovelType(Integer value, String text) {
    this.value = value;
    this.text = text;
  }
}
