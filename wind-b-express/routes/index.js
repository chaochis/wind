const userRouter = require('../controller/user_controller');
const cors = require('cors')

// 设置路由以及cors配置
module.exports = function(app) {
  app.use(cors({credentials: true, origin: ['*'],headers:'X-Requested-With,Content-Type,username',methods:'PUT,POST,GET,DELETE,OPTIONS'}));
  app.use('/user', userRouter)
}