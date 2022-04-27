/**
 * 用promise重新封装了wx的getUserProfile Api
 * @param {string} desc 个人信息用途声明
 * @returns {Promise<{userInfo: {avatarUrl: string, city: string,country: string, gender: number, language: 'zh_CN' | 'en' | 'zh_TW', nickName: string, province: string},encryptInfo: {encryptedData: string, iv: string}}>} 返回带有用户信息以及用于解密unionId等的信息
 */
function getUserProfile(desc) {
  return new Promise((resolve, reject) => {
    wx.getUserProfile({
      desc: desc || "用于完善个人资料", // 声明获取用户个人信息后的用途，后续会展示在弹窗中，请谨慎填写
      success: (res) => {
        console.log(res)
        let resInfo = {
          userInfo: res.userInfo,
          encryptInfo: {
            encryptedData: res.encryptedData,
            iv: res.iv
          }
        }
        resolve(resInfo)
      },
      fail: error => reject(error)
    })
  })
}

/**
 * 用promise重新封装了wx的login Api
 * @returns {string} 返回临时的code码
 */
function wxLogin() {
  return new Promise((resolve, reject) => {
    wx.login({
      timeout: 500,
      success: (res) => {
        if (res.code) {
          resolve(res.code)
        } else {
          reject(new Error("微信登录失败!"))
        }
      },
      fail: error => reject(error)
    })
  })
} 

/**
 * 重新封装了wx的request Api
 * @param {url: string, data: object, method: 'get' | 'post', header: object} param 原本的request请求参数
 * @returns Promise<{object}> 后端返回的结果
 */
function request({url, data, method, header}) {
  return new Promise((resolve, reject) => {
    wx.request({
      url: url,
      data: data,
      header: header,
      method: method,
      success: res => {
        console.log(res.data)
        if (res.data.apiCode === 200) {
          resolve(res.data.result)
        }
      },
      fail: error => reject(error)
    })
  })
}

export default{
  getUserProfile,
  wxLogin,
  request
}