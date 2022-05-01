package com.chaochis.wind.config.page_config;

import com.chaochis.wind.config.api.ApiResult;
import com.chaochis.wind.config.page_config.page_vo.RequestPage;
import com.chaochis.wind.config.page_config.page_vo.ResponsePage;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;

import java.util.List;

import static com.github.pagehelper.page.PageMethod.startPage;

@Aspect
@Configuration
public class PageConfig implements Ordered {

  /**
   * 织入切面 - 分页 应用于有NeedPage注解以及最后一个参数为WPage类
   * @param joinPoint 切点
   * @return 添加了分页信息的对象
   * @throws Throwable 其中的异常，全抛出
   */
  @Around("needPage() && needPageArgs()")
  public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable {
    return this.handlePage(joinPoint);
  }

  // 切点，需要pageHelper分页的切点
  @Pointcut("@annotation(com.chaochis.wind.config.page_config.NeedPageHelper)")
  private void needPage() {
  }

  @Pointcut("args(com.chaochis.wind.config.page_config.page_vo.RequestPage) || args(com.chaochis.wind.config.page_config.page_vo.RequestPage, *)")
  private void needPageArgs() {
  }

  public Object handlePage(ProceedingJoinPoint joinPoint) throws Throwable {
    Object[] args = joinPoint.getArgs();
    RequestPage basePage = (RequestPage) args[0];
    boolean isStartPage = null != basePage && basePage.getPageIndex() != null && basePage.getPageIndex() >= 1 && basePage.getPageLimit() != null && basePage.getPageLimit() >= 0;
    if (isStartPage) {
      startPage(basePage.getPageIndex(), basePage.getPageLimit(), basePage.getOrder());
    }
    ApiResult<?> result = (ApiResult<?>)joinPoint.proceed();
    if (isStartPage && result.getResult() instanceof List) {
      ResponsePage page = ResponsePage.buildWithPageInfo(new PageInfo<>((List<?>) result.getResult()));
      result.setPage(page);
    }
    return result;
  }

  @Override
  public int getOrder() {
    return 0;
  }
}
