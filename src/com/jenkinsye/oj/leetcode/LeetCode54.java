import java.util.ArrayList;
import java.util.List;

public class LeetCode54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int height = matrix.length;
        if(height == 0) return result;
        int width = matrix[0].length;
        for(int i = 0; i <= height / 2; i++){
            if(height - 2 * i == 1){
                for(int j = i; j < width - i; j++)
                    result.add(matrix[i][j]);
                break;
            }else if(width - 2 * i == 1){
                for(int j = i; j < height - i; j++)
                    result.add(matrix[j][i]);
                break;
            }
            for(int j = i; j < width - i; j++)
                result.add(matrix[i][j]);
            for(int j = i + 1; j < height - i; j++)
                result.add(matrix[j][width - 1 - i]);
            for(int j = width - i - 2; j >= i; j--)
                result.add(matrix[height - 1 - i][j]);
            for(int j = height -i - 2; j > i; j--)
                result.add(matrix[j][i]);
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] nums = {
                {1},{2},{3},{4}
        };
        int[][] num2 = {
                {1}
        };
        LeetCode54 leetCode54 = new LeetCode54();

        System.out.println(leetCode54.spiralOrder(nums).toString());
    }
}
