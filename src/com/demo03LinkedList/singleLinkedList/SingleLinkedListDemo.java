package com.demo03LinkedList.singleLinkedList;

/**
 * @author : 赵静超
 * @date Date : 2019/10/22 21:11
 * @description : 测试单链表类
 */
public class SingleLinkedListDemo {

    public static void main(String[] args) {
        HeroNode hero1 = new HeroNode(1, "任正非", "华为公司");
        HeroNode hero2 = new HeroNode(2, "马化腾", "腾讯公司");
        HeroNode hero3 = new HeroNode(3, "李彦宏", "百度公司");
        HeroNode hero4 = new HeroNode(4, "刘强东", "京东公司");

        SingleLinkedList singleLinkedList = new SingleLinkedList();
       /*singleLinkedList.add(hero1);
        singleLinkedList.add(hero2);
        singleLinkedList.add(hero3);
        singleLinkedList.add(hero4);*/

       //按照编号顺序添加节点
        singleLinkedList.addByOrder(hero1);
        singleLinkedList.addByOrder(hero4);
        singleLinkedList.addByOrder(hero3);
        singleLinkedList.addByOrder(hero2);

        singleLinkedList.getList();

        //测试修改节点信息方法
        HeroNode newHeroNode = new HeroNode(2, "小马", "腾讯股份有限公司");
        singleLinkedList.update(newHeroNode);
        System.out.println("修改之后的单链表");
        singleLinkedList.update(newHeroNode);
        singleLinkedList.getList();

        //测试删除节点方法
        singleLinkedList.del(4);
        singleLinkedList.del(1);
        singleLinkedList.del(3);
        singleLinkedList.del(2);
        System.out.println("删除后的链表信息");
        singleLinkedList.getList();
    }
}
