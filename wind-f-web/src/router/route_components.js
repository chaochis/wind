const Layout = () => import('@/pages/CommonPage/Layout/Layout.vue');
const Home = () => import('@/pages/BusPage/Home/Home.vue');
const R404 = () => import('@/pages/CommonPage/R404/R404.vue');
const Register = () => import('@/pages/LoginPage/Register/Register.vue');
const Login = () => import('@/pages/LoginPage/Login/Login.vue');

export default {
  Layout, Home, R404, Register, Login,
};
