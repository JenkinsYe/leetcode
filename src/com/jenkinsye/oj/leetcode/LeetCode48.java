import java.util.Arrays;

public class LeetCode48 {
    public void rotate(int[][] matrix) {
        for(int i = 0; i< matrix.length; i++){
            for(int j = 0; j < i; j++){
                int t = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = t;
            }
        }
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix.length/2; j++){
                int t = matrix[i][j];
                matrix[i][j] = matrix[i][matrix.length -1 - j];
                matrix[i][matrix.length - 1 - j] = t;
            }
        }
    }

    public static void main(String[] args) {
        LeetCode48 leetCode48 = new LeetCode48();
        int[][] nums = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        leetCode48.rotate(nums);
        for(int i = 0; i < nums.length; i++){
            for (int j = 0; j < nums.length; j++){
                System.out.print(nums[i][j] + " ");
            }
            System.out.println();
        }
    }
}
