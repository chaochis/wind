import { LayoutView, routeNameEnum, WxUserPage } from '@/router/router_components';
import { RouteRecordRaw } from 'vue-router';

export const userRoute: RouteRecordRaw =
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
