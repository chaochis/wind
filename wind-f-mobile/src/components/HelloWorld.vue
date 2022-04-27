<template>
  <div class='container'>auo-scale</div>
</template>
<script setup lang="ts">
import { ref } from 'vue'

defineProps<{ msg: string }>()

const count = ref(0)
</script>
<style scoped>
.container{
  display: grid;
  place-items: center;
  height: 100vh;
  background: #0099ff;
}
@media screen and (min-width: 800px){
  .container{
    background: #0af;
  }
}
@media screen and (min-width: 1280px){
  .container{
    background: #0ff;
  }
}
</style>
