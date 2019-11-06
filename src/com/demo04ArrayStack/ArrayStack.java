package com.demo04ArrayStack;

/**
 * @author : 赵静超
 * @date : 2019/11/4
 * @description : 栈基本属性
 */
public class ArrayStack {

    //用数组模拟栈，基本元素就存在数组中
    private int maxSize;

    //用数组模拟栈，基本元素就存在数组中
    private int[] stack;

    //模拟栈顶操作，默认top = -1
    private int top = -1;

    //构造器
    public ArrayStack(int size){
        this.maxSize = size;
        stack = new int[this.maxSize];
    }

    /**
     * @return 判断栈内元素是否已满
     */
    public boolean isFull(){
        return top == maxSize-1;
    }

    /**
     * @return 判断栈是否为空
     */
    public boolean isEmpty(){
        return top == -1;
    }

    /**
     * @param value 入栈
     */
    public void push(int value) throws Exception {
        if(isFull()){
            throw new Exception("当前栈空间已满！");
        }
        top++;
        stack[top] = value;
    }

    /**
     * @return 出栈元素
     * @throws Exception 判断栈是否为空
     */
    public int pop() throws Exception {
        if(isEmpty()){
            throw new Exception("当前栈为空！");
        }
        int temp = stack[top];
        top--;
        return temp;
    }

    /**
     * 遍历栈元素
     */
    public void getList(){
        if (isEmpty()){
            System.out.println("当前栈空！");
            return;
        }
        for (int i = top; i >= 0; i--) {
            System.out.printf("stack[%d]=%d\n",i,stack[i]);
        }
    }

}
