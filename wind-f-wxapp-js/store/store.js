import wxApis from "../apis/wxApis"

let __instance = (() => {
  let instance = null
  return newInstance => {
    if(newInstance) instance = newInstance
    return instance
  }
})()
/**
 * 单例状态类
 */
class Store{
  #token = null;
  constructor() {
    if (__instance()) return __instance()
    __instance(this)
  }
  setToken(token) {
    this.#token = token
    wxApis.saveStorage({key: 'token', data: token}, false)
  }
  getToken() {
    return this.#token || wxApis.getStorage('token', false)
  }
}
let store  = new Store()
export default { store }