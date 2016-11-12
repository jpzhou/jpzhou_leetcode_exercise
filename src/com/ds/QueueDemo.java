package com.ds;

/**
 * Created by jiping_zhou on 2016/11/8.
 * 1.队列的创建
 *
 *
 *
 *
 *   1  <- current
 *   2
 *   3
 *   4  <- head
 */
public class QueueDemo {
    class Node{
        int data;
        Node pre;

        public Node(int data){
            this.data = data;
        }
    }

    private Node head;
    private Node current;

    void add(int data){
        if(head == null){
            head = new Node(data);
            current = head;
        }else{
            Node node = new Node(data);
            current.pre = node;
            current = node;
        }
    }

    Node pop(){
        if(head == null) return null;
        Node node = head;
        head = head.pre;
        return node;
    }

    public static void main(String args[]){
        QueueDemo queue = new  QueueDemo();
        for(int i=0; i<10; i++){
            queue.add(i);
        }

        while(true){
            Node node = queue.pop();
            if(node == null){
                System.out.println();
                break;
            }
            System.out.printf("%s\t", node.data);
        }
    }
}



