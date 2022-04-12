<template>
  <div class='wind-logo-container'>
    <div class="wind-logo-area">
      <div class="wind-logo-title">{{title}}</div>
      <div class="wind-logo-title">{{title}}</div>
      <div class='wind-logo-name'>{{name}}</div>
    </div>
  </div>
</template>

<script setup>
import { defineProps } from 'vue';

defineProps({
  title: {
    type: String,
    default: '',
  },
  name: {
    type: String,
    default: '',
  },
});
</script>
<script>
export default {
  name: 'WindLogo',
};
</script>

<style lang='scss' scoped>
.wind-logo-container{
  height: 76px;
  display: block;
  width: 120px;
}
.wind-logo-area{
  height: 100%;
  width: 100%;
  position: relative;
  &:hover {
    .wind-logo-title:nth-child(1) {
      top: 30%;
      opacity: 0.3;
    }
    .wind-logo-title:nth-child(2) {
      top: 70%;
      opacity: 0.3;
    }
    .wind-logo-name{
      opacity: 1;
      transition: opacity 0.5s;
    }
  }
  .wind-logo-title{
    color: $theme-color;
    font-weight: bold;
    font-size: 40px;
    top: 50%;
    left: 50%;
    transform: translate(-50%,-50%);
    opacity: 1;
    transition: top 0.5s,opacity 0.5s;
    position: absolute;
    &:nth-child(1){
      clip-path: polygon(0% 0%,100% 0%,100% 51%,0% 51%);
    }
    &:nth-child(2){
      clip-path: polygon(0% 50%,100% 50%,100% 100%,0% 100%);
    }
  }
  .wind-logo-name{
    position: absolute;
    top: 50%;
    left: 50%;
    transform: translate(-50%,-50%);
    color: $theme-sub-color;
    text-decoration: none;
    opacity: 0;
    font-size: 15px;
    transition: opacity 0.5s;
  }
}
</style>
