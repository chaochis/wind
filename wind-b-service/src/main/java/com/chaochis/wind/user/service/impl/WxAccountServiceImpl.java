package com.chaochis.wind.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.chaochis.wind.common_exceptions.UserHasTombstoneException;
import com.chaochis.wind.constant.DatabaseInfoNullDefault;
import com.chaochis.wind.enums.DataStatus;
import com.chaochis.wind.user.mapper.WxAccountMapper;
import com.chaochis.wind.user.service.WxAccountService;
import com.chaochis.wind.user.vo.WindUser;
import com.chaochis.wind.user.vo.WxAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 微信账户管理的service
 * @author 刘超/chaochis
 */
@Service("wxAccountService")
public class WxAccountServiceImpl implements WxAccountService {
  @Autowired
  private WxAccountMapper wxAccountMapper;


  /**
   * 获取微信账户列表
   * @param wxAccount 要查询的微信账户对象
   * @return 微信账户列表
   */
  @Override
  public List<WxAccount>  getWxAccountList(WxAccount wxAccount) {
    return this.wxAccountMapper.getWxAccountList(wxAccount);
  }

  /**
   * 通过openId获取单个微信账户
   * @param openId 微信的openId
   * @return 获取单个微信账户
   */
  @Override
  public WxAccount getWxAccountByOpenId(String openId) {
    QueryWrapper<WxAccount> queryWrap = new QueryWrapper<>();
    queryWrap.eq("open_id", openId);
    return this.wxAccountMapper.selectOne(queryWrap);
  }

  /**
   * 添加一个微信账户
   * @param wxAccount 要添加的微信账户
   */
  @Override
  public void addWxAccount(WxAccount wxAccount) {
    this.wxAccountMapper.insert(wxAccount);
  }

  /**
   * 更新微信账户的信息
   * @param wxAccount 要更新的微信账户信息
   */
  @Override
  @Transactional
  public void updateWxAccount(WxAccount wxAccount) {
    this.wxAccountMapper.updateById(wxAccount);
  }

  /**
   * 逻辑删除某个账户
   * @param accountId 要删除的微信账户
   * @throws UserHasTombstoneException 抛出微信用户被逻辑删除的错误
   */
  @Override
  @Transactional
  public void tombstoneWxAccount(String accountId) throws UserHasTombstoneException {
    WxAccount searchWxAccount = this.wxAccountMapper.selectById(accountId);
    if (DataStatus.Deleted == searchWxAccount.getAccountStatus()) {
      throw new UserHasTombstoneException("此微信用户已被逻辑删除，请勿重复删除!");
    } else {
      var tombstoneAccount = new WxAccount();
      tombstoneAccount.setAccountId(accountId);
      tombstoneAccount.setAccountStatus(DataStatus.Deleted);
      tombstoneAccount.setAccountStatusText(DataStatus.Deleted.getText());
      tombstoneAccount.setUpdateDate(LocalDateTime.now());
      tombstoneAccount.setUpdateById(DatabaseInfoNullDefault.WX_ACCOUNT_UPDATE_BY_ID_NULL_DEFAULT);
      this.wxAccountMapper.updateById(tombstoneAccount);
    }
  }

  /**
   * 物理删除微信用户
   * @param accountId 微信用户id
   * @throws Exception 抛出不允许删除已激活的用户的异常
   */
  @Override
  @Transactional
  public void deleteWxAccount(String accountId) throws Exception {
    WxAccount wxAccount = this.wxAccountMapper.selectById(accountId);
    if (DataStatus.Normal == wxAccount.getAccountStatus()) {
      throw new Exception("不允许删除已被激活的用户");
    } else {
      this.wxAccountMapper.deleteById(accountId);
    }
  }

  /**
   * 获取微信账户绑定的真实windUser对象
   * @param accountId 微信用户id
   * @return 返回绑定的真实windUser对象
   */
  @Override
  public WindUser getWxBoundWindUserByAccountId(String accountId) {
    return this.wxAccountMapper.getBoundWindUser(accountId);
  }
}
