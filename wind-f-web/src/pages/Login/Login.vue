<template>
  <div class="cc-container">
    <div class="cc-panda">
      <div class="cc-panda-ear left"></div>
      <div class="cc-panda-ear right"></div>
      <div class="cc-panda-face">
        <div class="cc-panda-eye-shadow left"></div>
        <div class="cc-panda-eye-white left">
          <div class="cc-panda-eye-ball" :style='eyeMovedDistance'></div>
        </div>
        <div class="cc-panda-eye-shadow right"></div>
        <div class="cc-panda-eye-white right">
          <div class="cc-panda-eye-ball" :style='eyeMovedDistance'></div>
        </div>
        <div class="cc-panda-nose"></div>
        <div class="cc-panda-mouse"></div>
      </div>
      <div class="cc-panda-body"></div>
      <div class="cc-panda-foot left">
        <div class="sole"></div>
      </div>
      <div class="cc-panda-foot right">
        <div class="sole"></div>
      </div>
    </div>
    <div :class='["cc-login-box", pandaUp ? "up" : ""]'>
      <div class="cc-panda-hand left"></div>
      <div class="cc-panda-hand right"></div>
      <h1>用户登录</h1>
      <CCInput class="cc-input-area" :label='"用户名"' v-model:value='loginUser.userName'></CCInput>
      <CCInput class="cc-input-area"
               @blur='pandaUp = false'
               @focus='pandaUp = true'
               :type='"password"'
               :label='"密码"'
               :maxlength='maxLength'
               v-model:value='loginUser.userPassword'>
      </CCInput>
      <div class='cc-button-area'>
        <CCButton @click='showValue' class='mr-5'>登录</CCButton>
        <CCButton>注册</CCButton>
      </div>
      <div class='cc-forget-area'>
        <CCLink>忘记密码</CCLink>
      </div>
    </div>
  </div>
</template>

<script setup>
// eslint-disable-next-line no-unused-vars
import {
  onMounted, onUnmounted, reactive, ref, nextTick,
} from 'vue';
import trigger from '@/util/trigger';

const maxLength = ref(16);
const pandaUp = ref(false);
const eyeMovedDistance = reactive({
  left: '5px', top: '5px',
});
const loginUser = reactive({
  userName: null, userPassword: null,
});
const eyeMove = (e) => {
  trigger.throttle(async () => {
    await nextTick();
    const dw = document.documentElement.clientWidth / 10;
    const dh = document.documentElement.clientHeight / 18;
    const x = e.pageX / dw;
    const y = e.pageY / dh;
    eyeMovedDistance.left = `${x}px`;
    eyeMovedDistance.top = `${y}px`;
  }, 50)();
};
onMounted(() => {
  document.addEventListener('mousemove', eyeMove, false);
});
onUnmounted(() => {
  document.removeEventListener('mousemove', eyeMove, false);
});
const showValue = () => {
  console.log(loginUser);
};
</script>
<script>
export default {
  name: 'PageLogin',
};
</script>

<style lang="scss" scoped>
@import "./Login";
</style>
