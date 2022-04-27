import { deepCopy } from './util';
// 1.工厂模式
{
  interface Shape {
    draw: () => void;
  }

  class Square implements Shape {
    draw(): void {
      console.log('工厂模式: 输出square');
    }
  }

  class Circle implements Shape {
    draw(): void {
      console.log('工厂模式: 输出circle');
    }
  }

  class ShapeFactory {
    public createShape(shapeStr: string | null): Shape | null {
      if (shapeStr === null) {
        return null;
      }
      if (shapeStr === 'Square') {
        return new Square();
      } else if (shapeStr === 'Circle') {
        return new Circle();
      }
      return null;
    }
  }

  function testShapeFactory(): void {
    let shapeFactory: ShapeFactory = new ShapeFactory();
    let circle: Circle | null = shapeFactory.createShape('Circle');
    let square: Square | null = shapeFactory.createShape('Square');
    if (null !== circle) {
      circle.draw();
    }
    if (square !== null) {
      square.draw();
    }
  }

  testShapeFactory();
}

// 2. 抽象工厂模式
{
  interface Shape {
    draw: () => void;
  }

  class Square implements Shape {
    draw(): void {
      console.log('抽象工厂模式: 输出square');
    }
  }

  class Circle implements Shape {
    draw(): void {
      console.log('抽象工厂模式: 输出circle');
    }
  }

  interface Color {
    fill: () => void;
  }

  class Red implements Color {
    fill(): void {
      console.log('抽象工厂模式: 输出red');
    }
  }

  class Blue implements Color {
    fill(): void {
      console.log('抽象工厂模式: 输出Blue');
    }
  }

  interface Product {
    color: Color;
    shape: Shape;
  }

  class AProduct {
    color: Color;
    shape: Shape;

    constructor(color: Color, shape: Shape) {
      this.color = color;
      this.shape = shape;
    }
  }


  interface ProductFactory {
    createProduct: () => Product;
  }

  class AProductFactory implements ProductFactory {
    createProduct(): Product {
      return new AProduct(new Red(), new Square());
    }
  }

  class BProductFactory implements ProductFactory {
    createProduct(): Product {
      return new AProduct(new Blue(), new Circle());
    }
  }

  function testProductFactory(): void {
    let aProductFactory: ProductFactory = new AProductFactory();
    let bProductFactory: ProductFactory = new BProductFactory();
    let aProduct: Product = aProductFactory.createProduct();
    let bProduct: Product = bProductFactory.createProduct();
    aProduct.color.fill();
    aProduct.shape.draw();
    bProduct.color.fill();
    bProduct.shape.draw();
  }
  testProductFactory();
}

// 3.单例模式
{
  // 方案一: 饿汉式
  {
    class SingleObject{
      private static instance: SingleObject = new SingleObject();
      private constructor() {}
      public static getInstance(): SingleObject {
        return this.instance;
      }
      public getMessage(): string {
        return "单例模式: 方案一"
      }
    }
    console.log(SingleObject.getInstance().getMessage());
  }

  // 方案二: 懒汉式
  {
    class SingleObject{
      private static instance : SingleObject;
      private constructor() {}
      public static getInstance() : SingleObject {
        if (this.instance === null) {
          this.instance = new SingleObject();
        }
        return this.instance;
      }
    }
  }
}

// 4.建造者模式
{
  // 简易方案一
  {
    // 1. 利用外部类builder
    {
      class Builder {
        private readonly computer: Computer;
        public constructor(cpu: string, ram: string, computer: Computer) {
          this.computer = computer;
          this.computer.cpu = cpu;
          this.computer.ram = ram;
        }
        public setUsbCount(usbCount: number): Builder {
          this.computer.usbCount = usbCount;
          return this;
        }
        public setKeyBoard(keyboard : string): Builder {
          this.computer.keyboard = keyboard;
          return this;
        }
        public build() {
          return this.computer;
        }
      }

      class Computer {
        public cpu!: string;
        public ram!: string;
        public usbCount!: number;
        public keyboard!: string;
        public static builder(cpu: string, ram: string) {
          return new Builder(cpu, ram, new Computer());
        }
        private constructor() {}
      }
      let computer: Computer = Computer.builder('cpu', 'ram').setKeyBoard('true').setUsbCount(5).build();
      console.log(`建造者模式1:${computer}`);
    }
  }
}

// 5.原型模式
{
  interface Cloneable{
    clone: () => Cloneable;
  }

  class Computer implements Cloneable{
    private name!: string;
    private date!: Date;
    private getName(): string {
      return this.name;
    }
    public clone(): Computer {
      return <Computer>deepCopy(this);
    }
  }
}

// 6.适配器模式
{
  // 原日志接口
  interface LogFactory{
    debug(tag: string, message: string): void
  }

  // 第三方日志接口以及实现
  interface CCLogFactory{
    ccDebug(message: string, ...args: Array<Object>): void;
  }

  class CCLogFactoryImpl implements CCLogFactory{
    ccDebug(message: string, ...args: Array<Object>): void {
      console.log('日志第三方接口: '+ message + args)
    }
  }

  // 适配的类
  class LogAdapter implements LogFactory{
    private ccLog: CCLogFactoryImpl;
    constructor(ccLog: CCLogFactoryImpl) {
      this.ccLog = ccLog;
    }
    debug(tag: string, message: string): void{
      this.ccLog.ccDebug(message, '是真的', '好')
    }
  }

  let log = new LogAdapter(new CCLogFactoryImpl());
  log.debug("属性:", "你是");
}

