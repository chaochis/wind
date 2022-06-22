/**
 * 查询账号用
 */
export interface QueryWxAccount{
  accountName?: string | null;
}

/**
 * 微信账号
 */
export interface WxAccount{
  wxNickName?: string;
  wxAvatar?: string;
  userId?: string;
}
