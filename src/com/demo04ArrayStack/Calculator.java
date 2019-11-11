package com.demo04ArrayStack;

import java.util.Calendar;

/**
 * @author : 赵静超
 * @date : 2019/11/9
 */
public class Calculator extends ArrayStack{

    Calculator(int size){
        super(size);
    }

    /**
     * @param operation 输入操作运算符
     * @return 返回运算符的优先级，数字越大则优先级越高
     */
    public int getPriority(int operation) throws Exception {
        if(operation == '*' || operation == '/'){
            return 1;
        }else if(operation == '+' || operation == '-'){
            return 0;
        }else{
            throw new IllegalArgumentException("请输入正确的运算符！");
        }
    }

    /**
     * @param ope
     * @return 判断输入的运算符号是否合法
     */
    public boolean isOperation(int ope){
        return ope == '+' || ope == '-' || ope == '*' || ope == '/';
    }

    /**
     * @param num1
     * @param num2
     * @param ope 运算符号
     * @return 输出运算结果
     */
    public int getResult(int num1, int num2, int ope){
        int result = 0;
        switch (ope){
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                try {
                    result = num1 / num2;
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
        }
        return result;
    }

}
