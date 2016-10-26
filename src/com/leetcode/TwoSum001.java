package com.leetcode;

import com.sun.istack.internal.NotNull;

import java.util.HashMap;
import java.lang.Comparable;

/**
 * Created by jiping_zhou on 2016/10/22.
 *
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * You may assume that each input would have exactly one solution.
 * Example:
 * Given nums = [2, 7, 11, 15], target = 9,
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 *
 */

class Pair implements Comparable<Pair> {
    int value, index;
    public Pair(int v, int id){
        value = v;
        index = id;
    }

    @Override
    public int compareTo(@NotNull Pair p){
        return this.value - p.value;
    }
}


public class TwoSum001 {
    public static int[] twoSumV1(int[] nums, int target){
        /*
        * time complexity:O(n^2)
        * space complexity:O(1)
        */
        int[] ret = new int[2];
        for(int i=0; i < nums.length; i++){
            for(int j=i+1; j < nums.length; j++){
                if((nums[i] + nums[j]) == target){
                    ret[0] = i;
                    ret[1] = j;
                    return ret;
                }
            }
        }
        return null;
    }

    public static int[] twoSumV2(int[] nums, int target){
        /*
        * time complexity: O(nlogn),map is time consuming
        * space complexity:O(n)
        * */
        HashMap<Integer,Integer> m = new HashMap<Integer, Integer>();
        int[] ret = new int[2];
        for(int i=0; i < nums.length; i++){
            if(m.containsKey(target - nums[i])){
                ret[0] = i;
                ret[1] = m.get(target - nums[i]);
                break;
            }
            m.put(nums[i], i);
        }
        return ret;
    }

    public static int[] twoSumV3(int[] nums, int target){
        /*tow pointer*/
        Pair[] pairs = new Pair[nums.length];
        for(int i=0;i<nums.length;i++){
            pairs[i] = new Pair(nums[i], i);
        }
        java.util.Arrays.sort(pairs);

        int left = 0, right = nums.length - 1;
        int[] ret = new int[2];
        while(left < right){
            if((pairs[left].value + pairs[right].value) == target){
                ret[0] = pairs[left].index;
                ret[1] = pairs[right].index;
                return ret;
            }else if((pairs[left].value + pairs[right].value) > target){
                right--;
            }else{
                left++;
            }
        }
        return null;
    }

    public static void main(String args[]){
        int[] a = new int[]{1, 2, 3, 4};
//        int[] ret = twoSumV1(a, 3);
//        int[] ret = twoSumV2(a, 3);
        int[] ret = twoSumV3(a, 5);

        if(null == ret){
            System.out.println("NOT FIND INDICES");
        }else{
            for(int n:ret){
                System.out.println(n);
            }
        }
    }
}
