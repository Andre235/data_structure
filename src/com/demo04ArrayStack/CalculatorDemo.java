package com.demo04ArrayStack;

/**
 * @author : 赵静超
 * @date : 2019/11/9
 */
public class CalculatorDemo {

    public static void main(String[] args) throws Exception {
        String expression = "3+2*6-2";
        //数据栈
        Calculator dataStack = new Calculator(10);
        //符号栈
        Calculator opeStack = new Calculator(10);
        //表示接受符号的下标
        int index = 0;
        int num1 = 0;
        int num2 = 0;
        int ope = 0;
        char ch = ' ';
        int result = 0;
        //开始循环扫描表达式
        while (true){
            //依次获取操作符号
            ch  = expression.substring(index,index+1).charAt(0);
            //判断表达式是符号还是数字
            if(opeStack.isOperation(ch)){  //是运算符号
                if(!opeStack.isEmpty()){
                    //1.栈不空，则判断符号优先级，当前运算符号优先级小于栈内符号优先级
                    if(opeStack.getPriority(ch) <= opeStack.getPriority(opeStack.peek())){
                        //2.数据栈出栈两个数据，符号栈出栈一个符号，进行运算
                        num1 = dataStack.pop();
                        num2 = dataStack.pop();
                        ope = opeStack.pop();
                        result = dataStack.getResult(num1,num2,ope);
                        //3.结果入数据栈，当前符号入符号栈
                        dataStack.push(result);
                        opeStack.push(ch);
                    }else{      //当前符号优先级大于栈顶元素优先级，则当前符号入符号栈
                        opeStack.push(ch);
                    }
                }else{       //栈空，则入栈
                    opeStack.push(ch);
                }
            }else{  //不是运算符号
                dataStack.push(ch - 48);
            }
            index ++;
            if(index >= expression.length()){
                break;
            }
        }
        while(true){
            if(opeStack.isEmpty()){
                break;
            }
            num1 = dataStack.pop();
            num2 = dataStack.pop();
            ope = opeStack.pop();
            result = dataStack.getResult(num1,num2,ope);
            dataStack.push(result);
        }
        int res = dataStack.pop();
        System.out.println(expression+"="+res);
    }
}
