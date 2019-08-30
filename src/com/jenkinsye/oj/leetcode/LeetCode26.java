public class LeetCode26 {
    public int removeDuplicates(int[] nums) {
        if(nums.length == 0 || nums == null)
            return 0;
        int temp = nums[0];
        int index = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == temp)
                continue;
            nums[index++] = temp;
            temp = nums[i];
        }
        nums[index] = nums[nums.length-1];

        return index + 1;
    }

    public static void main(String[] args) {
        int[] nums = {};
        LeetCode26 leetCode26 = new LeetCode26();
        System.out.println(leetCode26.removeDuplicates(nums));
    }
}
