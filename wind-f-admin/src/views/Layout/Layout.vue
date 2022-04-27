<template>
  <header>{{name}}</header>
  <router-view></router-view>
</template>

<script lang='ts'>
import { defineComponent } from 'vue';

export default defineComponent({
  name: 'LayoutPage',
  data () {
    return {
      name: 1
    }
  }
})
</script>

<style scoped>
@import "Layout.scss";
</style>
