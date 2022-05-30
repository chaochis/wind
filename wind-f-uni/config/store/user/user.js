import localApis from '@/config/apis/local_apis.js'
const user = {
  state: {
    _token: null,
    _user: null
  },
	getters:{
		token: state => state._token,
		user: state => state._user
	},
	mutations: {
		setToken: (state, val) => state._token = val,
		setUser: (state, val) => state._user = val
	},
  
  actions: {
    // 用户登录(普通登录: 输入手机号和验证码)
    loginByPhone({ commit }, data) {
      return new Promise((resolve, reject) => {
      })
    },

    // 微信小程序一键授权登录(获取用户基本信息)
    loginByWx({ commit }) {
      return new Promise(async (resolve, reject) => {
				let resInfo = await localApis.getWxUserProfile()
				let code = await localApis.wxLogin()
				commit('setUser', resInfo.userInfo)
				commit('setToken', code)
				resolve()
      })
    },

  
    // 退出登录
    Logout({ commit }, data) {
      return new Promise((resolve, reject) => {
        commit('setToken', null)
        commit('setUser', null)
        resolve()
      })
    }

  }
}

export default user
