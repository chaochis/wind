login() {
	wx.getUserProfile({desc: "登录",success: res => { console.log(res); }})
}