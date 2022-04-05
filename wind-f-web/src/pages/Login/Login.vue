<template>
  <div class="cc-container">
    <div class="cc-panda">
      <div class="cc-panda-ear left"></div>
      <div class="cc-panda-ear right"></div>
      <div class="cc-panda-face">
        <div class="cc-panda-eye-shadow left"></div>
        <div class="cc-panda-eye-white left">
          <div class="cc-panda-eye-ball"></div>
        </div>
        <div class="cc-panda-eye-shadow right"></div>
        <div class="cc-panda-eye-white right">
          <div class="cc-panda-eye-ball"></div>
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
    <div class='cc-login-box'>
      <div class="cc-panda-hand left"></div>
      <div class="cc-panda-hand right"></div>
      <h1>用户登录</h1>
      <CCInput class="cc-input-area" :label='"用户名"' v-model:value='loginUser.userName'></CCInput>
      <CCInput class="cc-input-area"
               :type='"password"'
               :label='"密码"'
               :maxlength='maxLength'
               v-model:value='loginUser.userPassword'>
      </CCInput>
      <div class='cc-button-area'>
        <CCButton @click='showValue' class='mr-5'>登录</CCButton>
        <CCButton>注册</CCButton>
      </div>
      <div class='cc-forget-area'>忘记密码</div>
    </div>
  </div>
</template>

<script setup>
// eslint-disable-next-line no-unused-vars
import { onMounted, reactive, ref } from 'vue';

const maxLength = ref(16);
const loginUser = reactive({
  userName: 22, userPassword: null,
});
const showValue = () => {
  console.log(loginUser);
};
</script>
<script>
export default {
  name: 'PageLogin',
  mounted() {
  },
};
</script>

<style lang="scss" scoped>
@import "./Login";
</style>
