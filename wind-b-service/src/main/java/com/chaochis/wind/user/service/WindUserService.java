package com.chaochis.wind.user.service;


import com.chaochis.wind.common_exceptions.UserHasTombstoneException;
import com.chaochis.wind.user.vo.WindUser;
import com.chaochis.wind.user.vo.WxAccount;

import java.util.List;

/**
 * 风旅用户基本信息接口
 * @author 刘超/chaochis
 */
public interface WindUserService {

  List<WindUser> getWindUserList(WindUser windUser);


  WindUser getWindUserById(String id);

  void addWindUser(WindUser windUser);

  void updateWindUser(WindUser windUser);

}
