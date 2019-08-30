public class LeetCode53 {
    public int maxSubArray(int[] nums) {
        int sum, max;
        max = Integer.MIN_VALUE;
        sum = 0;
        for(int index = 0; index < nums.length; index++){
            sum += nums[index];
            if(sum > max)
                max = sum;
            if(sum < 0)
                sum = 0;
        }

        return max;
    }

    public static void main(String[] args) {
        LeetCode53 leetCode53 = new LeetCode53();
        int[] nums = {-2};
        System.out.println(leetCode53.maxSubArray(nums));
    }
}
