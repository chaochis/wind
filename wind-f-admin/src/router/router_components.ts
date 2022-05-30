const LayoutView = () => import('../views/Layout/Layout.vue')
const WxUserPage = () => import('../views/MainMenu/UserMenu/WxUser/WxUserList.vue')
const HomePage = () => import('../views/MainMenu/HomePage/HomePage.vue')
const LoginPage = () => import('../views/Login/Login.vue')
const NotFoundPage404 = () => import('../views/Page404/Page404.vue')
enum routeNameEnum {
  wxUserPage = 'WxUserPage',
  homePage = 'HomePage',
  layout = 'LayoutPage',
  login = 'LoginPage',
  page404 = 'Page404'
}
export {
  LayoutView,
  WxUserPage,
  HomePage,
  LoginPage,
  NotFoundPage404,
  routeNameEnum
}
