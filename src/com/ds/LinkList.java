package com.ds;

/**
 * Created by jiping_zhou on 2016/10/26.
 *
 * 1、单链表的创建和遍历
 * 2、求单链表中节点的个数
 * 3、查找单链表中的倒数第k个结点（剑指offer，题15）
 * 4、查找单链表中的中间结点
 * 5、合并两个有序的单链表，合并之后的链表依然有序【出现频率高】（剑指offer，题17）
 * 6、单链表的反转【出现频率最高】（剑指offer，题16）
 * 7、从尾到头打印单链表（剑指offer，题5）
 * 8、判断单链表是否有环
 * 9、取出有环链表中，环的长度
 * 10、单链表中，取出环的起始点（剑指offer，题56）。本题需利用上面的第8题和第9题。
 * 11、判断两个单链表相交的第一个交点（剑指offer，题37）
 *
 */
class LinkList {
    class Node{
        int data;
        Node next;

        Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    Node head, current;

    public void add(int data){
        if(head == null){
            head = new Node(data);
            current = head;
        }else {
            current.next = new Node(data);
            current = current.next;
        }
    }

    public void print(){
        Node node = head;
        while(node != null){
            System.out.print(node.data);
            System.out.print("\t");
            node = node.next;
        }
    }

    public int getLength(){
        Node node = head;
        int length = 0;
        while(node != null){
            length++;
            node = node.next;
        }
        return length;
    }

    public Node findLastNodeV1(int index){
        if(index < 1) return null;
        Node node = head;
        int size = 0;
        while(node != null){
            size ++;
            node = node.next;
        }
        if(size < index) return null;

        node = head;
        for(int k=0; k < size - index; k++){
            node = node.next;
        }
        return node;
    }

    public Node findLastNodeV2(int index){
        if(index < 1 || head == null) return null;

        Node first = head;
        Node second = head;

        for(int i =0; i < index - 1; i++){
            if(second == null) return null;
            second = second.next;
        }

        while(second != null){
            second = second.next;
            if(second != null) first = first.next;
        }

        return first;
    }


    public static void main(String args[]){
        LinkList l1 = new LinkList();
        for(int i=0; i<10; i++){
            l1.add(i);
        }

        System.out.print("print = ");
        l1.print();
        System.out.printf("\ngetLength = %s\n", l1.getLength());

        for(int i=-2; i< 15; i++){
            Node node = l1.findLastNodeV1(i);
            System.out.printf("index=%s\tfindLastNodeV1=%s\n", i, (node == null)?null:node.data);

            node = l1.findLastNodeV2(i);
            System.out.printf("index=%s\tfindLastNodeV2=%s\n", i, (node == null)?null:node.data);

        }

    }
}
