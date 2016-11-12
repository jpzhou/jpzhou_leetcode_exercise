package com.ds;

/**
 * Created by jiping_zhou on 2016/11/7.
 * http://www.cnblogs.com/wzyxidian/p/5931516.html
 * 1��ջ�Ĵ���
 * 2�����еĴ���
 * 3������ջʵ��һ������
 * 4����������ʵ��һ��ջ
 * 5����ƺ���С����min()��ջ��Ҫ��min��push��pop����ʱ�临�Ӷȶ���O(1)
 * 6���ж�ջ��push��pop�����Ƿ�һ��
 *
 *
 * 1  <-- top
 * 2
 * 3
 * 4
 *
 *
 */

public class StackDemo {
    class Node {
        int data;
        Node next;
        Node (int data){
            this.data = data;
        }
    }

    public Node top;

    void push(int data){
        if(top == null){
            top = new Node(data);
        }else{
            Node node = new Node(data);
            node.next = top;
            top = node;
        }
    }

    Node pop(){
        if(top == null) return null;
        Node tmp = top;
        top = top.next;
        return tmp;
    }

    public static void main(String args[]){
        StackDemo s = new StackDemo();

        System.out.println("============= push ===============");
        for(int i=0; i<10; i++){
            s.push(i);
        }

        System.out.println("============= pop ===============");
        while(true){
            Node n = s.pop();
            if(n == null) {
                System.out.println();
                break;
            }
            System.out.printf("%d\t", n.data);
        }
    }
}

