package com.demo03LinkedList.singleLinkedList;

/**
 * @author : 赵静超
 * @date Date : 2019/10/22 21:11
 * @description : 测试单链表类
 */
public class SingleLinkedListDemo {

    private static SingleLinkedList singleLinkedList = new SingleLinkedList();

    public static void main(String[] args) throws IllegalArgumentException {
        HeroNode hero1 = new HeroNode(1, "任正非", "华为公司");
        HeroNode hero2 = new HeroNode(2, "马化腾", "腾讯公司");
        HeroNode hero3 = new HeroNode(3, "李彦宏", "百度公司");
        HeroNode hero4 = new HeroNode(4, "刘强东", "京东公司");

       //按照编号顺序添加节点
        singleLinkedList.addByOrder(hero1);
        singleLinkedList.addByOrder(hero4);
        singleLinkedList.addByOrder(hero3);
        singleLinkedList.addByOrder(hero2);
        singleLinkedList.getList();

        updateNode();

        System.out.println("反转之后的链表:");
        singleLinkedList.reverseList();
        singleLinkedList.getList();

        //测试逆序打印链表方法
        System.out.println("测试逆序打印链表方法:");
        singleLinkedList.reversePrint();

        //getNodeInfoByIndex();

        //delete();
    }

    /**
     * 测试获取链表倒数第K个节点方法
     */
    private static void getNodeInfoByIndex() {
        HeroNode infoByIndex = singleLinkedList.getInfoByIndex(3);
        System.out.println("测试获取链表倒数第K个节点方法:"+infoByIndex);
    }

    /**
     * 测试修改节点信息方法
     */
    private static void updateNode() {
        HeroNode newHeroNode = new HeroNode(2, "小马", "腾讯股份有限公司");
        singleLinkedList.update(newHeroNode);
        System.out.println("修改之后的单链表");
        singleLinkedList.update(newHeroNode);
        singleLinkedList.getList();
        //测试获取链表有效节点个数方法
        System.out.println("链表有效节点个数为："+singleLinkedList.getLength());
    }

    /**
     * 测试删除节点方法
     */
    private static void delete() {
        singleLinkedList.del(4);
        singleLinkedList.del(1);
        singleLinkedList.del(3);
        singleLinkedList.del(2);
        System.out.println("删除后的链表信息");
        singleLinkedList.getList();
        //测试获取链表有效节点方法
        System.out.println("链表有效节点个数为："+singleLinkedList.getLength());
    }
}
