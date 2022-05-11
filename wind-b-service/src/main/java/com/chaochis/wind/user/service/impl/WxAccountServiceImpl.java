package com.chaochis.wind.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.chaochis.wind.common_exceptions.DataHasTombstoneException;
import com.chaochis.wind.enums.DataStatus;
import com.chaochis.wind.user.mapper.WxAccountMapper;
import com.chaochis.wind.user.service.WxAccountService;
import com.chaochis.wind.user.vo.WxAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service("wxAccountService")
public class WxAccountServiceImpl implements WxAccountService {
  @Autowired
  private WxAccountMapper wxAccountMapper;


  @Override
  public List<WxAccount>  getWxAccountList(WxAccount wxAccount) {
    return this.wxAccountMapper.getWxAccountList(wxAccount);
  }

  @Override
  public WxAccount getWxAccountByOpenId(String openId) {
    QueryWrapper<WxAccount> queryWrap = new QueryWrapper<>();
    queryWrap.eq("open_id", openId);
    return this.wxAccountMapper.selectOne(queryWrap);
  }

  @Override
  public void addWxAccount(WxAccount wxAccount) {
    this.wxAccountMapper.insert(wxAccount);
  }

  @Override
  public void updateWxAccount(WxAccount wxAccount) {
    this.wxAccountMapper.updateById(wxAccount);
  }

  @Override
  public void tombstoneWxAccount(WxAccount wxAccount) throws DataHasTombstoneException {
    WxAccount searchWxAccount = this.wxAccountMapper.selectById(wxAccount.getAccountId());
    if (DataStatus.Deleted == searchWxAccount.getAccountStatus()) {
      throw new DataHasTombstoneException("此微信用户已被逻辑删除，请勿重复删除!");
    } else {
      this.wxAccountMapper.updateById(wxAccount);
    }
  }
}
