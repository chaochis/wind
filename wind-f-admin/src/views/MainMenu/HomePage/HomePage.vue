<template>
  <div>首页</div>
</template>

<script lang='ts'>
import { defineComponent } from 'vue';
import { routeNameEnum } from '@/router/router_components';

export default defineComponent({
  mounted() {
    this.$router.push({ name: routeNameEnum.wxUserPage });
  }
})
</script>

<style scoped>

</style>
