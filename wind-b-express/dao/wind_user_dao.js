const {commonQuery} = require("../config/mysql");
const userSql = {
  select: 'select user_name,user_email, user_mobile,user_level from wind_user where user_id = ?',
}
function getWxUserById(id) {
  return commonQuery(userSql.select, [id])
}

module.exports = {
  getWxUserById
};