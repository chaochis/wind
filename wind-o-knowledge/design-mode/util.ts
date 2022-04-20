// 深拷贝

// 检测数据类型
function checkType(obj: Object): string {
  return Object.prototype.toString.call(obj).slice(8, -1)
}

// 获取一个对象得所有属性(包含原型链)
function getAllKeys (obj : Object): Array<string | number | symbol> {
  const keys: Array<Object> = []
  let tempObj = obj
  while(tempObj !== null) {
    keys.push(Object.getOwnPropertyNames(tempObj));
    keys.push(Object.getOwnPropertySymbols(tempObj));
    tempObj = Object.getPrototypeOf(tempObj);
  }
  return <Array<string | number | symbol>>keys;
}
function deepCopy(obj: Object): Object {
  let newObj = {}
  let type = Object.prototype.toString.call(obj).slice(8, -1);
  if (type === 'Undefined' || type === 'Null' || type === 'Number' || type === 'String') {
    return obj;
  } else if (type === 'Date') {
    return new Date((<Date>obj).valueOf())
  } else if (type === 'RegExp') {
    return new RegExp(<RegExp>obj)
  } else if (type === 'Symbol') {
    return Symbol.for((<symbol>obj).description || '')
  } else if (type === 'Map') {
    newObj = new Map<string | symbol | number, Object>();
    (<Map<string | number | symbol, Object>>obj).forEach((value : Object, key: string | number | symbol) => {
      (<Map<string | symbol | number, Object>>newObj).set(key, deepCopy(value))
    })
    return newObj
  } else if (type === 'Set') {
    newObj = new Set<Object>();
    for(let val of (<Set<Object>>obj).values()){
      (<Set<Object>>newObj).add(deepCopy(val))
    }
    return newObj
  } else if (type === 'Function') {
    newObj = new Function(`return ${obj.toString()}`).call(newObj)
    return newObj
  } else if (type === 'Array') {
    newObj = []
    for(let value of <Array<Object>>obj) {
      (<Array<Object>>newObj).push(deepCopy(value))
    }
  } else if (type === 'Object') {
    for(let key of getAllKeys(obj)) {
      Reflect.set(newObj, key, deepCopy(Reflect.get(obj, key)))
    }
  }
  return newObj;
}

export {
  deepCopy
}
