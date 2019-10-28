package com.demo03LinkedList.DoubleLinkedList;

/**
 * @author : zhaojingchao
 * @date : 2019/10/28
 */
public class DoubleLinkedListDemo {
    public static void main(String[] args) {
        HeroNode hero1 = new HeroNode(1, "任正非", "华为公司");
        HeroNode hero2 = new HeroNode(2, "马化腾", "腾讯公司");
        HeroNode hero3 = new HeroNode(3, "李彦宏", "百度公司");
        HeroNode hero4 = new HeroNode(4, "刘强东", "京东公司");
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();

        doubleLinkedList.add(hero1);
        doubleLinkedList.add(hero2);
        doubleLinkedList.add(hero3);
        doubleLinkedList.add(hero4);

        doubleLinkedList.getList();

        //测试修改方法
        System.out.println("修改之后的双向链表：");
        HeroNode newHeroNode = new HeroNode(4, "刘东强", "东京公司");
        doubleLinkedList.update(newHeroNode);
        doubleLinkedList.getList();

        //测试删除方法
        System.out.println("删除之后的双向链表：");
        doubleLinkedList.del(4);
        doubleLinkedList.getList();

    }
}
