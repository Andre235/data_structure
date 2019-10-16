package com.demo02ArrayQueue;

/**
 * @author : 赵静超
 * @date Date : 2019/10/16 22:31
 * @description : 用数组模拟队列
 */
public class ArrayQueue {
    //队列最大长度
    private int maxSize;
    //队列头部
    private int front;
    //队列尾部
    private int rear;
    //用数组模拟队列
    private int arr[];

    ArrayQueue(int size){
        this.maxSize = size;
        this.arr = new int[size];
        //初始化队列时，队列头部默认为-1，指向队列第一个元素的前一个元素(即不包含第一个元素)
        this.front = -1;
        //队列尾部默认为-1，包含最后一个元素
        this.rear = -1;
    }

    public boolean isEmputy(){
        return rear==front;
    }

    public boolean isFull(){
        return rear==maxSize-1;
    }

    /**
     * 往队列添加数据
     * @param num
     */
    public void addQueue(int num){
        if(isFull()){
            System.out.println("队列内存已满！");
            return;
        }
        rear++;
        arr[rear]=num;
    }

    /**
     * 取出队列数据
     * @return
     */
    public int getQueue(){
        if(isEmputy()){
            throw new RuntimeException("队列没有数据！");
        }
        front++;
        return arr[front];
    }

    public void getAll(){
        if(isEmputy()){
            throw new RuntimeException("队列为空！");
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("arr[%d]:%d",i,arr[i]);
        }
    }

    /**
     * 获取队列的头部元素
     * @return
     */
    public int headData(){
        if(isEmputy()){
            throw new RuntimeException("队列为空！");
        }
        return arr[front+1];
    }

}
