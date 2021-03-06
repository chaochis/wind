const Layout = () => import('@/pages/CommonPage/Layout/Layout.vue');
const Home = () => import('@/pages/BusPage/Home/Home.vue');
const R404 = () => import('@/pages/CommonPage/R404/R404.vue');
const Login = () => import('@/pages/LoginPage/Login/LoginRegisterCommon.vue');

export default {
  Layout, Home, R404, Login,
};
