import { createRouter, createWebHistory } from 'vue-router';
import ccComponents from './route_components';

const routeNameEnum = Object.freeze({
  Home: 'Home',
  Layout: 'Layout',
  R404: 'R404',
  Login: 'Login',
  Register: 'Register',
});
const routes = [
  {
    path: '/',
    component: ccComponents.Layout,
    name: routeNameEnum.Layout,
    redirect: { name: routeNameEnum.Home },
    children: [
      {
        path: '/', component: ccComponents.Home, name: routeNameEnum.Home, meta: { title: '首页' },
      },
    ],
  },
  {
    path: '/r404',
    component: ccComponents.R404,
    name: routeNameEnum.R404,
  },
  {
    path: '/login',
    component: ccComponents.Login,
    name: routeNameEnum.Login,
  },
  {
    path: '/register',
    component: ccComponents.Register,
    name: routeNameEnum.Register,
  },
  {
    path: '/:pathMatch(.*)',
    redirect: { name: routeNameEnum.R404 },
  },
];

const router = createRouter({
  history: createWebHistory(),
  routes,
});

export {
  router, routeNameEnum,
};
