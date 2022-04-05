const Layout = () => import('@/pages/Layout/Layout.vue');
const Home = () => import('@/pages/Home/Home.vue');
const R404 = () => import('@/pages/R404/R404.vue');
const Register = () => import('@/pages/Register/Register.vue');
const Login = () => import('@/pages/Login/Login.vue');

export default {
  Layout, Home, R404, Register, Login,
};
