package com.netpet.spools.algorithm.twosum;

/**
 * Created by woncz on 2016/10/18.
 */
public class TwoSum {
    public static void main(String[] args) {
        int[] nums = new int[] {2, 7, 11, 15};
        int target = 4;

        int[] result = new TwoSum().twosum(nums, target);
        for (int i = 0; result != null && i < result.length; i++) {
            System.out.println(result[i] + " ");
        }

    }

    public int[] twosum(int[] nums, int target) {
        int[] result = null;
        int last;
        for (int i = 0, first = i; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    last = j;
                    result = new int[] {first, last};
                }
            }
        }
        return result;
    }
}
