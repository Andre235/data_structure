package com.demo03LinkedList.singleLinkedList;

/**
 * @author : 赵静超
 * @date Date : 2019/10/22 21:42
 * @description :  定义单链表 管理英雄节点
 */
public class SingleLinkedList {

    //先定义一个头结点，头结点不动，不存放任何数据
    private HeroNode head = new HeroNode(0,"","");

    //

    /**
     * 添加节点到单链表中
     * 1、找到当前链表的最后一个节点
     * 2、将最后一个节点的指针指向新添加节点的地址
     * @param node
     */
    public void add(HeroNode node){
        //因为head节点不能动，故需要声明一个临时变量temp
        HeroNode temp = head;
        //遍历链表，找到最后一个节点
        while(true){
            if(temp.next==null){
                break;
            }else{
                temp=temp.next;
            }
        }
        //当退出while循环时，将之前链表内最后一个节点指向新添加的节点
        temp.next=node;
    }

    /**
     * 获取链表内所有节点信息(遍历)
     */
    public void getList(){
        //判断链表是否为空
        if(head.next==null){
            System.out.println("链表为空！");
            return;
        }
        //链表不为空则获取节点信息。因为head节点不能动，则需要新建临时变量来遍历数据
        HeroNode temp = head.next;
        while(true){
            //为空，则说明遍历到尾结点
            if(temp==null){
                break;
            }
            System.out.println(temp);
            //后移节点
            temp=temp.next;
        }
    }
}
