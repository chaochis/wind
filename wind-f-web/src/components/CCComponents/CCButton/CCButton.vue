<template>
  <button @click='onClick' :class='[isDisabledClass]'>
    <slot name='default'></slot>
  </button>
</template>
<script setup>
import {
  computed,
  defineEmits, defineProps,
} from 'vue';

const props = defineProps({
  disabled: {
    type: [Boolean, null],
    default: false,
  },
});
const isDisabledClass = computed(() => (props.disabled ? 'cc-button-disabled' : 'cc-button'));
const emit = defineEmits(['click']);
const onClick = (e) => {
  emit('click', e);
};
</script>
<script>
export default {
  name: 'CCButton',
};
</script>

<style lang='scss' scoped>
@mixin cc-button-base{
  letter-spacing: 5px;
  text-indent: 5px;
  cursor: pointer;
  transition: 0.3s;
}
.cc-button{
  @include cc-button-base;
  width: 80px;
  height: 40px;
  border: none;
  border-radius: 8px;
  margin-top: 30px;
  color: #fff;
  background-color: $theme-color;

  &:hover{
    letter-spacing: 10px;
    text-indent: 10px;
    background-color: $theme-sub-color;
  }
}
.cc-button-disabled{
  @include cc-button-base;

  width: 80px;
  height: 40px;
  border: none;
  border-radius: 8px;
  margin-top: 30px;
  color: #fff;
  background: #333333;
  &:hover{
    letter-spacing: 5px;
    text-indent: 5px;
    background-color: #333333;
  }
}
</style>
