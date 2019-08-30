public class LeetCode14 {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0) return "";
        String result = "";
        String string = strs[0];
        for(int i = 0; i < string.length(); i++){
            boolean bool = true;
            String prefix = string.substring(0, i+1);
            for(int j = 1; j < strs.length; j++){
                if(strs[j].startsWith(prefix)){
                    bool = false;
                    break;
                }
            }
            if(bool){
                result = prefix;
            } else{
                break;
            }
        }
        return result;
    }

    public static void main(String[] args){
        String[] arr = {"flower","flow","flight"};
        LeetCode14 leetCode14 = new LeetCode14();
        System.out.println(leetCode14.longestCommonPrefix(arr));
    }
}
