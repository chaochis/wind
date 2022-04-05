<template>
  <div class='cc-input-item'>
    <input class='cc-input-content' @input='onInput' v-model='inValue' type="text" required>
    <label class='cc-input-label'>用户名</label>
  </div>
</template>

<script setup>
import {
  defineEmits, defineProps, nextTick, onMounted, ref, watch,
} from 'vue';

const inValue = ref(null);
const props = defineProps({
  value: {
    type: [String, Number, null, undefined],
    default: null,
  },
});
const emit = defineEmits(['input', 'focus', 'change']);
const onInput = () => {
  emit('input', inValue.value);
};
onMounted(async () => {
  await nextTick();
  inValue.value = props.value;
});
watch(() => props.value, () => { inValue.value = props.value; });
</script>

<script>
export default {
  name: 'CCInput',
};
</script>

<style lang='scss' scoped>
.cc-input-item{
  position: relative;
  .cc-input-content{
    width: 100%;
    height: 35px;
    border: none;
    border-bottom: 1px solid #bbb;
    text-indent: 5px;
    outline: none;
    transition: 0.3s;
    &:focus, &:valid{
      border-color: $theme-color;
      box-shadow: 0 1px $theme-color;
      & ~ .cc-input-label{
        color: $theme-color;
        font-size: 12px;
        transform: translateY(-15px);
      }
    }
  }
  .cc-input-label{
    position: absolute;
    left: 5px;
    top: 5px;
    font-size: 14px;
    color: #888;
    transition: 0.3s;
    pointer-events: none;
  }
}
</style>
