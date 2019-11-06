package com.demo04ArrayStack;

import java.util.Scanner;

/**
 * @author : 赵静超
 * @date : 2019/11/4 21:45
 * @description :
 */
public class ArrayStackDemo {
    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack(5);
        boolean loop = true;
        String key = "";
        Scanner scanner = new Scanner(System.in);

        while (loop){
            System.out.println("\n\nshow:打印栈内元素");
            System.out.println("push:压栈操作");
            System.out.println("pop:出栈操作");
            System.out.println("exit:退出程序");
            System.out.print("请输入当前操作：");
            key = scanner.next();
            switch(key){
                case "show" :
                    stack.getList();
                    break;
                case "push" :
                    try {
                        System.out.print("请输入压栈参数：");
                        int data = scanner.nextInt();
                        stack.push(data);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case "pop" :
                    try {
                        int element = stack.pop();
                        System.out.printf("当前出栈元素为：%d\n",element);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case "exit" :
                    loop = false;
                    scanner.close();
                    System.out.println("程序已经退出...");
                    break;
                default:
                    System.out.println("请输入正确参数！");
                    break;
            }
        }
    }
}
