// index.js

import store from "../../store/store"

// 获取应用实例
const app = getApp()

Page({
  data: {
  },
  onTap () {
    console.log(store.token)
  }
})
