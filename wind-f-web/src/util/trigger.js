/**
 * 防抖函数
 * @param fun 要执行的函数
 * @param delay 生效时间
 */
function debounce(fun, delay) {
  let timer = null;
  return () => {
    if (timer) {
      clearTimeout(timer);
    }
    timer = setTimeout(fun, delay);
  };
}

// 节流函数
function throttle(fun, delay) {
  let canTrig = true;
  // eslint-disable-next-line consistent-return
  return () => {
    if (!canTrig) {
      return false;
    }
    canTrig = false;
    setTimeout(() => {
      fun();
      canTrig = true;
    }, delay);
  };
}

export default {
  debounce, throttle,
};
