<template>
  <div v-bind='$attrs'>
    <slot name='default'></slot>
  </div>
</template>

<script>
export default {
  name: 'CCLink',
};
</script>

<style scoped>

</style>
