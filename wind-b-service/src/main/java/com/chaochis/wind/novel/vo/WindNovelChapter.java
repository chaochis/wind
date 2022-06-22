package com.chaochis.wind.novel.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.chaochis.wind.enums.NovelType;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@TableName("wind_novel_chapter")
/**
 * 小说的章节表
 * @author 刘超/chaochis
 */
public class WindNovelChapter {
  /**
   * 小说章节id
   */
  @TableId("chapter_id")
  private String chapterId;
  /**
   * 绑定的小说id
   */
  @TableField("novel_id")
  private String novelId;
  /**
   * 章节标题
   */
  @TableField("chapter_title")
  private String chapterTitle;
  /**
   * 章节状态
   */
  @TableField("chapter_status")
  private NovelType chapterStatus;
  /**
   * 章节状态中文名称
   */
  @TableField("chapter_status_text")
  private String chapterStatusText;
  /**
   * 创造该章节的时间
   */
  @TableField("create_date")
  private NovelType createDate;
  /**
   * 该章节的更新时间
   */
  @TableField("update_date")
  private String updateDate;
  /**
   * 该章阅读量
   */
  @TableField("chapter_reader_count")
  private NovelType chapterReaderCount;
}
