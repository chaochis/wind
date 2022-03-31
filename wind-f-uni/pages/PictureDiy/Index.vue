<template>
	<view class="content">
	</view>
</template>

<script>
	export default {
		data() {
			return {
				userInfo: null
			}
		},
		onLoad() {
			this.appLoginWx()
		},
		methods: {
			appLoginWx(){
				console.log(wx)
			}
		}
	}
</script>
