import { createRouter, createWebHistory, RouteRecordRaw } from 'vue-router'
import { constantRoutes } from '@/router/constant_routes/constant_routes';
import { asyncRoutes } from '@/router/async_routes/async_routes';


const allRouter:Array<RouteRecordRaw> = [
  ...constantRoutes,
  ...asyncRoutes
]

const router = createRouter({
  history: createWebHistory(),
  routes: allRouter
})

export default router

