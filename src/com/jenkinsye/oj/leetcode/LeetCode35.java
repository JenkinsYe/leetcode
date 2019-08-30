public class LeetCode35 {
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        if(nums[0] > target) return 0;
        if(nums[nums.length - 1] < target) return nums.length;
        while(left < right){
            int mid = (left + right) / 2;
            if(nums[mid] == target)
                return mid;
            else if(nums[mid] > target)
                right = mid - 1;
            else left = mid + 1;
        }
        if(nums[left] == target)
            return left;
        else if(nums[left] > target)
            return left;
        else return left + 1;
    }

    public static void main(String[] args) {
        LeetCode35 leetCode35 = new LeetCode35();
        int[] nums = {1, 3, 5, 6};
        int target = 7;
        System.out.println(leetCode35.searchInsert(nums, target));
    }
}
