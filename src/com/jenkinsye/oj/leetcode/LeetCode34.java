public class LeetCode34 {
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        result[0] = result[1] = -1;
        int left = 0;
        int right = nums.length - 1;
        while(left <= right){
            int mid = (left + right) / 2;
            if( nums[mid] == target && (mid == nums.length - 1 || nums[mid + 1] != target)){
                result[1] = mid;
                break;
            } else if(nums[mid] > target)
                right = mid - 1;
            else left = mid + 1;
        }

        left = 0;
        right = nums.length - 1;
        while (left <= right){
            int mid = (left + right) / 2;
            if(nums[mid] == target && (mid == 0 || nums[mid - 1] != target)){
                result[0] = mid;
                break;
            }else if(nums[mid] >= target)
                right = mid - 1;
            else left = mid + 1;
        }

        return result;
    }

    public static void main(String[] args) {
        LeetCode34 leetCode34 = new LeetCode34();
        int[] nums = {5, 7, 7, 8, 8, 10};
        int target = 1;
        System.out.println(leetCode34.searchRange(nums, target)[0] + " " + leetCode34.searchRange(nums, target)[1]);
    }
}
