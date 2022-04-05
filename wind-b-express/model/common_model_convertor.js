const modelTransfer = require("../util/type_util");

class ModelConvertor {
  convertMap = [];
  // 实例对象转换为数据库对象
  convertToData(obj) {
    return convert.call(this, obj, 0);
  }
  // 数据库对象转换为实体
  convertToModel(obj) {
    return convert.call(this, obj, 1)
  }
}

// 具体的转换方法
function convert(obj, type) {
  // 解析用的方法体
  const convertObjFunction = (objItem) => {
    let convertItem = {}
    for(let mapItem of this.convertMap) {
      const targetName = type ? mapItem.voName : mapItem.dataName
      const originName = type ? mapItem.dataName : mapItem.voName
      if (mapItem.enumType) {
        convertItem[targetName] = modelTransfer(mapItem.enumType[objItem[originName]])
      } else {
        convertItem[targetName] = modelTransfer(objItem[originName])
      }
    }
    return convertItem
  }

  // 分别解析单个对象与数组对象
  let convertObj = []
  let isArray = true
  if (typeof obj === null || typeof obj === undefined) {
    return null
  }
  if (!Array.isArray(obj)) {
    obj = [obj]
  }
  for(let item of obj) {
    convertObj.push(convertObjFunction(item))
  }
  return isArray ? convertObj : convertObj[0];
}
const convertorMap = new WeakMap()
const modelConvertor = convertMap => {
  let convertor
  if (convertorMap.has(convertMap)) {
    convertor = convertorMap.get(convertMap);
  } else {
    convertor = new ModelConvertor()
  }
  convertor.convertMap = convertMap;
  return convertor;
}

module.exports = modelConvertor