package com.demo03LinkedList.singleLinkedList;

import java.util.Stack;

/**
 * @author : zhaojingchao
 * @date : 2019/10/28
 */
public class TestStack {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        stack.add("tom");
        stack.add("jack");
        stack.add("jerry");

        while (stack.size() > 0){
            System.out.println(stack.pop());
        }
    }
}
