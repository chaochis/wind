import { createApp } from 'vue'
import App from './App.vue'
import ElementPlus from 'element-plus'
import 'element-plus/dist/index.css'
import router from './router'
import store, { storeKey } from './config/store_config';
import '@/assets/style/all_style.scss'
const app = createApp(App)
app.use(ElementPlus)
app.use(store, storeKey)
app.use(router)
app.mount('#app')
