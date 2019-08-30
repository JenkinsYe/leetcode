public class LeetCode43 {
    public String multiply(String num1, String num2) {
        StringBuilder sum = new StringBuilder();
        if(num1.length() < num2.length()){
            String t = num1;
            num1 = num2;
            num2 = t;
        }
        sum.append('0');
        for(int i = num2.length() - 1; i >= 0; i--){
            StringBuilder temp = new StringBuilder();
            if(num2.charAt(i) == '0') continue;
            for(int j = i; j < num2.length() - 1; j++)
                temp.append('0');
            char digit = num2.charAt(i);
            int carryout = 0;
            for(int j = num1.length() - 1; j >=0; j--){
                int count = (digit - '0') * (num1.charAt(j) - '0') + carryout;
                carryout = count / 10;
                temp.append((char)(count % 10 + '0'));
            }
            if(carryout != 0)
                temp.append((char)(carryout + '0'));

            sum = add(sum, temp);
        }

        return sum.reverse().toString();
    }

    public StringBuilder add(StringBuilder s1, StringBuilder s2){
        if(s1.length() < s2.length()){
            StringBuilder t = s1;
            s1 = s2;
            s2 = t;
        }
        int carryout = 0;
        StringBuilder newString = new StringBuilder();
        for(int i = 0; i < s2.length(); i++){
            int count = (s1.charAt(i) - '0') + (s2.charAt(i) - '0') + carryout;
            newString.append((char)(count % 10 + '0'));
            carryout = count / 10;
        }
        for(int i = s2.length(); i < s1.length(); i++){
            int count = s1.charAt(i) - '0' + carryout;
            newString.append((char)(count % 10 + '0'));
            carryout = count / 10;
        }
        if(carryout != 0) newString.append('1');

        return newString;
    }

    public static void main(String[] args) {
        LeetCode43 leetCode43 = new LeetCode43();
        System.out.println(leetCode43.multiply("140", "721"));
        //System.out.println(leetCode43.add(new StringBuilder("0492"), new StringBuilder("00089")));
    }
}
