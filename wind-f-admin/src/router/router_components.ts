const LayoutView = () => import('../views/Layout/Layout.vue')
const WxUserPage = () => import('../views/MainMenu/UserMenu/WxUser/WxUserList.vue')
const HomePage = () => import('../views/MainMenu/HomePage/HomePage.vue')
enum routeNameEnum {
  wxUserPage = 'WxUserPage',
  homePage = 'HomePage'
}
export {
  LayoutView,
  WxUserPage,
  HomePage,
  routeNameEnum
}
