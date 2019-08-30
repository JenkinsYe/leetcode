import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        Arrays.sort(candidates);
        findCandidates(result, list, candidates, target, 0);
        return result;
    }

    public void findCandidates(List<List<Integer>> result, List<Integer> list,
                              int[] candidates, int target, int index){
        if(target == 0){
            result.add(list);
            return;
        }
        if(target < candidates[0])
            return;

        for(int i = index; i < candidates.length && target >= candidates[i]; i++){
            List<Integer> newList = new ArrayList<>(list);
            newList.add(candidates[i]);
            findCandidates(result, newList, candidates, target - candidates[i], i);
        }
    }

    public static void main(String[] args) {
        LeetCode39 leetCode39 = new LeetCode39();
        int[] nums = {2, 3, 6, 7};
        int target = 7;
        System.out.println(Arrays.asList(leetCode39.combinationSum(nums, target)));
    }
}
