let __instance = (() => {
  let instance = null
  return newInstance => {
    if(newInstance) instance = newInstance
    return instance
  }
})()
class Store{
  constructor() {
    if (__instance()) return __instance()
    __instance(this)
  }
}
export default{
  store: new Store()
}