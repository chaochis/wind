/**
 * 获取dom对象的宽高
 * @param element dom对象
 * @returns {{width, height}} width - 宽度 height - 高度
 */
function getELementSize(element) {
  const size = {
    width: element.style.width || element.clientWidth,
    height: element.style.height || element.clientHeight,
  };
  return size;
}

export default {
  getELementSize,
};
