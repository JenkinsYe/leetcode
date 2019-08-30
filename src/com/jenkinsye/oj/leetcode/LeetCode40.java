import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode40 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
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
            if(candidates[i] == candidates[i + 1])
                continue;
            List<Integer> newList = new ArrayList<>(list);
            newList.add(candidates[i]);
            findCandidates(result, newList, candidates, target - candidates[i], i + 1);
        }
    }

    public static void main(String[] args) {
        LeetCode40 leetCode40 = new LeetCode40();
        int[] nums = {10, 1, 2, 7, 6, 1, 5};
        int target = 8;
        System.out.println(Arrays.asList(leetCode40.combinationSum2(nums, target)));
    }
}
