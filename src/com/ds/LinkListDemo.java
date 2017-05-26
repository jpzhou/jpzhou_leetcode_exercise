package com.ds;

/**
 * Created by jiping_zhou on 2016/10/26.
 *
 * 1��������Ĵ����ͱ���
 * 2���������нڵ�ĸ���
 * 3�����ҵ������еĵ�����k����㣨��ָoffer����15��
 * 4�����ҵ������е��м���
 * 5���ϲ���������ĵ������ϲ�֮���������Ȼ���򡾳���Ƶ�ʸߡ�����ָoffer����17��
 * 6��������ķ�ת������Ƶ����ߡ�����ָoffer����16��
 * 7����β��ͷ��ӡ��������ָoffer����5��
 * 8���жϵ������Ƿ��л�
 * 9��ȡ���л������У����ĳ���
 * 10���������У�ȡ��������ʼ�㣨��ָoffer����56������������������ĵ�8��͵�9�⡣
 * 11���ж������������ཻ�ĵ�һ�����㣨��ָoffer����37��
 *
 */
class LinkListDemo {
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
        System.out.println();
    }

    public void recursivePrint(Node head) {
        if(head == null) return;
        System.out.printf("%d\t", head.data);
        recursivePrint(head.next);
    }

    public void reversePrint(Node head){
        if (head == null) return;
        reversePrint(head.next);
        System.out.printf("%d\t", head.data);
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

    /**
     * 1 -> 2 -> 3 -> 4 -> 5
     * 1 <- 2 <- 3 <-4 <- 5
     */
    public void reverse(){
        Node curNode = head;
        Node preNode = null;
        while (curNode != null) {
            if(curNode.next == null) head = curNode;
            Node nextNode = curNode.next;
            curNode.next = preNode;
            preNode = curNode;
            curNode = nextNode;
        }
    }

    public void runPrint(){
        LinkListDemo l1 = new LinkListDemo();
        for(int i=0; i<10; i++){
            l1.add(i);
        }
        System.out.print("print = ");
        l1.print();
    }

    public void runRecursivePrint() {
        System.out.println("runRecursivePrint:");
        LinkListDemo l1 = new LinkListDemo();
        for(int i=0; i<10; i++){
            l1.add(i);
        }
        l1.recursivePrint(l1.head);
        System.out.println();
    }

    public void runGetLength(){
        LinkListDemo l1 = new LinkListDemo();
        for(int i=0; i<10; i++){
            l1.add(i);
        }
        System.out.printf("\ngetLength = %s\n", l1.getLength());
    }

    public void runFindLastNode() {
        LinkListDemo l1 = new LinkListDemo();
        for(int i=0; i<10; i++){
            l1.add(i);
        }
        for(int i=-2; i< 15; i++){
            Node node = l1.findLastNodeV1(i);
            System.out.printf("index=%s\tfindLastNodeV1=%s\n", i, (node == null)?null:node.data);

            node = l1.findLastNodeV2(i);
            System.out.printf("index=%s\tfindLastNodeV2=%s\n", i, (node == null)?null:node.data);

        }
    }

    public void runReversePrint() {
        System.out.println("runReversePrint:");
        LinkListDemo l1 = new LinkListDemo();
        for(int i=0; i<10; i++){
            l1.add(i);
        }
        l1.reversePrint(l1.head);
        System.out.println();
    }

    public void runReverse(){
        System.out.println("runReverse:");
        LinkListDemo l1 = new LinkListDemo();
        for(int i=0; i<10; i++){
            l1.add(i);
        }
        l1.print();
        l1.reverse();
        l1.print();
    }

    public static void main(String args[]){
        LinkListDemo l1 = new LinkListDemo();
//        l1.runReversePrint();
//        l1.runRecursivePrint();
        l1.runReverse();
    }
}
