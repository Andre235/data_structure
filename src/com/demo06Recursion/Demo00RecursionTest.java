package com.demo06Recursion;

/**
 * @author : 赵静超
 * @date : 2019/11/10
 * 每次递归一个方法，则在栈内存中开辟一块内存空间，递归结束则逆序返回所有的方法
 */
public class Demo00RecursionTest {
    public static void main(String[] args) {
        test(4);
        int getFactorial = factorial(3);
        System.out.println("阶乘："+getFactorial);
    }

    /**
     * @param n 递归打印问题
     */
    private static void test(int n) {
        if(n>2){
            test(n-1);
        }
        System.out.println("n="+n);
    }

    /**
     * @param num
     * @return 阶乘问题
     */
    private static int factorial(int num) {
        if(num == 1){
            return 1;
        }else{
            return factorial(num-1) * num;
        }
    }
}
