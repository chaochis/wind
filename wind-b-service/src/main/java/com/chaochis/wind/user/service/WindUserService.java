package com.chaochis.wind.user.service;


import com.chaochis.wind.user.vo.WindUser;

import java.util.List;

/**
 * @author chaochis
 */
public interface WindUserService {
  /**
   * 获取所有的风旅用户列表
   * @param windUser 要查询的参数
   * @return  风旅用户列表
   */
  List<WindUser> getWindUserList(WindUser windUser);

  /**
   * 根据id获取单个用户
   * @param id 用户的id
   * @return 查询出来的用户
   */
  WindUser getWindUserById(String id);
}
