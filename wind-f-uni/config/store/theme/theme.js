const user = {
  state: {
    _themeColor: "#409EFF",
  },
	getters:{
		themeColor: state => state._themeColor,
	}
}

export default user
