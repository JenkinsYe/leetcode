package com.jenkinsye.oj.leetcode;

public class LeetCode91 {

    public int numDecodings(String s) {
        int[]dp=new int [s.length()];
        if(s.charAt(0)=='0')return 0;
        dp[0]=1;
        for(int i=1;i<s.length();i++){
            if(s.charAt(i-1)!='0'&&s.charAt(i)!='0'&&(s.charAt(i)-'0'+10*(s.charAt(i-1)-'0'))<=26)
                //如果新加入的一位可以和已有的最后一位结合编码 则为dp[i-1](单独编码最后一位)+dp[i-2](结合编码)
                dp[i]=i>=2?dp[i-1]+dp[i-2]:dp[i-1]+1;
            else if(s.charAt(i)!='0')
                //确认不能结合的情况下  只要最后一位不为0 就不增加编码可能
                dp[i]=dp[i-1];
            else if(s.charAt(i)=='0'&&(s.charAt(i-1)=='1'||s.charAt(i-1)=='2'))
                //新的一位为0 如果可以和最后一位结合（10， 20） 锁死了原有的最后一位的可能 等同于dp[i-2]
                dp[i]=i>=2?dp[i-2]:dp[i-1];
            else return 0;
            //其余情况无法编码
        }
        return dp[s.length()-1];
    }

    public static void main(String[] args) {
        LeetCode91 leetCode91 = new LeetCode91();
        System.out.print(leetCode91.numDecodings("110"));
    }
}
