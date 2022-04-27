import apis from "../../apis/apis"
import wxApis from "../../apis/wxApis"

// pages/personal-center/index.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    userInfo: null
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
  },
  async goLogin(e) {
    let resInfo = await wxApis.getUserProfile()
    let code = await wxApis.wxLogin()
    let data = {
      userInfo: resInfo.userInfo,
      code: code,
      encryptedInfo: resInfo.encryptInfo
    }
    let token = await apis.wxLogin(data)
  }
})