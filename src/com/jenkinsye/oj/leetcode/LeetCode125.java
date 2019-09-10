package com.jenkinsye.oj.leetcode;

import java.util.PriorityQueue;

public class LeetCode125 {
    public boolean isPalindrome(String s) {
        if (s == null || s.equals("")) {
            return true;
        }
        int l = 0;
        int r = s.length() - 1;
        while (l <= r) {
            if (!legal(s.charAt(l))) {
                l++;
                continue;
            }
            if (!legal(s.charAt(r))) {
                r--;
                continue;
            }
            if (!same(s.charAt(l), s.charAt(r)))
                return false;
            l++;
            r--;
        }
        return true;
    }

    public boolean same(char a, char b) {
        if ('0' <= a && a <= '9') {
            return a == b;
        }
        if (a >= 'a' && a <= 'z') {
            a += 'A' - 'a';
        }
        if (b >= 'a' && b <= 'z') {
            b += 'A' - 'a';
        }
        return a == b;
    }

    public boolean legal(char c) {
        if (c >= '0' && c <= '9')
            return true;
        if (c >= 'a' && c <= 'z')
            return true;
        if (c >= 'A' && c <= 'Z')
            return true;
        return false;
    }

    public static void main(String[] args) {

        String s = "A man, a plan, a canal: Panama";
        System.out.println(new LeetCode125().isPalindrome(s));
    }
}
