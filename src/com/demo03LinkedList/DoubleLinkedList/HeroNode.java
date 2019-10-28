package com.demo03LinkedList.DoubleLinkedList;

/**
 * @author : 赵静超
 * @date Date : 2019年10月28日
 * @description : 双向链表节点
 */
public class HeroNode {

    int id;
    String name;
    String company;
    HeroNode next;
    HeroNode pre;

    public HeroNode(int id, String name, String company) {
        this.id = id;
        this.name = name;
        this.company = company;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", company='" + company + '\'' +
                '}';
    }
}
