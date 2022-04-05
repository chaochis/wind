import { defineAsyncComponent } from 'vue';
import LoadingComponent from '@/pages/PageLoading/LoadingComponent/Loading.vue';
import ErrorComponent from '@/pages/PageLoading/LoadingErrorComponent/Error.vue'

function ccLoadAsyncComponent(component) {
  return defineAsyncComponent({
    loader: component,
    loadingComponent: () => LoadingComponent, /* 在加载时显示 */
    errorComponent: () => ErrorComponent, /* 显示是否有错误 */
    delay: 10000, /* 在显示加载组件之前延迟毫秒 */
    timeout: 3000 /* 这个毫秒之后的超时 */
  })
}


export {
  ccLoadAsyncComponent
}