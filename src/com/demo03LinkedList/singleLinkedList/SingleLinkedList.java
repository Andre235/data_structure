package com.demo03LinkedList.singleLinkedList;

import org.w3c.dom.html.HTMLTableRowElement;

/**
 * @author : 赵静超
 * @date Date : 2019/10/22 21:42
 * @description :  定义单链表 管理英雄节点
 */
public class SingleLinkedList {

    //先定义一个头结点，头结点不动，不存放任何数据
    private HeroNode head = new HeroNode(0,"","");

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
     * 根据节点的编号添加到链表的指定位置，如果有该编号则抛出异常
     * @param node
     */
    public void addByOrder(HeroNode node){
        //因为头结点不能动，因此需要建立临时节点，来帮助我们找到添加的位置(插入位置的前一个节点)
        HeroNode temp = head;
        //建立flag表示添加的节点在原链表中是否存在，默认不存在 false
        boolean flag = false;
        while(true){
            //temp节点已经移动到链表的最后
            if(temp.next==null){
                break;
            }
            //已经找到插入的位置，就在temp的后面插入节点即可
            if(temp.next.id>node.id){
                break;
            }else if(temp.next.id == node.id){ //新插入的节点在原单链表中已经存在
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if(flag){
            System.out.printf("您要插入的%d号节点已经存在于链表中\n",node.id);
            return ;
        }else{
            node.next = temp.next;
            temp.next = node;
        }
    }

    /**
     * 根据ID删除节点
     * 建立临时节点temp指向要删除节点的前一个节点
     * @param id
     */
    void del(int id){
        if(head.next == null){
            System.out.println("当前链表为空，不能进行删除操作!");
            return;
        }
        HeroNode temp = head;
        boolean flag =false;     //表示有没有找到要删除节点的前一个节点，默认为false
        while (true){
            if(temp.next == null){      //已经遍历到链表尾部
                break;
            }
            if(temp.next.id == id){     //找到要删除的节点
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if(flag){       //找到要删除得节点
            temp.next = temp.next.next;
            System.out.printf("删除%d号节点成功！\n",id);
        }else{
            System.out.printf("要删除的%d节点不存在！\n",id);
        }
    }

    /**
     * 根据新节点id来修改找原节点，修改其信息
     * @param newHeroNode
     */
    public void update(HeroNode newHeroNode){
        //判断链表是否为空
        if(head.next == null){
            System.out.println("链表为空，不能进行修改操作！");
            return;
        }
        HeroNode temp = head.next;
        boolean flag = false;   //表示是否找到该节点
        while (true){
            if(temp == null){    //遍历到链表结尾
                break;
            }
            if(newHeroNode.id == temp.id){     //找到要修改的节点
                flag =true;
                break;
            }
            temp = temp.next;
        }
        //判断是否找到了需要修改的节点
        if(flag){
            temp.name = newHeroNode.name;
            temp.company = newHeroNode.company;
        }else{
            System.out.printf("没有找到编号为%d的节点，不能进行修改",newHeroNode.id);
        }
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
