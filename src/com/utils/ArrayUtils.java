package com.utils;

import java.util.Arrays;
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
    public static int[] getRandomArray(int elementNum) {
        int[] numbers = new int[elementNum];
        Random ra = new Random();
        for (int i = 0; i < elementNum; i++) {
            numbers[i] = ra.nextInt(elementNum + 10) + 1;
        }
        return numbers;
    }

    public static int[] getRandomSortedArray(int elementNum) {
        int[] numbers = new int[elementNum];
        Random ra = new Random();
        for (int i = 0; i < elementNum; i++) {
            numbers[i] = ra.nextInt(elementNum + 10) + 1;
        }
        Arrays.sort(numbers);
        return numbers;
    }

}
