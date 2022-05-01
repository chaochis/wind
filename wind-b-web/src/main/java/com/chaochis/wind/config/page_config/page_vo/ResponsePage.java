package com.chaochis.wind.config.page_config.page_vo;

import com.chaochis.wind.base.vo.BasePage;
import com.github.pagehelper.PageInfo;
import lombok.*;

/**
 * 本类是用于传递给前端的列表分页类属性
 * @author 刘超/chaochis
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
public class ResponsePage extends BasePage {
  private Long total;
  public ResponsePage(Integer pageIndex, Integer pageLimit, Long total) {
    this.total = total;
    this.setPageLimit(pageLimit);
    this.setPageIndex(pageIndex);
  }
  public static<T> ResponsePage buildWithPageInfo(PageInfo<T> pageInfo) {
    return new ResponsePage(pageInfo.getPageNum(), pageInfo.getPageSize(), pageInfo.getTotal());
  }
}
