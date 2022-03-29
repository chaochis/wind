package com.chaochis.wind.user.web;

import com.chaochis.wind.api.ApiResult;
import com.chaochis.wind.user.service.WindUserService;
import com.chaochis.wind.user.vo.WindUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Administrator
 */
@RestController
@RequestMapping("/user")
public class WindUserController {

  @Autowired
  private WindUserService windUserService;

  @GetMapping("/getList")
  public ApiResult<List<WindUser>> getList(WindUser windUser) {
    if(null == windUser) {
      windUser = new WindUser();
    }
    return ApiResult.success(this.windUserService.getWindUserList(windUser));
  }

  @GetMapping("/getById")
  public ApiResult<WindUser> getById(String userId){
    return ApiResult.success(this.windUserService.getWindUserById(userId));
  }
}
