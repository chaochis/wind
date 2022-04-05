<template>
  <a class='cc-link' v-bind='$attrs'>
    <slot name='default'></slot>
  </a>
</template>

<script>
export default {
  name: 'CCLink',
};
</script>

<style lang='scss' scoped>
.cc-link{
  color: $theme-color;
  font-size: 12px;
  cursor: pointer;
  &:hover{
    border-bottom: solid 1px $theme-color;
  }
}
</style>
