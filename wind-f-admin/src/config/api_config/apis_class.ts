// 标识数据状态
export enum ApiCode {
  Success = 200, // 成功
  Fail = 100 // 失败
}

// 分页类
export interface Page {
  pageLimit: number; // 一页有多少数据
  pageIndex: number; // 第几页
  total?: number; // 数据总量
  order?: string; // 排序字段
}

// 请求结果类
export interface ApiResult<T> {
  page: Page | null; // 分页数据
  msg: string | null; // 数据请求失败后返回的信息
  apiCode: ApiCode; // 请求状态
  result: T; // 返回的结果
}

// 请求的后端地址的枚举
export const enum RequestUrlEnum {
  // 以下是微信用户管理相关接口
  wxUserGetList = '/wxAccount/getWxAccountList' // 获取微信账户列表
}

export interface AuthToken{
  token: string;
}
