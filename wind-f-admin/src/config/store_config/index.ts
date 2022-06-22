import { createStore, Store, useStore } from 'vuex';
import { user, UserState } from '@/config/store_config/modules/user';
import { InjectionKey } from 'vue';

export interface RootStateType {
  user: UserState;
}
export const storeKey: InjectionKey<Store<RootStateType>> = Symbol('vue-store')
export default createStore({
  modules: {
    user
  }
})

export function useStoreWithType() {
  return useStore(storeKey)
}

