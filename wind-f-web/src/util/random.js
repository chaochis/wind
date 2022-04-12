/**
 * 产生随机整数（不包括上限数字）
 * @param lower 下限数字
 * @param upper 上限数字
 * @returns {*} 返回在下限到上限之间的一个整数
 */
function randomNumber(lower, upper) {
  return Math.floor(Math.random() * (upper - lower)) + lower;
}

export default {
  randomNumber,
};
