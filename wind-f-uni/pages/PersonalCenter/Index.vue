<template>
	<view class="content">
		<button open-type='getUserInfo' @click="login()">获取个人信息</button>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				title: 'Hello'
			}
		},
		onLoad() {

		},
		methods: {
			login() {
				wx.getUserProfile({desc: "登录",success: res => { console.log(res); }})
			}
		}
	}
</script>

<style>
	
</style>
