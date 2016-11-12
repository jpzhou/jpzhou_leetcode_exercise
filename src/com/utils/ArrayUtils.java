package com.utils;

import java.util.Random;

/**
 * Created by jiping_zhou on 2016/11/11.
 */
public class ArrayUtils {
    /**
     *
     * @param Array: input array of integer
     */
    public static void printlnArray(int[] Array){
        if(Array == null) return;

        for (int num : Array) {
            System.out.printf("%d\t", num);
        }
        System.out.println();
    }

    /**
     *
     * @param Array
     * @param srcIndex
     * @param destIndex
     */
    public static void swap(int[] Array, int srcIndex, int destIndex){
        if (Array == null) return;
        if (srcIndex > Array.length - 1 || destIndex > Array.length - 1) return;
        int temp = Array[srcIndex];
        Array[srcIndex] = Array[destIndex];
        Array[destIndex] = temp;
    }

    /**
     *
     * @return int []
     */
    public static int[] getRandomArray() {
        int[] numbers = new int[10];
        Random ra = new Random();
        for (int i = 0; i < 10; i++) {
            numbers[i] = ra.nextInt(20) + 1;
        }
        return numbers;
    }

}
