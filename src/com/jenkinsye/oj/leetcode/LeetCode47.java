import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode47 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(result, nums, 1);
        return result;
    }

    void dfs(List<List<Integer>> result, int[] nums, int N){
        if(N == nums.length){
            List newList = Arrays.asList(nums);
            //System.out.println(newList);
            result.add(newList);
        } else{
            for(int index = N; index < nums.length; index++){
                if(nums[N] != nums[index]){
                    swap(nums, N, index);
                    dfs(result, nums, N + 1);
                    swap(nums, N, index);
                }
            }
        }
    }

    void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        LeetCode47 leetCode47 = new LeetCode47();
        int[] nums = {1, 1, 2};
        System.out.println(leetCode47.permuteUnique(nums));
    }
}
