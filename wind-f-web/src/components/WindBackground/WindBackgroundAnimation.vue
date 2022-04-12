<template>
  <div class='cc-container-fullscreen wind-background'>
    <div class='square'>
      <ul>
        <li v-for='item in squares' :key='item.key' :style='item.style'></li>
      </ul>
    </div>
    <div class='circle'>
      <ul>
        <li v-for='item in circles' :key='item.key' :style='item.style'></li>
      </ul>
    </div>
  </div>
</template>
<script setup>
import { defineProps, onMounted, reactive } from 'vue';
import random from '../../util/random';

const props = defineProps({
  squareNumber: {
    type: [Number, null],
    default: 5,
  },
  circleNumber: {
    type: [Number, null],
    default: 5,
  },
});
const squares = reactive([]);
const circles = reactive([]);
onMounted(() => {
  for (let i = 0; i < props.squareNumber; i += 1) {
    const randomX = (100 / props.squareNumber) * i;
    const randomY = random.randomNumber((100 / props.squareNumber) * (i + 1), (100 / props.squareNumber) * (i + 2));
    const style = {
      bottom: `${randomY}%`,
      left: `${randomX}%`,
      'animation-delay': `${2 * i}s`,
    };
    squares.push({ key: `squares${i}`, style });
  }
  for (let i = 0; i < props.circleNumber; i += 1) {
    const randomX = (100 / props.circleNumber) * i;
    const style = {
      left: `${randomX}%`,
      'animation-delay': `${2 * i}s`,
    };
    circles.push({ key: `circles${i}`, style });
  }
});
</script>
<script>
// 会滚动的背景底板
export default {
  name: 'WindBackgroundAnimation',
};
</script>

<style scoped>
@keyframes square {
  0% {
    transform: scale(0) rotateY(0deg);
    opacity: 1;
  }
  100% {
    transform: scale(5) rotateY(1000deg);
    opacity: 0;
  }
}

@keyframes circle {
  0% {
    transform: scale(0) rotateY(0deg);
    opacity: 1;
    bottom: 0;
    border-radius: 0;
  }
  100% {
    transform: scale(5) rotateY(1000deg);
    opacity: 0;
    bottom: 90vh;
    border-radius: 50%;
  }
}

ul li {
  position: absolute;
  border: 1px solid #fff;
  background-color: #fff;
  width: 30px;
  height: 30px;
  list-style: none;
  opacity: 0;
}

.wind-background {
  position: absolute;
  z-index: -333;
  /*background: linear-gradient(200deg, $theme-color, $theme-sub-color);*/
  background: #66b1ff;
}

.square ul li {
  animation: square 10s linear infinite;
}

.circle ul li {
  animation: circle 10s linear infinite;
}
</style>
