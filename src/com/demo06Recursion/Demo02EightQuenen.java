package com.demo06Recursion;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author : 赵静超
 * @date : 2019/11/10
 * @description : 八皇后问题
 */
@SuppressWarnings("all")
public class Demo02EightQuenen {

    public static void main(String[] args) {

        Date date1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format1 = simpleDateFormat.format(date1);
        System.out.println("排序前时间："+format1);

        //bubbleSort();
        selectSort();

        Date date2 = new Date();
        String format2 = simpleDateFormat.format(date2);
        System.out.println("排序后时间："+format2);



    }

    /**
     * 冒泡排序优化版
     * 测试排80000个随机数需要多长时间完成
     */
    private static void bubbleSort() {
        //int[] arr = new int[]{1,-2,8,5,10,20};
        int[] arr = new int[80000];
        for (int i = 0; i < arr.length; i++) {
            arr[i]= (int)(Math.random()*1000000);
        }

        for (int element : arr) {
            System.out.println(element);
        }
        System.out.println();

        int temp;
        boolean flag = false;
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = 0; j < arr.length-1-i; j++) {
                if(arr[j]>arr[j+1]){
                    flag = true;
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
            /*System.out.println("第"+(i+1)+"次排序结果");
            for (int element : arr) {
                System.out.print(element+"\t");
            }
            System.out.println();*/

            if(!flag){
                break;
            }else{
                flag = false;
            }
        }

    }

    /**
     * 选择排序
     */
    private static void selectSort() {
        int[] arr = new int[80000];
        for (int i = 0; i < arr.length; i++) {
            arr[i]= (int)(Math.random()*1000000);
        }

        for (int element : arr) {
            System.out.println(element);
        }
        System.out.println();

        int min ;
        int minIndex;
        for (int i = 0; i < arr.length - 1; i++) {
            min = arr[i];
            minIndex = i;
            for (int j = i+1; j <arr.length; j++) {
                if(min > arr[j]){
                    min = arr[j];
                    minIndex = j;
                }
            }

            if(minIndex != i){
                arr[minIndex] =arr[i];
                arr[i] = min;
            }
        }

        /*for (int i : arr) {
            System.out.print(i+"  ");
        }*/

    }




}
