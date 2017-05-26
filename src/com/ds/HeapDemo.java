package com.ds;

import java.util.ArrayList;

/**
 * Created by jiping_zhou on 2016/11/11.
 * http://www.cnblogs.com/coderworld/p/datastructure-heap.html
 * https://my.oschina.net/BreathL/blog/71602
 * http://blog.csdn.net/morewindows/article/details/6709644/
 *
 * ����ѣ����������ʵ���ȫ������������ڵ�X��������Ĺؼ��ִ��ڻ������XΪ���������е����нڵ������Ĺؼ���
 */

public class HeapDemo {
    ArrayList<Integer> item;
    public HeapDemo(int size) {
        item = new ArrayList<>(size);
    }

    public void minHeapAdd(int number) {
        item.add(number);
        minHeadFixUp(item.size() - 1);
    }

    public void minHeadFixUp(int index) {
        int current = item.get(index);
        while(index >= 0){
            int pIndex = (index - 1)/2;
            int parent = item.get(pIndex);
            if (current < parent) {
                item.set(pIndex, current);
                item.set(index, parent);
                index = pIndex;
            }else{
                break;
            }
        }
    }

    public void runMinHeadAdd(){
        int[] a = {1, 9, 10, 5, 6, 7, 9};
        for(int i: a){
            minHeapAdd(i);
        }
    }

    public static void main(String args[]){
        HeapDemo h = new HeapDemo(5);
        h.runMinHeadAdd();
        System.out.println(h.item);
    }
}
