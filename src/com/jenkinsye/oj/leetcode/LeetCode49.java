import java.util.*;

public class LeetCode49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs.length == 0)
            return new ArrayList<>();
        Map<String, List<String>> hashmap = new HashMap<>();

        for(int i = 0; i < strs.length; i++){
            char[] temp = strs[i].toCharArray();
            Arrays.sort(temp);
            String key = String.valueOf(temp);
            if(!hashmap.containsKey(key)){
                hashmap.put(key, new ArrayList<>());
            }
            hashmap.get(key).add(strs[i]);
        }

        return new ArrayList<>(hashmap.values());
    }

    public static void main(String[] args) {
        String[] strings = {
                "eat", "tea", "tan", "ate", "nat", "bat"
        };
        LeetCode49 leetCode49 = new LeetCode49();
        System.out.println(leetCode49.groupAnagrams(strings).toString());
    }
}
