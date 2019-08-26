package com.jenkinsye.oj.leetcode;

public class LeetCode81 {
    public boolean search(int[] nums, int target) {
        return binarySearch(nums, target, 0, nums.length - 1) > -1 ? true : false;
    }

    public int binarySearch(int[] nums, int target, int low, int high) {
        if (low > high)
            return -1;
        int mid = (low + high) / 2;
        if (nums[mid] == target)
            return mid;
        if (nums[mid] == nums[high])
            return binarySearch(nums, target, low, high - 1);
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
        int[] nums = new int[]{1, 1, 3, 1};
        int target = 3;
        LeetCode81 leetCode81 = new LeetCode81();
        System.out.println(leetCode81.search(nums, target));
    }
}
