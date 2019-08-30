import java.lang.reflect.Array;
import java.util.Arrays;

public class LeetCode31 {
    public void nextPermutation(int[] nums) {
        int asc = -1;
        for(int index = 0; index < nums.length - 1; index++){
            if(nums[index] < nums[index+1])
                asc = index;
        }
        if(asc == -1){
            Arrays.sort(nums);
        }else{
            int index = asc;
            int min = Integer.MAX_VALUE;
            for(int i = asc + 1; i < nums.length; i++){
                if(nums[i] > nums[asc] && nums[i] < min){
                    min = nums[i];
                    index = i;
                }
            }
            int a = nums[index];
            nums[index] = nums[asc];
            nums[asc] = a;
            for(int i = asc + 1; i < nums.length; i++){
                min = nums[i];
                index = i;
                for(int j = i + 1; j < nums.length; j++){
                    if(nums[j] < min){
                        min = nums[j];
                        index = j;
                    }
                }
                a = nums[i];
                nums[i] = nums[index];
                nums[index] = a;
            }
        }

    }

    public static void main(String[] args) {
        int[] nums = {5, 4, 7, 5, 3, 2};
        LeetCode31 leetCode31 = new LeetCode31();
        leetCode31.nextPermutation(nums);
        for(int i = 0; i < nums.length; i++)
            System.out.print(nums[i] + " ");
    }
}
