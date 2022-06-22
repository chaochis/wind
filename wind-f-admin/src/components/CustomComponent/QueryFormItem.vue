<template>
  <div class='wind-query-item'>
    {{label}}
    <label class='wind-query-item-label' :style='labelWidth'>{{label}}</label>
    <slot class='wind-query-item-content' name='default'></slot>
  </div>
</template>
<script lang='ts' setup>
import { computed, defineProps,toRefs } from 'vue';
let label;
let labelWidth = 120;
console.log(toRefs(defineProps))
const _labelWidth = computed(() => {
  if (typeof labelWidth === 'string') {
    return labelWidth
  } else {
    return `${labelWidth}px`
  }
})
</script>
<script lang='ts'>
export default {
  name: 'QueryFormItem'
};
</script>

<style lang='scss' scoped>
.wind-query-item{
  display: inline-block;

}
</style>
