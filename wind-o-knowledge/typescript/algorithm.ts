import { deepCopy } from './util';

// 1.链表
{
  // 1.双端链表
  {
    class SingleList<T>{
      private node!: T;
      private head!: SingleList<T>;
      private tail!: SingleList<T>;
      private next!: SingleList<T> | null;
      private prev!: SingleList<T> | null;
      private length: number;
      constructor() {
        this.head = this;
        this.tail = this;
        this.next = null;
        this.prev = null;
        this.length = 0;
      }
      addNode(tNode : T): void {
        let tailNode = this.tail;
        let nextNode = new SingleList<T> ();
        nextNode.node = tNode;
        nextNode.next = null;
        nextNode.prev = tailNode;
        tailNode.next = nextNode;
        this.tail = nextNode;
        this.length ++;
      }
      showAllNode(): Array<T>{
        let finalArray:Array<T> = [];
        let node = this.head.next;
        while(node !== null) {
          finalArray.push(node.node);
          node = node.next;
        }
        return finalArray;
      }
      getHeadNode(): T | null {
        return this.head.next ? this.head.next.node : null;
      }
      getTailNode(): T |null {
        return this.tail.node === undefined ? null : this.tail.node;
      }
      size(): number {
        return this.length;
      }
    }
  }
}

// 2.栈
{
  class Stack<T>{
    private data: Array<T>;
    private top:number;
    private length: number;
    constructor() {
      this.length = 0;
      this.data = [];
      this.top = -1;
    }
    push(item:T): void {
      this.top ++;
      this.data[this.top] = item;
      this.length ++;
    }
    pop(): T | null{
      if (this.size()) {
        let data = this.data[this.top]
        this.data.splice(this.top, 1)
        this.top --;
        this.length --;
        return data;
      } else {
        console.log("栈空了!")
        return null;
      }
    }

    /**
     * 显示栈内所有的数据
     * @param isPopOrder 是否按照出栈顺序
     */
    showAllData(isPopOrder: boolean = true): Array<T> {
      let data = <Array<T>>deepCopy(this.data)
      return isPopOrder ? data.reverse() : data;
    }

    /**
     * 显示栈的大小
     */
    size(): number{
      return this.length;
    }
  }
  let stack = new Stack<String>();
  stack.push("222")
  stack.push("111")
  console.log(stack.pop())
  console.log(stack.pop())
  console.log(stack.pop())
}

// 3.队列


// 4.树

// 5.图
