<template>
  <el-scrollbar class='wind-sidebar-container'>
    <div class='wind-sidebar-logo-area'>
      <el-image style='width: 120px;height: 40px' :src='logo'></el-image>
    </div>
  </el-scrollbar>
</template>

<script setup lang='ts'>
import { reactive } from 'vue';

let logo = reactive(require("@/assets/imgs/wind-logo.svg"));
</script>
<script lang='ts'>
export default {
  name: 'SideBar'
};
</script>

<style lang='scss' scoped>
@import "SideBar";
.wind-sidebar-logo-area{
  padding: 2px 0;
  text-align: center;
}
</style>
