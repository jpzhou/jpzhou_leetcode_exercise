package com.ds;

import com.utils.ArrayUtils;
import java.util.Arrays;

/**
 * Created by jiping_zhou on 2016/11/15.
 */


public class SearchDemo {

    /**
     *
     * @param sortData: sorted Array
     * @param start: start index
     * @param end: end index
     * @param findValue:
     * @return the index of value, from 0 to sortData.length - 1, if not find return -1
     */
    public int binarySearchRecursive(int[] sortData, int start, int end, int findValue) {
        if (sortData == null) return -1;
        if (start < 0 || end < 0 || start > end || end > sortData.length -1) return -1;

        int middle = (start + end)/2;

        if (sortData[middle] > findValue){
            return binarySearchRecursive(sortData, start, middle - 1, findValue);
        }else if (sortData[middle] < findValue) {
            return binarySearchRecursive(sortData, middle + 1, end, findValue);
        }else {
            return middle;
        }
    }

    /**
     *
     * @param sortData: sorted Array
     * @param findValue:
     * @return the index of value, from 0 to sortData.length - 1, if not find return -1
     */
    public int binarySearchLoop(int[] sortData, int findValue) {
        if (sortData == null) return -1;

        int low = 0;
        int high = sortData.length - 1;

        while (low <= high) {
            int middle = (low + high)/2;

            if (sortData[middle] > findValue){
                high = middle - 1;
            }else if(sortData[middle] < findValue){
                low = middle + 1;
            }else {
                return middle;
            }
        }

        return -1;
    }

    public void runBinarySearchLoop() {
        System.out.println("===============start runBinarySearchLoop====================");
        for (int i=0; i < 10; i++){
            int[] sortData = ArrayUtils.getRandomArray(10);
            Arrays.sort(sortData);
            ArrayUtils.printlnArray(sortData);
            System.out.print(binarySearchLoop(sortData, 10));
            System.out.println();
        }
        System.out.println("===============end runBinarySearchLoop====================");
    }

    public void runBinarySearchRecursive() {
        System.out.println("===============start runBinarySearchRecursive====================");
        for (int i=0; i < 10; i++){
            int[] sortData = ArrayUtils.getRandomArray(10);
            Arrays.sort(sortData);
            ArrayUtils.printlnArray(sortData);
            System.out.print(binarySearchRecursive(sortData, 0, sortData.length, 10));
            System.out.println();
        }
        System.out.println("===============end runBinarySearchRecursive====================");
    }


    public static void main(String args[]) {
        SearchDemo sd = new SearchDemo();
        sd.runBinarySearchLoop();
        sd.runBinarySearchRecursive();
    }
}
