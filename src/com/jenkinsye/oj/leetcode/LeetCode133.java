package com.jenkinsye.oj.leetcode;

import com.jenkinsye.oj.leetcode.util.GraphNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LeetCode133 {
    HashMap<GraphNode, GraphNode> map = new HashMap<>();

    public GraphNode cloneGraph(GraphNode node) {
        if (node == null)
            return null;
        GraphNode result = new GraphNode(node.val, new ArrayList<>());
        map.put(node, result);
        for (GraphNode graphNode : node.neighbors) {
            if(map.containsKey(graphNode)) {
                result.neighbors.add(map.get(graphNode));
            } else {
                result.neighbors.add(cloneGraph(graphNode));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        GraphNode node1 = new GraphNode(1, null);
        GraphNode node2 = new GraphNode(2, null);
        GraphNode node3 = new GraphNode(3, null);
        GraphNode node4 = new GraphNode(4, null);
        List<GraphNode> neighbor1, neighbor2, neighbor3, neighbor4;
        neighbor1 = new ArrayList<>();
        neighbor2 = new ArrayList<>();
        neighbor3 = new ArrayList<>();
        neighbor4 = new ArrayList<>();
        neighbor1.add(node2);
        neighbor1.add(node4);
        neighbor2.add(node1);
        neighbor2.add(node3);
        neighbor3.add(node2);
        neighbor3.add(node4);
        neighbor4.add(node1);
        neighbor4.add(node3);
        node1.neighbors = neighbor1;
        node2.neighbors = neighbor2;
        node3.neighbors = neighbor3;
        node4.neighbors = neighbor4;
        GraphNode result = new LeetCode133().cloneGraph(node1);
        System.out.println(result.neighbors.get(0).val + " " + result.neighbors.get(1).val);
    }
}
