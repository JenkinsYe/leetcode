import java.util.ArrayList;
import java.util.List;

public class LeetCode51 {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        boolean[] col = new boolean[n];
        boolean[] left = new boolean[2* n - 1];
        boolean[] right = new boolean[2 * n - 1];
        int[] index = new int[n];
        dfs(result, col, left, right, 0, index);
        return result;
    }

    void dfs(List<List<String>> result, boolean[] col,
             boolean[] left, boolean[] right, int num, int[] index){
        if(num == col.length){
            List<String> tempList = new ArrayList<>();
            for (int i = 0; i < index.length; i++){
                StringBuilder stringBuilder = new StringBuilder();
                for(int j = 0; j < index.length; j++) {
                    if (j != index[i])
                        stringBuilder.append('.');
                    else stringBuilder.append('Q');
                }
                tempList.add(stringBuilder.toString());
            }
            result.add(tempList);
        } else {
            for(int i = 0; i < col.length; i++){
                if(!col[i] && !left[num + i] && !right[col.length -1 -num + i]){
                    index[num] = i;
                    col[i] = true;
                    left[num + i] = true;
                    right[col.length - 1- num + i] = true;
                    dfs(result, col, left, right, num + 1, index);
                    col[i] = false;
                    left[num + i] = false;
                    right[col.length - 1 - num + i] = false;
                }
            }
        }
    }

    public static void main(String[] args) {
        LeetCode51 leetCode51 = new LeetCode51();
        System.out.println(leetCode51.solveNQueens(4).toString());
    }
}
