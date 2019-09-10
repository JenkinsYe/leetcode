package com.jenkinsye.oj.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class LeetCode127 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (wordList == null || wordList.size() == 0)
            return 0;
        HashSet<String> dict = new HashSet<>(wordList);
        HashSet<String> start = new HashSet<>();
        HashSet<String> end = new HashSet<>();
        start.add(beginWord);
        end.add(endWord);
        if (!dict.contains(end))
            return 0;
        return bfs(start, end, dict, 2);
    }

    public int bfs(HashSet<String> start, HashSet<String> end, HashSet<String> dict, int length) {
        if (start.size() == 0)
            return 0;
        if (start.size() > end.size())
            return bfs(end, start, dict, length);
        HashSet<String> next = new HashSet<>();
        dict.removeAll(start);
        for (String s : start) {
            char[] chars = s.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                char temp = chars[i];
                for (char c = 'a'; c <= 'z'; c++) {
                    chars[i] = c;
                    String nStr = new String(chars);
                    if (end.contains(nStr)) {
                        return length;
                    }
                    if (dict.contains(nStr)) {
                        next.add(nStr);
                    }
                }
                chars[i] = temp;
            }
        }
        return bfs(next, end, dict, length + 1);
    }

    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        String[] wordList = new String[]{"hot","dot","dog","lot","log"};
        System.out.println(new LeetCode127().ladderLength(beginWord, endWord, Arrays.asList(wordList)));
    }
}
