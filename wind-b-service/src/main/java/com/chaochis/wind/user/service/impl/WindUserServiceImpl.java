package com.chaochis.wind.user.service.impl;

import com.chaochis.wind.querywrapper.EntityQueryWrapperFactory;
import com.chaochis.wind.user.mapper.WindUserMapper;
import com.chaochis.wind.user.service.WindUserService;
import com.chaochis.wind.user.vo.WindUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 风旅用户基本信息管理服务
 * @author 刘超/chaochis
 */
@Service("windUserService")
public class WindUserServiceImpl implements WindUserService {
  @Autowired
  private WindUserMapper windUserMapper;

  /**
   * 获取所有的风旅用户列表
   * @param windUser 要查询的参数
   * @return  风旅用户列表
   */
  @Override
  public List<WindUser> getWindUserList(WindUser windUser) {
    return this.windUserMapper.selectList(EntityQueryWrapperFactory.createQueryWrapper(windUser));
  }

  /**
   * 根据id获取单个用户
   * @param id 用户的id
   * @return 查询出来的用户
   */
  @Override
  public WindUser getWindUserById(String id) {
    return this.windUserMapper.selectById(id);
  }

  /**
   * 新增一个风旅用户基本信息
   * @param windUser 风旅用户信息
   */
  @Override
  public void addWindUser(WindUser windUser) {
    this.windUserMapper.insert(windUser);
  }

  @Override
  public void updateWindUser(WindUser windUser) {
    this.windUserMapper.updateById(windUser);
  }
}
