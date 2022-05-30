import localApi from "./package_local_apis";

// 微信基础api接口地址
let wxApiRoot = 'http://localhost:8089/';

// 后端的api信息
let apiInfo = {
  wxLogin: { url: wxApiRoot + 'wxAccount/loginOrRegisterByWx', method: 'post'} // 登录接口
}

/**
 * 微信登录接口
 * @param {{code: string, encryptedInfo: { encryptedData: string, iv: string }, userInfo: {avatarUrl: string, city: string,country: string, gender: number, language: 'zh_CN' | 'en' | 'zh_TW', nickName: string, province: string}} data 要传递给后端的数据接口
 * @returns {Promise<string>} 返回token
 */
function wxLogin(data) {
  return uniApi.request({url: apiInfo.wxLogin.url, data, method: apiInfo.wxLogin.method})
}

export default {
  wxLogin
}