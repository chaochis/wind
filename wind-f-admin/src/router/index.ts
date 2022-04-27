import { createRouter, createWebHistory, RouteRecordRaw } from 'vue-router'
import { HomePage, LayoutView, routeNameEnum, WxUserPage } from '@/router/router_components';


const routes: Array<RouteRecordRaw> = [
  {
    path: '/',
    component: LayoutView,
    redirect: { name: routeNameEnum.homePage },
    children: [
      {
        path: '/home-page',
        component: HomePage,
        name: routeNameEnum.homePage,
      }
    ]
  },
  {
    path: '/user-menu',
    component: LayoutView,
    redirect: { name: routeNameEnum.wxUserPage },
    children: [
      {
        path: '/user-menu/wx-user',
        name: routeNameEnum.wxUserPage,
        component: WxUserPage
      }
    ]
  }
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
