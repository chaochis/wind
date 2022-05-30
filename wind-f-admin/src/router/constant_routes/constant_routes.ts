import { RouteRecordRaw } from 'vue-router';
import {
  HomePage,
  LayoutView,
  LoginPage,
  NotFoundPage404,
  routeNameEnum,
  WxUserPage
} from '@/router/router_components';

// 静态路由，也即公共路由模块
export const constantRoutes: Array<RouteRecordRaw> = [
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
    path: '/login',
    component: LoginPage,
    name: routeNameEnum.login
  },
  {
    path: '/404',
    component: NotFoundPage404,
    name: routeNameEnum.page404
  },
  {
    path: '/:pathMatch(.*)',
    redirect: { name: routeNameEnum.page404 },
  }
]
