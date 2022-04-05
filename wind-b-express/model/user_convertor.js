const {userStatus, userType} = require("../config/enum");
const modelConvertor = require("./common_model_convertor");

const wind_user_map = [
  { dataName: 'user_id', voName: 'userId'},
  { dataName: 'user_name', voName: 'userName'},
  { dataName: 'user_email', voName: 'userEmail'},
  { dataName: 'user_mobile', voName: 'user_mobile'},
  { dataName: 'user_password', voName: 'userPassword'},
  { dataName: 'user_password_salt', voName: 'userPasswordSalt'},
  { dataName: 'user_level', voName: 'userLevel'},
  { dataName: 'user_status', voName: 'userStatus', enumType: userStatus },
  { dataName: 'user_type', voName: 'userType', enumType: userType }
]

module.exports = {
  windUserConvertor: modelConvertor(wind_user_map)
};