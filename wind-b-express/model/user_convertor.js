const {userStatus, userType, userSex } = require("../config/enum");
const modelConvertor = require("./common_model_convertor");

/**
 * 用户类与数据库用户的转换
 * @type {[{voName: string, dataName: string, enumType: string | number}]}
 *        voName: 数据库的字段名 dataName: 后端对象名称 enumType: 枚举项
 */
const wind_user_map = [
  { dataName: 'user_id', voName: 'userId'},
  { dataName: 'user_email', voName: 'userEmail'},
  { dataName: 'user_mobile', voName: 'user_mobile'},
  { dataName: 'user_password', voName: 'userPassword'},
  { dataName: 'user_password_salt', voName: 'userPasswordSalt'},
  { dataName: 'user_level', voName: 'userLevel'},
  { dataName: 'user_status', voName: 'userStatus', transferType: { type: 'enum', enumType: userStatus }},
  { dataName: 'user_type', voName: 'userType', transferType: { type: 'enum', enumType: userType }},
  { dataName: 'dept_id', voName: 'deptId' },
  { dataName: 'user_nick_name', voName: 'userNickName' },
  { dataName: 'user_sex', voName: 'userSex', transferType: {type: 'enum', enumType: userSex }}
]

module.exports = {
  windUserConvertor: modelConvertor(wind_user_map)
};
