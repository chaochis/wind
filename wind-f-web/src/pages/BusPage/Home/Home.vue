<template>
  <div>
    <button @click='useVideo'>摄像头扫描</button>
    <video id="video" ></video>
  </div>
</template>

<script setup>
import { reactive } from 'vue';

const video = reactive({});
</script>
<script>
export default {
  name: 'PageHome',
  methods: {
    useVideo() {
      const self = this;
      this.video = document.getElementById('video');
      const getUserMedia = (navigator.mediaDevices && navigator.mediaDevices.getUserMedia) || navigator.getUserMedia || navigator.webkitGetUserMedia || navigator.mozGetUserMedia || navigator.msGetUserMedia || window.getUserMedia;
      if (getUserMedia) {
        const success = (stream) => {
          // 兼容webkit核心浏览器
          const CompatibleURL = window.URL || window.webkitURL;
          // 将视频流设置为video元素的源
          console.log(stream);

          // video.src = CompatibleURL.createObjectURL(stream);
          // 将摄像头拍摄的视频赋值给viedeo的srcObject属性
          // src是视频文件,srcObject是实时流
          // 摄像头是实时流
          this.video.srcObject = stream;
          // 并播放
          this.video.play();
        };
        const error = () => { self.$alert('访问媒体设备失败!'); };
        const constraints = { video: { width: 270, height: 150 } };
        if (navigator.mediaDevices && navigator.mediaDevices.getUserMedia) {
          // 最新的标准API
          navigator.mediaDevices.getUserMedia(constraints).then(success).catch(error);
        } else if (navigator.webkitGetUserMedia) {
          // webkit核心浏览器
          navigator.webkitGetUserMedia(constraints, success, error);
        } else if (navigator.mozGetUserMedia) {
          // firfox浏览器
          navigator.mozGetUserMedia(constraints, success, error);
        } else if (navigator.getUserMedia) {
          // 旧版API
          navigator.getUserMedia(constraints, success, error);
        }
      } else {
        self.$alert('您的设备不支持访问摄像头');
      }
    },
  },
};
</script>
<style scoped>

</style>
