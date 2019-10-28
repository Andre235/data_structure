package com.demo03LinkedList.singleLinkedList;


import java.util.Stack;

/**
 * @author : 赵静超
 * @date Date : 2019/10/22 21:42
 * @description :  定义单链表 管理英雄节点
 */
public class SingleLinkedList {

    //先定义一个头结点，头结点不动，不存放任何数据
    private HeroNode head = new HeroNode(0,"","");

    public HeroNode getHead() {
        return head;
    }

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
     * @return 获取链表有效节点(不含头结点)的个数
     */
    int getLength(){
        if(head.next == null){  //链表为空
            return 0;
        }
        int length = 0;
        HeroNode temp = head.next;
        while(temp != null){
            length++;
            temp = temp.next;
        }
        return length;
    }

    /**
     * [新浪面试题]
     * @param index 获取链表倒数第K个节点信息
     * @return 倒数第K个节点信息
     */
    HeroNode getInfoByIndex(int index) throws IllegalArgumentException {
        //获取链表的有效长度(不包含头结点)
        int length = getLength();
        if(index <= 0 || index > length){
            throw new IllegalArgumentException("非法参数！");
        }
        int actualIndex  = length - index;
        HeroNode temp =  head.next;
        for (int i = 0; i < actualIndex; i++) {
            temp = temp.next;
        }
        return temp;
    }

    /**
     * 反转链表 [腾讯面试题] 难度中等
     * 1、先创建一个reverseHeadNode 反转头结点
     * 2、遍历之前的链表，将其取出放到reverse链表的最前端
     */
    void reverseList(){
        //如果链表为空，或者只有一个节点则无需反转，直接返回
        if(head.next == null || head.next.next == null){
            return;
        }
        //定义一个临时节点，辅助遍历临时链表
        HeroNode cur = head.next;
        //指向当前节点cur的下一个节点
        HeroNode nextNode = null;
        //定义一个反转节点的头结点
        HeroNode reverseHead = new HeroNode(0,"","");
        while(cur != null){
            nextNode = cur.next; //先暂时保存当前节点的下一个节点
            cur.next = reverseHead.next; //让cur的下一个节点指向反转节点的最前端
            reverseHead.next = cur;
            cur = nextNode; //cur后移
        }
        head.next  = reverseHead.next;
    }

    /**
     * [百度面试题目] 逆序输出节点信息
     * 思路：利用Stack数据结构的先进后出的特性，实现逆序输出操作
     */
    void reversePrint(){
        //判断链表是否为空
        if(head.next == null){
            return;
        }
        //创建一个栈对象，利用先进后出原理实现逆序打印
        Stack<HeroNode> stack = new Stack<>();
        HeroNode temp = head.next;
        //压栈
        while (temp != null){
            stack.push(temp);
            temp = temp.next;
        }
        //出栈，逆序打印
        while(stack.size() > 0){
            System.out.println(stack.pop());
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
