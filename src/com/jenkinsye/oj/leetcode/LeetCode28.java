public class LeetCode28 {
    public int strStr(String haystack, String needle) {

        return haystack.indexOf(needle);
    }

    public static void main(String[] args) {
        String haystack = "hello";
        String needle = "";
        LeetCode28 leetCode28 = new LeetCode28();
        System.out.println(leetCode28.strStr(haystack, needle));
    }
}
