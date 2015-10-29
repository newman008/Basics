package LeetCode2;

/*
 * Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes), write a function to check whether these edges make up a valid tree.

For example:

Given n = 5 and edges = [[0, 1], [0, 2], [0, 3], [1, 4]], return true.

Given n = 5 and edges = [[0, 1], [1, 2], [2, 3], [1, 3], [1, 4]], return false.
 */

import java.util.*;

public class _261_GraphValidTree {
    
    public boolean validTree(int n, int[][] edges) {
        // Union Find
        // verify 1: there is n-1 edges; 2: acyclic; 3: connected
        int[] nums = new int[n];
        Arrays.fill(nums, -1);
        
        for(int i = 0; i < edges.length; i++) {
            int x = find(nums, edges[i][0]);
            int y = find(nums, edges[i][1]);
            
            if(x == y) return false;
            nums[x] = y;
        }
        
        return edges.length == n-1;
    }
    
    private int find(int[] nums, int i) {
        if(nums[i] == -1) return i;
        else return find(nums, nums[i]);
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
