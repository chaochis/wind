package com.chaochis.windbadminweb.user.web;

import com.chaochis.wind.config.api.ApiResult;
import com.chaochis.wind.config.page_config.NeedPageHelper;
import com.chaochis.windbadminweb.user.params.WindUserQueryVo;
import com.chaochis.wind.user.service.WindUserService;
import com.chaochis.wind.user.vo.WindUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author 刘超/chaochis
 * wind用户管理接口（包含登录接口）
 */
@RestController
@RequestMapping("/user")
public class WindUserController {

  @Autowired
  private WindUserService windUserService;


  /**
   * 获取系统的用户列表
   * @param windUserQueryVo 要查询的用户列表
   * @return 返回用户列表
   */
  @GetMapping("/getList")
  @NeedPageHelper
  public ApiResult<List<WindUser>> getList(WindUserQueryVo windUserQueryVo) {
    WindUser windUser = new WindUser();
    return ApiResult.success(this.windUserService.getWindUserList(windUser));
  }

  /**
   * 根据userId获取用户详情
   * @param userId 用户id
   * @return 返回wind用户详情
   */
  @GetMapping("/getById")
  public ApiResult<WindUser> getById(String userId){
    return ApiResult.success(this.windUserService.getWindUserById(userId));
  }

}
