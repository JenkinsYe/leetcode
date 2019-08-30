public class LeetCode55 {
    public boolean canJump(int[] nums) {
        if(nums.length == 0 || nums == null)
            return false;
        int n = 1;
        for(int index = nums.length -2 ; index >=0; index--){
            if(nums[index] >=n){
                n = 1;
            }else {
                n++;
            }
        }
        if(n > 1)
            return false;
        else return true;
    }

    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4};
        LeetCode55 leetCode55 = new LeetCode55();
        System.out.println(leetCode55.canJump(nums));
    }
}
