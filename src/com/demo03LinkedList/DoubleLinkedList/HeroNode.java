package com.demo03LinkedList.DoubleLinkedList;

import com.oracle.webservices.internal.api.databinding.DatabindingMode;

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public HeroNode getNext() {
        return next;
    }

    public void setNext(HeroNode next) {
        this.next = next;
    }

    public HeroNode getPre() {
        return pre;
    }

    public void setPre(HeroNode pre) {
        this.pre = pre;
    }

    public HeroNode() {
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
