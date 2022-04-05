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
.cc-button{
  width: 80px;
  height: 40px;
  background-color: $theme-color;
  border: none;
  border-radius: 8px;
  margin-top: 30px;
  color: #fff;
  letter-spacing: 5px;
  text-indent: 5px;
  cursor: pointer;
  transition: 0.3s;
  &:hover{
    letter-spacing: 10px;
    text-indent: 10px;
    background-color: $theme-sub-color;
  }
}
.cc-button-disabled{
  color: #333333;
}
</style>
