package com.demo09.暴力匹配;

/**
 * @author : Jeffersonnn
 * @date : 2020/1/31
 * @description : 暴力匹配算法实现字符串的匹配
 */
public class ViolenceMatch {

    public static void main(String[] args) {
        String str1 = "尚硅 尚硅谷你尚硅谷 尚硅谷你尚硅谷上上上上";
        String str2 = "尚硅谷你尚硅谷上";
        int index = violenceMatch(str1, str2);
        if(index == -1){
            System.out.println("父字符串str1中不含子字符串str2");
        }else{
            System.out.println("子字符串str2在父字符串str1的索引位置为"+index);
        }
    }

    private static int violenceMatch(String str1,String str2) {
        char[] charArray1 = str1.toCharArray();
        char[] charArray2 = str2.toCharArray();

        int length1 = charArray1.length;
        int length2 = charArray2.length;

        int i = 0;
        int j = 0;
        //将索引越界作为判断条件
        while (i < length1 && j < length2){
            if(charArray1[i] == charArray2[j]){
                i++;
                j++;
            }else{
                i = i - (j - 1);
                j = 0;
            }
        }

        if(j == length2){
            return i - j;
        }else{
            return -1;
        }

    }
}
