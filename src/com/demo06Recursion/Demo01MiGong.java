package com.demo06Recursion;

/**
 * @author : 赵静超
 * @date : 2019/11/10
 * 二维数组模拟迷宫问题，递归方式解决问题
 */
@SuppressWarnings("all")
public class Demo01MiGong {

    private static int count1 = 0;
    private static int count2 = 0;
    private static int count3 = 0;
    private static int count4 = 0;

    public static void main(String[] args) {
        int[][] map = new int[8][7];

        //模拟上下墙壁
        for (int i = 0; i < 7; i++) {
            map[0][i] = 1;
            map[7][i] = 1;
        }
        //模拟左右墙壁
        for (int i = 0; i < 8; i++) {
            map[i][0] = 1;
            map[i][6] = 1;
        }
        //设置挡板
        map[3][1]=1;
        map[3][2]=1;
        //输出地图
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j]+"\t");
            }
            System.out.println();
        }


        //小球开始寻找出路 下、右、上、左
        System.out.println("小球开始寻找出路 下、右、上、左");
        findWay1(map,1,1);
        //打印小球行走路线
        System.out.println("小球行走路线");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j]+"\t");
            }
            System.out.println();
        }
        System.out.println("小球总共探寻次数："+count1+"\n");


/*        //小球开始寻找出路 下、左、上、右 71次
        System.out.println("小球开始寻找出路 下、左、上、右");
        findWay2(map,1,1);
        //打印小球行走路线
        System.out.println("小球行走路线");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j]+"\t");
            }
            System.out.println();
        }
        System.out.println("小球总共探寻次数："+count2+"\n");*/


/*
        //小球开始寻找出路 右、下、左、上 16次
        System.out.println("小球开始寻找出路 右、下、左、上");
        findWay3(map,1,1);
        //打印小球行走路线
        System.out.println("小球行走路线");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j]+"\t");
            }
            System.out.println();
        }
        System.out.println("小球总共探寻次数："+count3+"\n");
*/


/*        //小球开始寻找出路 右、上、左、下
        System.out.println("小球开始寻找出路 右、上、左、下");
        findWay4(map,1,1);
        //打印小球行走路线
        System.out.println("小球行走路线");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j]+"\t");
            }
            System.out.println();
        }
        System.out.println("小球总共探寻次数："+count4+"\n");*/

    }

    /**
     * 如果小球到达map[6][5]，则说明找到出口
     * 约定：
     *      map[i][j] = 0 表示改点没有走过
     *      map[i][j] = 1 表示墙壁
     *      map[i][j] = 2 表示通路可以走
     *      map[i][j] = 3 表示走过，且为死路
     * 策略：
     *      小球路线：下->右->上->左
     *      如果走不通则回溯
     * @param map 表示地图
     * @param i 出发点所在做坐标
     * @param j
     * @return 通过递归回溯算法找到迷宫出路
     */
    public static boolean findWay1(int[][] map,int i,int j){
        count1++;
        if(map[6][5] == 2){      //表示找到出口
            return true;
        }else{      //没有找到出口
            if(map[i][j] == 0){         //表示这一点还没有走过
                //接下来按照策略走，下->右->上->左
                map[i][j] = 2;  //假设这一点可以走通
                if(findWay1(map,i+1,j)){              //向下走
                    return true;
                }else if(findWay1(map,i,j+1)){   //向右走
                    return true;
                }else if(findWay1(map,i-1,j)){   //向左走
                    return true;
                }else if(findWay1(map,i,j-1)){   //向上走
                    return true;
                }else{                             //改点走过，但是走不通
                    map[i][j] = 3;
                    return false;
                }
            }else{      //表示这一点可以为1墙、2走过了、3走不通
                return false;
            }
        }
    }

    //下、左、上、右
    public static boolean findWay2(int[][] map,int i,int j){
        count2++;
        if(map[6][5] == 2){      //表示找到出口
            return true;
        }else{      //没有找到出口
            if(map[i][j] == 0){         //表示这一点还没有走过
                //接下来按照策略走，下->右->上->左
                map[i][j] = 2;  //假设这一点可以走通
                if(findWay2(map,i+1,j)){
                    return true;
                }else if(findWay2(map,i,j-1)){
                    return true;
                }else if(findWay2(map,i-1,j)){
                    return true;
                }else if(findWay2(map,i,j+1)){
                    return true;
                }else{                             //改点走过，但是走不通
                    map[i][j] = 3;
                    return false;
                }
            }else{      //表示这一点可以为1墙、2走过了、3走不通
                return false;
            }
        }
    }

    //右、下、左、上
    public static boolean findWay3(int[][] map,int i,int j){
        count3++;
        if(map[6][5] == 2){      //表示找到出口
            return true;
        }else{      //没有找到出口
            if(map[i][j] == 0){         //表示这一点还没有走过
                //接下来按照策略走，下->右->上->左
                map[i][j] = 2;  //假设这一点可以走通
                if(findWay3(map,i,j+1)){
                    return true;
                }else if(findWay3(map,i+1,j)){
                    return true;
                }else if(findWay3(map,i,j-1)){
                    return true;
                }else if(findWay3(map,i-1,j)){
                    return true;
                }else{                             //改点走过，但是走不通
                    map[i][j] = 3;
                    return false;
                }
            }else{      //表示这一点可以为1墙、2走过了、3走不通
                return false;
            }
        }
    }

    //右、上、左、下
    public static boolean findWay4(int[][] map,int i,int j){
        count4++;
        if(map[6][5] == 2){      //表示找到出口
            return true;
        }else{      //没有找到出口
            if(map[i][j] == 0){         //表示这一点还没有走过
                //接下来按照策略走，下->右->上->左
                map[i][j] = 2;  //假设这一点可以走通
                if(findWay4(map,i,j+1)){
                    return true;
                }else if(findWay4(map,i-1,j)){
                    return true;
                }else if(findWay4(map,i,j-1)){
                    return true;
                }else if(findWay4(map,i+1,j)){
                    return true;
                }else{                             //改点走过，但是走不通
                    map[i][j] = 3;
                    return false;
                }
            }else{      //表示这一点可以为1墙、2走过了、3走不通
                return false;
            }
        }
    }
}
