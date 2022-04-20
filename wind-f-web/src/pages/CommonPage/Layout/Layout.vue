<template>
  <div class='cc-container wind-app'>
<!--    <WindBackgroundMain></WindBackgroundMain>
    <header class='wind-banner' id='banner'>
      <div class='wind-left'>
        <WindLogo :title='windTitle' :name='windName'></WindLogo>
      </div>
      <div class='wind-right'>
        登录
      </div>
    </header> -->
    <div class='wind-content'>
      <router-view></router-view>
    </div>
  </div>
</template>

<script setup>
import { ref } from 'vue';
import WindBackgroundMain from '../../../components/WindBackground/WindBackgroundMain.vue';
import WindLogo from './Components/WindLogo/WindLogo.vue';

const windTitle = ref('Wind');
const windName = ref('风旅博客');
</script>
<script>
export default {
  name: 'PageLayout',
};
</script>
<style lang='scss' src='./Layout.scss' scoped></style>
