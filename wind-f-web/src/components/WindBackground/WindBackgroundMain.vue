<template>
  <teleport to='#app'>
    <div class='cc-container wind-background'>

    </div>
  </teleport>
</template>

<script>
export default {
  name: 'WindBackgroundMain',
};
</script>

<style scoped>
.wind-background{
  position: absolute;
  background: #e3e3e3;
  z-index: -333;
}
</style>
