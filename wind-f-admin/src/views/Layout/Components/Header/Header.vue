<template>
  <div class='wind-header-container'>
    <div class='wind-header-right-menu'>
    </div>
  </div>
</template>

<script>
export default {
  name: 'HeaderComponent'
};
</script>

<style lang='scss' scoped>
.wind-header-container{
  width: 100%;
  height: 100%;
  position: relative;
  background: #FFFFFF;
  .wind-header-right-menu {
    position: absolute;
    right: 0;
    top: 0;
    height: 100%;
    width: 100%;
    display: flex;
    flex-direction: row;
    justify-content: right;
    align-items: center;
  }
}
</style>
