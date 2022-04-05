const {getWxUserById} = require("../dao/wind_user_dao");

class UserService{
  async getUserById(id){
    return await getWxUserById(id)
  }
}

const userService = new UserService()
module.exports = userService