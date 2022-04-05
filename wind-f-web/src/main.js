import { createApp } from 'vue';
import axios from 'axios';
import App from './App.vue';
import { router } from './router/router';
import '@/assets/style/all_style.scss';
import CCComponents from './components/CCComponents';

const app = createApp(App);
app.use(router);
app.mount('#app');
app.use(CCComponents);

app.config.globalProperties.$axios = axios;

// 默认情况下，Vue 会移除/压缩模板元素之间的空格以产生更高效的编译结果：
// 元素内的多个开头/结尾空格会被压缩成一个空格
// 元素之间的包括折行在内的多个空格会被移除
// 文本结点之间可被压缩的空格都会被压缩成为一个空格
// 以下设置禁用2跟3
// app.config.compilerOptions.whitespace = 'preserve';

// 将分隔符设置为 ES6 模板字符串风格
// 这个设置在脚手架下只有Runtime的环境下不生效
// app.config.compilerOptions.delimiters = ['${', '}'];
