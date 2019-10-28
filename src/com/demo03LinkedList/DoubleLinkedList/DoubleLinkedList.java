package com.demo03LinkedList.DoubleLinkedList;

/**
 * @author : zhaojingchao
 * @date : 2019/10/28
 */
public class DoubleLinkedList {

    //先定义一个头结点，头结点不动，不存放任何数据
    private HeroNode head = new HeroNode(0,"","");

    /**
     * 修改双向链表节点信息，和修改单向链表节点信息方法一样
     * @param newHeroNode 新修改的节点
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
     * 添加一个节点到双向链表的末尾
     * @param node 新添加的节点
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
        //当退出while循环时，将之前链表内最后一个节点指向新添加的节点，形成双向链表
        temp.next = node;
        node.pre = temp;
    }

    /**
     * 删除双向链表中的一个节点
     * 对于双向链表，直接找到要删除的节点，然后自身删除即可
     * @param id 要删除节点的id
     */
    void del(int id){
        if(head.next == null){
            System.out.println("当前链表为空，不能进行删除操作!");
            return;
        }
        HeroNode temp = head.next;
        boolean flag =false;     //表示有没有找到要删除节点的前一个节点，默认为false
        while (true){
            if(temp == null){      //已经遍历到链表尾部
                break;
            }
            if(temp.id == id){     //找到要删除的节点
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if(flag){       //找到要删除得节点
            temp.pre.next = temp.next;
            if(temp.next != null){   //考虑删除的节点是最后一个节点
                temp.next.pre = temp.pre;
            }
            System.out.printf("删除%d号节点成功！\n",id);
        }else{
            System.out.printf("要删除的%d节点不存在！\n",id);
        }
    }

    /**
     * 获取链表内所有节点信息(遍历)
     */
    void getList(){
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
