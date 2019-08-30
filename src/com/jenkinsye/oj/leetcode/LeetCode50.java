public class LeetCode50 {
    public double myPow(double x, int n) {
        double res = 1.0;
        int i = n;
        while(i != 0){
            if(i % 2 != 0){
                res *= x;
            }
            x *= x;
            i /=2;
        }
        return n<0? 1 / res : res;
    }

    public static void main(String[] args) {
        double x = 2.000000;
        int n = -3;
        LeetCode50 leetCode50 = new LeetCode50();
        System.out.println(leetCode50.myPow(x, n));
    }
}
