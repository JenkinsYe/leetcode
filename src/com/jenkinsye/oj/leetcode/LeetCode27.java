public class LeetCode27 {
    public int removeElement(int[] nums, int val) {
        if(nums.length == 0 || nums == null)
            return 0;
        int temp = 0;
        for(int index = 0; index < nums.length; index++){
            if (nums[index] != val)
                nums[temp++] = nums[index];
        }

        return temp;
    }

    public static void main(String[] args) {
        LeetCode27 leetCode27 = new LeetCode27();
        int[] nums = {3, 2, 2, 3, 2, 3, 4};
        System.out.println(leetCode27.removeElement(nums, 3));
    }
}
