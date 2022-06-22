import { Module } from 'vuex';
import { RootStateType } from '@/config/store_config';

export interface UserState {
  get _token (): string | null ;
  set _token(val: string | null);
}
export const user: Module<UserState, RootStateType> = {
  namespaced: false,
  state: {
    get _token (): string | null {
      return localStorage.getItem('token')
    },
    set _token(val: string | null) {
      if (typeof val === 'string') {
        localStorage.setItem('token', val);
      }
    }
  },
  getters: {
    token: (state) => state._token,
  },
  mutations: {
  },
  actions: {
  },
}
