
import { ApiCode, ApiResult, Page, RequestUrlEnum } from '@/config/api_config/apis_class';
import { Method } from 'axios';
import { request } from '@/config/api_config/request';
import { QueryWxAccount, WxAccount } from '@/views/MainMenu/UserMenu/WxUser/WxUser';
import { reactive } from 'vue';

/**
 * 统一的请求方法
 * @param urlName 请求地址，只支持enum
 * @param config { data: any, params: any, method: Method } 参数配置
 * @return Promise<ApiResult<T>>
 */
function apiSend<T>(urlName: RequestUrlEnum, config: { data?: any, params?: any, method: Method }) : Promise<ApiResult<T>> {
  return new Promise((resolve, reject) => {
    const req = request({
      method: config.method,
      url: urlName.toString(),
      data: config.data,
      params: config.params,
    });
    req.then(res => {
      if ((res.headers['content-type']).includes('application/json')) {
        const data = reactive(res.data) as ApiResult<T>
        console.log(data)
        if (data.apiCode === ApiCode.Success) {
          resolve(data)
        } else {
          resolve(data)
        }
      }
      resolve(reactive(res.data) as ApiResult<T>)
    }).catch(reason => {
      reject(reason)
    })
  })
}
/**
 * 获取全部用户列表
 * @param data 查询参数
 */
function getWxAccountList(data: QueryWxAccount | Page | null) : Promise<ApiResult<WxAccount[]>> {
  return apiSend<WxAccount[]>(RequestUrlEnum.wxUserGetList, { data: data, method: 'post'})
}

export const apiMethod = {
  /** 用户部分相关接口 */
  getWxAccountList, // 获取用户列表
}

