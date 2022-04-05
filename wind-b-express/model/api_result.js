const {apiCode} = require("../config/enum");
let apiResult = new function() {
  let buildApiResult = (result, code, message) => {
    return {result, apiCode: code, message}
  }
  this.success = function (result) {
    return buildApiResult(result, apiCode.Success, null)
  }
  this.fail = function (err) {
    return buildApiResult(null, apiCode.Fail, err)
  }
}

module.exports = apiResult;