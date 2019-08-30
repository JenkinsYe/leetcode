public class LeetCode169 {
    public int majorityElement(int[] nums) {
        int temp = nums[0];
        int count = 1;
        for(int i = 1; i< nums.length; i++){
            if(nums[i] == temp){
                count++;
            }else{
                count--;
                if(count == 0){
                    temp = nums[i + 1];
                }
            }
        }
        return temp;
    }

    public static void main(String[] args) {
        LeetCode169 leetCode169 = new LeetCode169();
        int[] nums = {2,1,3,2,2,4,6,1,2,3, 2};
        System.out.println(leetCode169.majorityElement(nums));
    }
}
