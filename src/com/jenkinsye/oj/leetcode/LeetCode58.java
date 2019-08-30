public class LeetCode58 {
    public int lengthOfLastWord(String s) {
        if(!s.contains(" ")){
            if(s.length() != 0)
                return s.length();
            else return 0;
        }
        String[] strings = s.split(" ");
        if(strings.length >= 1)
        return strings[strings.length -1].length();
        else  return 0;
    }

    public static void main(String[] args) {
        LeetCode58 leetCode58 = new LeetCode58();
        String s = "a";
        System.out.println(leetCode58.lengthOfLastWord(s));
    }
}
