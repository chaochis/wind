<template>
	<view>
		<button open-type="getUserInfo" @tap="tryGetUser">点我</button>
		<view>你好</view>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				
			}
		},
		onLoad() {
			this.tryGetUser()
		},
		methods: {
			tryGetUser() {
				uni.request({
					url: "http://localhost:3000",
					success: (res) => {
						console.log(res)
					}
				})
			}
		}
	}
</script>

<style>

</style>
