import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class LeetCode46 {
    public List<List<Integer>> permute(int[] nums) {
        HashSet<Integer> hashSet = new HashSet<>();
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        dfs(result, hashSet, temp, nums);
        return result;
    }

    void dfs(List<List<Integer>> result, HashSet<Integer> hashSet,
             List<Integer> temp,int[] nums){
        if(hashSet.size() == nums.length){
            List<Integer> newList = new ArrayList<>(temp);
            result.add(newList);
        } else {
            for(int index = 0; index < nums.length; index++){
                if(!hashSet.contains(index)){
                    temp.add(nums[index]);
                    hashSet.add(index);
                    dfs(result, hashSet, temp, nums);
                    temp.remove(temp.size() - 1);
                    hashSet.remove(index);
                }
            }
        }

    }

    public static void main(String[] args) {
        LeetCode46 leetCode46 = new LeetCode46();
        int[] nums={1, 2, 3};
        System.out.println(leetCode46.permute(nums));
    }
}
