import store from "../store"
import localApis from "../apis/local_apis.js"
function checkLogin() {
	if (!store.getters.token) {
		return localApis.routerPush('/pages/login/login')
	}
}
export default {
	checkLogin
}
