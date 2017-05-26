package com.leetcode;

import com.utils.ArrayUtils;

/**
 * Created by jiping_zhou on 2016/11/22.
 * Given two sorted integer arrays nums1 and nums2,
 * merge nums2 into nums1 as one sorted array.
 * Note:
 * You may assume that nums1 has enough space (size that is greater or equal to m + n)
 * to hold additional elements from nums2.
 * The number of elements initialized in nums1 and nums2 are m and n respectively
 */
public class MergeSortedArray88 {
    /**
     * merge from back to forward
     * @param a: nums1
     * @param alength: the number of elements in array a
     * @param b: nums2
     * @param blength: the number of elements in array b
     */
    public static void mergeSortedArrayV1(int[] a, int alength, int[] b, int blength) {
        if((alength + blength) > a.length) return;
        if(alength < 0 || blength < 0) return;

        int ablength = alength + blength - 1;
        alength--;
        blength--;
        while (alength > 0 && blength > 0) {
            if (a[alength] > b[blength]) {
                a[ablength--] = a[alength--];
            } else {
                a[ablength--] = b[blength--];
            }
        }

        while (alength >= 0) {
            a[ablength--] = a[alength--];
        }

        while (blength >= 0) {
            a[ablength--] = b[blength--];
        }
    }

    public static void main(String args[]) {
        int[] nums2 = ArrayUtils.getRandomSortedArray(5);
        System.out.print("nums2:\t");
        ArrayUtils.printlnArray(nums2);
        int[] nums1 = new int[10];
        int i = 0;
        for (int num : ArrayUtils.getRandomSortedArray(0)) nums1[i++] = num;
        System.out.print("nums1:\t");
        ArrayUtils.printlnArray(nums1);
        mergeSortedArrayV1(nums1, 0, nums2, 5);
        System.out.print("nums1:\t");
        ArrayUtils.printlnArray(nums1);
    }
}
