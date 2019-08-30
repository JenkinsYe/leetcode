public class LeetCode60 {
    public String getPermutation(int n, int k) {
        StringBuilder stringBuilder = new StringBuilder("123456789");
        StringBuilder res = new StringBuilder();
        int[] factory = new int[n];
        factory[0] = 1;
        for(int index = 1; index < n; index++) factory[index] = factory[index - 1] * index;
        k--;
        for(int i = n; i >= 1; --i){
            int j = k / factory[i - 1];
            k %= factory[i - 1];
            res.append(stringBuilder.charAt(j));
            stringBuilder.replace(j, j + 1, "");
        }

        return res.toString();
    }

    public static void main(String[] args) {
        LeetCode60 leetCode60 = new LeetCode60();
        System.out.println(leetCode60.getPermutation(3, 3));
    }
}
