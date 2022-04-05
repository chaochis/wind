let userType = Object.freeze({
  0: 'WindUser',
  1: 'WxUser',
  'WindUser': 0,
  'WxUser': 1
})

let apiCode = Object.freeze({
  200: 'Success',
  100: 'Fail',
  'Success': 200,
  'Fail': 100
})

let userStatus = Object.freeze({
  0: 'Inactivated',
  1: 'Normal',
  2: 'Deleted',
  'Inactivated': 0,
  'Normal': 1,
  'Deleted': 2
})

module.exports = {
  userStatus,userType,apiCode
}