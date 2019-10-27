package com.demo03LinkedList.singleLinkedList;

/**
 * @author : 赵静超
 * @date Date : 2019/10/22 21:12
 * @description : 英雄节点
 */
public class HeroNode {

    int id;
    String name;
    String company;
    HeroNode next;

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
