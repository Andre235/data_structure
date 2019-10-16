package com.demo01SparseArray;

/**
 * @author : 赵静超
 * @date Date : 2019/10/16 21:21
 * @description : 二维数组与稀疏数组相互转换
 *                模拟棋盘，0：没有棋子 1：黑棋 2：蓝棋
 */
public class Demo01SparseArray {
    public static void main(String[] args) {
        int[][] chessArray = new int[11][11];
        chessArray[1][2]=1;
        chessArray[2][4]=2;
        chessArray[0][0]=4;
        System.out.println("原始二维数组为：");
        for (int[] row : chessArray) {
            for (int data : row) {
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }

        int [][] sparseArray=arrayToSparseArray(chessArray);
        sparseArrayToArray(sparseArray);
    }

    /**
     * 二维数组转稀疏数组
     * 1. 遍历原始的二维数组，得到有效数据的个数sum
     * 2. 根据sum 就可以创建 稀疏数组 sparseArr  int[sum + 1] [3]
     * 3. 将二维数组的有效数据数据存入到稀疏数组
     */
    private static int[][] arrayToSparseArray(int[][] arr) {
        //统计二维数组非零元素个数
        int noZeroNums=0;
        for (int i = 0; i <11 ; i++) {
            for (int j = 0; j < 11; j++) {
                if(arr[i][j]!=0){
                    noZeroNums++;
                }
            }
        }

        int[][] sparseArray = new int[noZeroNums + 1][3];
        sparseArray[0][0]=11;
        sparseArray[0][1]=11;
        sparseArray[0][2]=noZeroNums;

        //判断出是第几个非零元素
        int count=0;
        for (int i = 0; i <11 ; i++) {
            for (int j = 0; j < 11; j++) {
                if(arr[i][j]!=0){
                    count++;
                    sparseArray[count][0]=i;
                    sparseArray[count][1]=j;
                    sparseArray[count][2]=arr[i][j];
                }
            }
        }

        System.out.println("二维数组转稀疏数组：");
        for (int i = 0; i < count+1; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.printf("%d\t",sparseArray[i][j]);
            }
            System.out.println();
        }

        return sparseArray;
    }

    /**
     * 稀疏数组转二维数组
     * 1. 先读取稀疏数组的第一行，根据第一行的数据，创建原始的二维数组，比如上面的chessArr2 = int [11][11]
     * 2. 再读取稀疏数组后几行的数据，并赋给原始的二维数组即可
     */
    private static void sparseArrayToArray(int[][] sparseArr) {
        int row=sparseArr[0][0];
        int line=sparseArr[0][1];
        int[][] arr = new int[row][line];
        for (int i = 1; i <sparseArr.length ; i++) {
            int rowData=sparseArr[i][0];
            int lineData=sparseArr[i][1];
            int data=sparseArr[i][2];
            arr[rowData][lineData]=data;
        }
        System.out.println("恢复后的二维数组为：");
        for (int[] rowArr : arr) {
            for (int element : rowArr) {
                System.out.printf("%d\t",element);
            }
            System.out.println();
        }
    }


}
