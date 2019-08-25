package com.jenkinsye.oj.leetcode;

public class LeetCode33 {
    public int search(int[] nums, int target) {
        return binarySearch(nums, target, 0, nums.length - 1);
    }

    public int binarySearch(int[] nums, int target, int low, int high) {
        if (low > high)
            return -1;
        int mid = (low + high) / 2;
        if (nums[mid] == target)
            return mid;
        if (nums[mid] < nums[high]) {
            if (nums[mid] < target && nums[high] >= target) {
                return binarySearch(nums, target, mid + 1, high);
            } else
            return binarySearch(nums, target, low, mid - 1);
        }
        if (target >= nums[low] && target < nums[mid]) {
            return binarySearch(nums, target, low, mid - 1);
        } else {
            return binarySearch(nums, target, mid + 1, high);
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{4, 5, 6,7,8,1,2,3};
        int target = 8;
        System.out.println(new LeetCode33().search(nums, target));
    }
}
