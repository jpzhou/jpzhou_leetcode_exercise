package com.leetcode;

/**
 * Created by jiping_zhou on 2016/10/31.
 *
 * You are climbing a stair case. It takes n steps to reach to the top.
 * Each time you can either climb 1 or 2 steps.
 * In how many distinct ways can you climb to the top?
 *
 */
public class ClimbingStairs70 {
    public static int climbingStairsV1(int stairsNum){
        if(stairsNum <= 0) return 0;
        if(stairsNum == 1) return 1;
        if(stairsNum == 2) return 2;
        return climbingStairsV1(stairsNum - 1) + climbingStairsV1(stairsNum - 2);
    }

    public static int climbingStairsV2(int stairsNum){
        if(stairsNum <= 0) return 0;
        int oneStairs = 1, twoStairs = 2;
        if(stairsNum == 1) return oneStairs;
        if(stairsNum == 2) return twoStairs;
        int allStairs = 0;
        for(int i=3; i<stairsNum+1;i++){
            allStairs = oneStairs + twoStairs;
            oneStairs = twoStairs;
            twoStairs = allStairs;
        }
        return allStairs;
    }

    public static void main(String args[]){
        for(int i=-2; i< 20; i++){
            System.out.printf("climbingStairsV1(%d)=%s\tclimbingStairsV2(%d)=%s\n", i, climbingStairsV1(i),
                    i, climbingStairsV2(i));
        }
    }
}
