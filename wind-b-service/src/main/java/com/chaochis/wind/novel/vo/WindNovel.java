package com.chaochis.wind.novel.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.chaochis.wind.enums.DataStatus;
import com.chaochis.wind.enums.NovelType;
import com.chaochis.wind.vo.BaseVo;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@TableName("wind_novel")
/**
 * 风旅小说表 （暂时用于储存自己写作小说的地方）
 * @author 刘超/chaochis
 */
public class WindNovel implements Serializable, BaseVo {
  /**
   * 小说id
   */
  @TableId("novel_id")
  private String novelId;
  /**
   * 小说书号
   */
  @TableField("novel_no")
  private String novelNo;
  /**
   * 小说名字
   */
  @TableField("novel_name")
  private String novelName;
  /**
   * 小说类型
   */
  @TableField("novel_type")
  private NovelType novelType;
  /**
   * 小说类型中文名称
   */
  @TableField("novel_type_text")
  private String novelTypeText;
  /**
   * 小说描述
   */
  @TableField("novel_describe")
  private String novelDescribe;
  /**
   * 给读者的话
   */
  @TableField("novel_text_to_reader")
  private String novelTextToReader;
  /**
   * 小说的状态
   */
  @TableField("novel_status")
  private DataStatus novelStatus;
  /**
   * 小说的状态中文字段
   */
  @TableField("novel_status_text")
  private String novelStatusText;
  /**
   * 小说的字数
   */
  @TableField("novel_count")
  private Integer novelCount;
  /**
   * 小说点赞量
   */
  @TableField("novel_fabulous_count")
  private Integer novelFabulousCount;
  /**
   * 小说收到的鲜花数
   */
  @TableField("novel_flow_count")
  private Integer novelFlowCount;
  /**
   * 小说的阅读量
   */
  @TableField("novel_read_count")
  private Integer novelReadCount;
  /**
   * 小说的收藏量
   */
  @TableField("novel_collection_count")
  private Integer novelCollectionCount;
  /**
   * 创造该小说的人的id
   */
  @TableField("create_by_id")
  private String CreateById;
  /**
   * 创造该小说的时间
   */
  @TableField("createByDate")
  @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
  @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
  private LocalDateTime createDate;
  /**
   * 更新该小说的时间
   */
  @TableField("updateDate")
  @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
  @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
  private LocalDateTime updateDate;
  /**
   * 小说分组
   */
  @TableField("novelGroup")
  private String NovelGroup;
}
