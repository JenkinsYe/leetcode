public class LeetCode59 {
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        int pace = 1;
        int state = 1; //1 for right, 2 for down, 3 for left, 4 for down
        int i, j;
        i = j =0;
        while(pace <= n*n){
            result[i][j] = pace;
            pace++;
            if(state == 1){
                if(j == n - 1 || result[i][j+1] != 0){
                    i = i + 1;
                    state = 2;
                } else {
                    j++;
                }
            }else if(state == 2){
                if(i == n - 1 || result[i+1][j] != 0){
                    j = j - 1;
                    state = 3;
                }else {
                    i++;
                }
            }else if(state == 3){
                if(j == 0 || result[i][j-1] != 0){
                    i = i - 1;
                    state =4;
                }else{
                    j--;
                }
            }else{
                if(i == 0 || result[i-1][j] !=0){
                    j = j +1;
                    state = 1;
                }else{
                    i--;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        LeetCode59 leetCode59 = new LeetCode59();
        int n = 1;
        int[][] result = leetCode59.generateMatrix(n);
        for(int i = 0; i < n; i++){
            for(int j =0; j<n; j++){
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }
}
