package com.demo03LinkedList.singleLinkedList;

/**
 * @author : 赵静超
 * @date Date : 2019/10/22 21:11
 * @description : 测试单链表类
 */
public class SingleLinkedListDemo {

    public static void main(String[] args) {
        HeroNode hero1 = new HeroNode(0, "任正非", "华为公司");
        HeroNode hero2 = new HeroNode(1, "马化腾", "腾讯公司");
        HeroNode hero3 = new HeroNode(2, "李彦宏", "百度公司");
        HeroNode hero4 = new HeroNode(3, "刘强东", "京东公司");

        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.add(hero1);
        singleLinkedList.add(hero2);
        singleLinkedList.add(hero3);
        singleLinkedList.add(hero4);

        singleLinkedList.getList();

    }
}
