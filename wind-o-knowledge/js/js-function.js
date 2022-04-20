// 1. 柯里化
{
  // 方法一
  {
    function Currying(fn) {
      let args = Array.prototype.slice.call(arguments, 1);
      return function() {
        let innerArgs = Array.prototype.slice.call(arguments);
        let finalArgs = args.concat(innerArgs)
        return fn.apply(null, finalArgs)
      }
    }

    function Add(num1, num2) {
      return num1 + num2;
    }

    console.log(Currying(Add, 1, 2)())
  }
  // 方案二 不借助额外方法调用()
  {
    function argsSum(args) {
      return args.reduce((pre, cur) => pre + cur, 0)
    }

    const foo = (...args1) => {
      const sum1 = argsSum(args1)
      const fn = (...args2) => {
        const sum2 = argsSum(args2);
        return foo(sum1 + sum2)
      }
      fn.toString = () => {
        return sum1
      }
      return fn
    }
    console.log(Number(foo(1, 2, 3)))
  }
}

// 2.js继承
{
  // 方法一: 原型链继承
  {
    function Parent() {
      this.name = 'parent1';
      this.play = [1,2,3]
    }

    function Child() {
      this.type = 1;
    }

    Child.prototype = new Parent()

    // 该方法有潜在的风险，就是因为构造的实例使用的是同一个原型对象，所以构造子类的内存空间是共享的，所以修改
    // 子实例对象的属性后，另一个实例对象的属性也会随之改变，以下举例子
    let s1 = new Child()
    let s2 = new Child()
    s1.play.push(2)
    // 打印s1跟s2的play属性的结果如下:
    //  [ 1, 2, 3, 2 ]
    //  [ 1, 2, 3, 2 ]
  }

  {
    // 方法二: 构造函数继承
    function Parent2() {
      this.name = 'parent2';
    }
    Parent2.prototype.getName = function () { return this.name }
    function Child2() {
      Parent2.call(this)
      this.type = 'child2'
    }

    let child2 = new Child2()
    // console.log(child2)
    // console.log(child2.getName())

    // 这种继承方式可以避免第一条的问题，但是有了新的问题，父类原型对象中一旦存在父类之前自己
    // 定义的方法，那么子类将无法继承这些方法
  }

  // 3. 组合继承
  {
    function Parent3() {
      this.name = 'parent3'
      this.play = [1,2,3]
    }
    Parent3.prototype.getName = function() {
      return this.name;
    }

    function Child3() {
      Parent3.call(this)
      this.type = 'Child3'
    }
    Child3.prototype = new Parent3();
    Child3.prototype.constructor = Child3;
    let s3 = new Child3();
    let s4 = new Child3();
    s3.play.push(2)
    // console.log(s3.play)
    // console.log(s4.play)
    // console.log(s3.getName())
    // 但是这里又增加了一个新问题：通过注释我们可以看到 Parent3 执行了两次，第一次是
    // 改变Child3 的 prototype 的时候，第二次是通过 call 方法调用 Parent3 的时候，
    // 那么 Parent3 多构造一次就多进行了一次性能开销，这是我们不愿看到的。
  }

  // 4.拷贝继承
  {
    function Parent4() {
    }
    Parent4.prototype.name = 'parent4';
    Parent4.prototype.age = 45;
    Parent4.prototype.getName = function() {
      return this.name;
    }
    function Child4() {
      for (let key in Parent4.prototype) {
        this[key] = Parent4.prototype[key];
      }
      this.block = 33
    }
    let s6 = new Child4();
    // console.log(s6)
    // 效率较低，内存占用高（因为要拷贝父类的属性）
    // 无法获取父类不可枚举的方法（不可枚举方法，不能使用for in 访问到)
  }

  // 5. 实例继承
  {
    function Parent5(name) {
      // 属性
      this.name = name || 'Animal';
      // 实例方法
      this.sleep = function() {
        console.log(this.name + '正在睡觉！');
      }
    }

    function Cat(name){
      let instance = new Cat();
      instance.name = name || 'Tom';
      return instance;
    }

    // 该继承方法中实例时父类的实例, 不是子类的实例，也不支持多继承
  }

  // 6. 原型式继承
  {
    let parent6 = {
      name: "parent6",
      friends: ["p1", "p2", "p3"],
      getName: function() {
        return this.name;
      }
    };
    let child6 = Object.create(parent6);
    child6.friends.push(7);
    let child7 = Object.create(parent6);
    // 这种继承方式弊端是直接拷贝的对象引用，这种可能会导致对象被修改。
  }

  // 7.寄生式继承
  {
    let parent7 = {
      name: "parent7",
      friends: ["p1", "p2", "p3"],
      getName: function() {
        return this.name;
      }
    };
    function clone(original) {
      let clone = Object.create(original);
      clone.getFriends = function() {
        return this.friends;
      };
      return clone;
    }
    let person5 = clone(parent7);
  }

  // 8.寄生组合式继承
  {
    function Parent8() {
      this.name = 'parent6';
      this.play = [1, 2, 3];
    }
    Parent8.prototype.getName = function () {
      return this.name;
    }
    function Child8() {
      Parent8.call(this);
      this.friends = 'child6';
    }

    function Clone(parent, child) {
      child.prototype = Object.create(parent.prototype);
      child.prototype.constructor = child;
    }

    clone(Parent8, Child8);
    Child8.prototype.getFriends = function () {
      return this.friends;
    }

    let person9 = new Child8();
    console.log(person9);
    // console.log(person9.getName());
    console.log(person9.getFriends());
    // 它可以解决组合继承 父类被调用两次和在不同层级属性重复的问题。

  }

}

// 3.es6 extends继承机制
{
  class Person{

  }
}


// 4.拷贝机制
{
  function checkType(obj) {
    return Object.prototype.toString.call(obj).slice(8, -1)
  }
  function deepCopy(obj) {
    let newObj = {};
    let type = Object.prototype.toString.call(obj).slice(8, -1);
    if (type === 'Undefined' || type === 'Null' || type === 'Number' || type === 'String') {
      newObj = obj;
    }
    return newObj;
  }
}



