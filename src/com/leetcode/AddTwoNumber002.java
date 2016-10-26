package com.leetcode;

/**
 * Created by jiping_zhou on 2016/10/22.
 *
 * You are given two linked lists representing two non-negative numbers.
 * The digits are stored in reverse order and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 *
 */

class Node{
    int data;
    Node next;
    public Node(int data){
        this.data = data;
        this.next = null;
    }
}

class LinkList{
    public Node head;
    public Node current;

    public Node add(int data){
        if(head == null){
            head = new Node(data);
            current = head;
        }else{
            current.next = new Node(data);
            current = current.next;
        }
        return head;
    }

    public void print(){
        Node c = head;
        while(c != null){
            System.out.print(c.data);
            c = c.next;
        }
    }

    public void print(Node node){
        if(node == null)
            return;
        Node c = node;
        while(c != null){
            System.out.println(c.data);
            c = c.next;
        }
    }

    public int length(){
        int i = 0;
        if(head == null)
            return i;
        Node c = head;
        while(c != null){
            i ++;
            c = c.next;
        }
        return i;
    }
}



public class AddTwoNumber002 {

    public static LinkList addTwoNumber(LinkList l1, LinkList l2){
        if(l1 == null && l2 == null) return null;
        if(l1 == null) return l2;
        if(l2 == null) return l1;

        Node h1 = l1.head, h2 = l2.head;
        LinkList ret = new LinkList();
        int carry;
        while(h1 != null & h2 != null){
            if(!(h1.data >= 0 && h1.data <=9)) {
                System.out.print("please input single digit");
                return null;
            }
            int tmp = h1.data + h2.data;
            carry = tmp/10;
            ret.add((tmp % 10) + carry);
            h1 = h1.next;
            h2 = h2.next;
        }

        while(h1 != null){
            if(!(h1.data >= 0 && h1.data <=9)) {
                System.out.print("please input single digit");
                return null;
            }
            ret.add(h1.data);
            h1 = h1.next;
        }

        while(h2 != null){
            if(!(h2.data >= 0 && h2.data <=9)) {
                System.out.print("please input single digit");
                return null;
            }
            ret.add(h2.data);
            h2 = h2.next;
        }
        return ret;
    }


    public static void main(String args[]){
        LinkList l1 = new LinkList();
        LinkList l2 = new LinkList();
        for(int i:new int[]{-1, 4, 5}){
            l1.add(i);
        }

        for(int i:new int[]{1, 1, 1, 1}){
            l2.add(i);
        }

        LinkList l = addTwoNumber(l1, l2);
        if(l != null) l.print();
    }
}
