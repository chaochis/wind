import Vue from 'vue'
import Vuex from 'vuex'
import user from './user/user.js'
import theme from './theme/theme.js'
Vue.use(Vuex)

const store = new Vuex.Store({
	modules: {
		user,
		theme
	}
})

export default store