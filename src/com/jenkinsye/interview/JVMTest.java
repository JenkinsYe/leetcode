package com.jenkinsye.interview;

import com.jenkinsye.oj.leetcode.util.ListNode;

public class JVMTest {
    public static void main(String[] args) {
        ListNode[] nodes = new ListNode[100];
        for (int i = 0; i < 100; i++) {
            System.out.println("-------------");
            System.out.println("i = " + i);
            nodes[i] = new ListNode(i);

            Runtime run = Runtime.getRuntime();
            long max = run.maxMemory();
            long total = run.totalMemory();
            long free = run.freeMemory();
            long usable = max - total + free;
            System.out.println("最大内存 = " + max);
            System.out.println("已分配内存 = " + total);
            System.out.println("已分配内存中的剩余空间 = " + free);
            System.out.println("最大可用内存 = " + usable);

            System.out.println("-------------");
        }
    }
}
