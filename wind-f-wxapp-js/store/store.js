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
  constructor() {
    if (__instance()) return __instance()
    __instance(this)
  }
}
let store  = new Store()
export default{ store}