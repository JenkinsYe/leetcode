public class LeetCode38 {
    public String countAndSay(int n) {
        switch (n){
            case 1: return "1";
            case 2: return "11";
            case 3: return "21";
            case 4: return "1211";
            case 5: return "111221";
        }
        StringBuilder s = new StringBuilder("111221");
        for(int i = 6; i <= n; i++){
            StringBuilder temp = new StringBuilder();
            char c = s.charAt(0);
            int count = 0;
            for(int j = 0; j < s.length(); j++){
                if(c == s.charAt(j)){
                    count++;
                }else {
                    temp.append(count);
                    temp.append(c);
                    c = s.charAt(j);
                    count = 1;
                }
            }
            temp.append(count);
            temp.append(c);
            s = temp;
        }
        return s.toString();
    }

    public static void main(String[] args) {
        LeetCode38 leetCode38 = new LeetCode38();

        System.out.println(leetCode38.countAndSay(7));
    }
}
