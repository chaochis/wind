<template>
  <div class='cc-container-center wind-r404-container'>
    <div class='wind-404-area'>
      <div class='wind-404'>此页未找到</div>
    </div>
  </div>
</template>

<script>
export default {
  name: 'PageR404',
};
</script>

<style lang='scss' scoped>
$shadow-color: blue;

@keyframes animate {
  to{
    filter: hue-rotate(360deg)  opacity(100%);
  }
}

.wind-r404-container{
  font-weight: bolder;
  background-color: #06252e;
  .wind-404-area{
    -webkit-box-reflect: below 10px linear-gradient(transparent,rgba(0,0,0,0.2));
    display: inline-block;
    .wind-404{
      color: #fff;
      font-size: 96px;
      letter-spacing: 15px;
      text-align: center;
      line-height: 96px;
      height: 96px;
      outline: none;
      text-shadow: 0 0 10px $shadow-color,
      0 0 20px $shadow-color,
      0 0 40px $shadow-color,
      0 0 80px $shadow-color,
      0 0 160px $shadow-color;
      animation: animate 5s linear infinite;
    }
  }

}
</style>
