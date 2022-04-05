const redis = require("redis")
const redisConf={
  port: process.env.REDIS_PORT,
  host: process.env.REDIS_IP
}
const client = redis.createClient({
  socket: {
    host: redisConf.host,
    port: redisConf.port
  }
});
function redisGetKey(key) {

}
module.exports = {
  redisGetKey
};