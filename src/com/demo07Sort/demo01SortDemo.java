package com.demo07Sort;

/**
 * @author : zhaojingchao
 * @date : 2019/11/14
 * @description : 基本排序算法
 */
@SuppressWarnings("all")
public class demo01SortDemo {

    public static void main(String[] args) {
        //bubbleSort();
        selectSort();
    }

    /**
     * 冒泡排序优化版
     */
    private static void bubbleSort() {
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i]= (int)(Math.random()*100+1);
        }
        System.out.println("排序前数组：");
        for (int i : arr) {
            System.out.print(i+"  ");
        }
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
            if(!flag){
                break;
            }else{
                flag = false;
            }
        }
        System.out.println("\n排序后数组：");
        for (int i : arr) {
            System.out.print(i+"  ");
        }
    }

    /**
     * 选择排序
     */
    private static void selectSort() {
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i]= (int)(Math.random()*100+1);
        }
        System.out.println("排序前数组：");
        for (int i : arr) {
            System.out.print(i+"  ");
        }

        int min,minIndex;
        for (int i = 0; i < arr.length-1; i++) {
            min = arr[i];
            minIndex = i;
            for (int j =i+1; j <arr.length; j++) {
                if(min>arr[j]){
                    min = arr[j];
                    minIndex = j;
                }
            }
            if(minIndex != i){
                arr[minIndex] = arr[i];
                arr[i] = min;
            }
        }
        System.out.println("\n排序后数组：");
        for (int i : arr) {
            System.out.print(i+"  ");
        }
    }
}
