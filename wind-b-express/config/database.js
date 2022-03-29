let mysql = require("mysql2")
let mysqlConfig={
  host: 'localhost',
  port: 3308,
  database : 'wind',
  user: 'root',
  password: 'Sh.7947..',
  connectionLimit : 10
}
let pool  = mysql.createPool(mysqlConfig);

/**
 * @author chaochis
 * @returns {Promise<unknown>} 返回一个mysql连接
 */
function getConnection() {
  return new Promise((resolve, reject) => {
    pool.getConnection((err, connection) => {
      if (err) {
        reject(err);
      } else {
        resolve(connection)
      }
    })
  })
}

/**
 * @author chaochis
 * @param sql 要执行的sql语句
 * @param params 写入的参数
 * @returns {Promise<unknown>}
 */
function commonQuery(sql, params) {
  /*connection.query(sql, params, (err, results) => {
    if (err) {
      reject(err)
    } else {
      resolve(results)
    }
  })*/
  return new Promise((resolve, reject) => {
    getConnection().then(connection => {
      connection.query(sql, params, (err, results) => {
        if (err) {
          reject(err)
        } else {
          resolve(results)
        }
      })
    }).catch(err => reject(err))
  })
}

/**
 * @author chaochis
 * @param sql
 * @param params
 * @returns {Promise<unknown>}
 */
function commonTransactionQuery(sql, params) {
  return new Promise((resolve, reject) => {
    getConnection().then(connection => {
      connection.beginTransaction(errBegin => {
        if (errBegin) {
          reject(errBegin)
        } else {
          connection.query(sql, params, (errQuery, results) => {
            if (errQuery) {
              connection.rollback(() => reject(errQuery))
            } else {
              connection.commit(errCommit => {
                if (errCommit) {
                  connection.rollback(() => reject(errCommit))
                } else {
                  resolve(results)
                }
              })
            }
          })
        }
      })
    }).catch(err => reject(err))
  })
}
module.exports = {
  getConnection,
  commonQuery,
  commonTransactionQuery
};