/**
 * 将undefined,null,Nan等值转换为null值
 * @param obj 要转换的对象
 * @returns {null|*} 返回的值
 */
function modelTransfer(obj) {
  if (typeof obj === undefined || typeof obj === null || Number.isNaN(obj)) {
    return null
  } else {
    return obj
  }
}

module.exports = modelTransfer;