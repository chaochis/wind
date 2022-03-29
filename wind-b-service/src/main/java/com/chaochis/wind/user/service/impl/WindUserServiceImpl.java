package com.chaochis.wind.user.service.impl;

import com.chaochis.wind.querywrapper.EntityQueryWrapperFactory;
import com.chaochis.wind.user.mapper.WindUserMapper;
import com.chaochis.wind.user.service.WindUserService;
import com.chaochis.wind.user.vo.WindUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author chaochis
 */
@Service("windUserService")
public class WindUserServiceImpl implements WindUserService {
  @Autowired
  private WindUserMapper windUserMapper;

  @Override
  public List<WindUser> getWindUserList(WindUser windUser) {
    return this.windUserMapper.selectList(EntityQueryWrapperFactory.createQueryWrapper(windUser));
  }

  @Override
  public WindUser getWindUserById(String id) {
    return this.windUserMapper.selectById(id);
  }
}
