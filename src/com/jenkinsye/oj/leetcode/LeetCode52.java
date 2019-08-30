public class LeetCode52 {
    class Counter{
        int val = 0;
    }
    public int totalNQueens(int n) {
        Counter result = new Counter();
        boolean[] col = new boolean[n];
        boolean[] left = new boolean[2* n - 1];
        boolean[] right = new boolean[2 * n - 1];
        dfs(result, col, left, right, 0);
        return result.val;
    }

    void dfs(Counter result, boolean[] col,
             boolean[] left, boolean[] right, int num){
        if(num == col.length){
            result.val++;
        } else {
            for(int i = 0; i < col.length; i++){
                if(!col[i] && !left[num + i] && !right[col.length -1 -num + i]){
                    col[i] = true;
                    left[num + i] = true;
                    right[col.length - 1- num + i] = true;
                    dfs(result, col, left, right, num + 1);
                    col[i] = false;
                    left[num + i] = false;
                    right[col.length - 1 - num + i] = false;
                }
            }
        }
    }

    public static void main(String[] args) {
        LeetCode52 leetCode52 = new LeetCode52();
        System.out.println(leetCode52.totalNQueens(4));
    }

}
