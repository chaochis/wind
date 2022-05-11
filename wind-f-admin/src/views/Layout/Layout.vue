<template>
  <div class='wind-layout'>
    <div class='wind-side-bar'>

    </div>
    <div class='wind-content-area'>
      <div class='wind-header'>
        <HeaderComponent></HeaderComponent>
      </div>
      <div class='wind-main-container'>
        <AppMain></AppMain>
      </div>
    </div>
  </div>
</template>
<script lang='ts' setup>
import HeaderComponent from '@/views/Layout/Components/Header/Header.vue';
import AppMain from '@/views/Layout/Components/AppMain/AppMain.vue';
</script>
<script lang='ts'>
import { defineComponent } from 'vue';

export default defineComponent({
  name: 'LayoutPage',
})
</script>
<style lang='scss' scoped>
.wind-layout{
  height: 100%;
  width: 100%;
  background: #f7f7f7;
  display: flex;
  overflow: hidden;
  .wind-side-bar{
    width: 120px;
    height: 100%;
  }
  .wind-content-area{
    width: calc(100% - 120px);
    height: 100%;
    .wind-header{
      width: calc(100%);
      height: 74px;
      box-shadow: 0 0 12px 43 rgba(0,0,0, 0.12);
    }
    .wind-main-container{
      width: calc(100%);
      height: calc(100% - 74px);
      overflow: hidden;
    }
  }
}
</style>
