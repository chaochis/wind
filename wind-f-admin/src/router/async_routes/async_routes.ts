import { RouteRecordRaw } from 'vue-router';
import { userRoute } from '@/router/async_routes/user_routes/user_route';

export const asyncRoutes: Array<RouteRecordRaw> = [
  userRoute,
]
