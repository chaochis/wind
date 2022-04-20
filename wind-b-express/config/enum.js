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

let userSex = Object.freeze({
  0: 'Secret',
  1: 'Man',
  2: 'WoMan',
  'Secret': 0,
  'Man': 1,
  'WoMan': 2,
})

module.exports = {
  userStatus,userType,apiCode,userSex
}
