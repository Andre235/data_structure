package com.demo08.分治算法;

/**
 * @author : Jeffersonnn
 * @date : 2020/1/30
 * @description : 用分治算法解决汉诺塔问题
 * 思路分析：
 *      1.如果只有一个盘
 *          1.1 则直接A--->C
 *      2.如果盘子数量多于一个
 *          2.0 将所有盘子只看做两个盘子，盘子1：最下面的盘子  盘子2：最下面盘子的上面所有盘子
 *          2.1 最底下盘子移动到C柱
 *          2.2 最底下的盘子的上面所有盘子移动到B柱
 *          2.3 B柱上面的所有盘子移动到C柱(递归实现)
 */
public class HanioTower {

    public static void main(String[] args) {
        hanioTower(5,'A','B','C');
    }

    /**
     * 使用分治算法解决
     * @param num 盘子数量
     * @param a A塔
     * @param b B塔
     * @param c C塔
     */
    public static void hanioTower(int num,char a,char b,char c){
        if(num == 1){
            System.out.printf("第%d个盘子从%s---->%s\n",num,a,c);
        }
        if(num >1){
            //1.先把最上面的所有盘从A-->B，移动过程中会用到C柱
            hanioTower(num - 1,a,c,b);
            //2.把最下面的盘从A柱-->移动到C柱
            System.out.printf("第%d个盘子从%s---->%s\n",num,a,c);
            //3.把B柱上面的所有盘从B移动到C柱，移动过程中会用到A柱作为临时柱子
            hanioTower(num-1,b,a,c);
        }
    }
}
