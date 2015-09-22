package LeetCode2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

public class _133_CloneGraphg {
	class UndirectedGraphNode {
		int label;
 		List<UndirectedGraphNode> neighbors;
		UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
	};
	
	// DFS recursive
	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node == null) return null;
        
        HashMap<Integer, UndirectedGraphNode> map = new HashMap<Integer, UndirectedGraphNode>();
        UndirectedGraphNode cloneNode = new UndirectedGraphNode(node.label);
        
        map.put(node.label, cloneNode);
        dfs(map, node);
        
        return cloneNode;
    }
    
    public void dfs(HashMap<Integer, UndirectedGraphNode> map, UndirectedGraphNode node) {
        if(node == null) return;
        
        for(UndirectedGraphNode neighbor : node.neighbors) {
            if(!map.containsKey(neighbor.label)) {
                UndirectedGraphNode newNeighbor = new UndirectedGraphNode(neighbor.label);
                map.put(neighbor.label, newNeighbor);
                dfs(map, neighbor);
            }
            map.get(node.label).neighbors.add(map.get(neighbor.label));
        }
    }
    
    // DFS non-recursive
    public UndirectedGraphNode cloneGraph3(UndirectedGraphNode node) {
        if(node == null) return null;
        
        Map<Integer, UndirectedGraphNode> map = new HashMap<Integer, UndirectedGraphNode>();
        UndirectedGraphNode cloneNode = new UndirectedGraphNode(node.label);
        map.put(node.label, cloneNode);
        
        Stack<UndirectedGraphNode> s = new Stack<UndirectedGraphNode>();
        s.push(node);
        
        while(!s.isEmpty()){
            UndirectedGraphNode cur = s.pop();
            for(UndirectedGraphNode neighbor : cur.neighbors) {
                if(!map.containsKey(neighbor.label)) {
                    UndirectedGraphNode newNeighbor = new UndirectedGraphNode(neighbor.label);
                    map.put(neighbor.label, newNeighbor);
                    s.push(neighbor);
                }
                map.get(cur.label).neighbors.add(map.get(neighbor.label));
            }
        }
        
        
        return cloneNode;
    }
    
    // BFS non-recursive
    public UndirectedGraphNode cloneGraph2(UndirectedGraphNode node) {
        if(node == null) return null;
        
        Queue<UndirectedGraphNode> q = new LinkedList<UndirectedGraphNode>();
        Map<Integer, UndirectedGraphNode> map = new HashMap<Integer, UndirectedGraphNode>();
        
        UndirectedGraphNode cloneNode = new UndirectedGraphNode(node.label);
        map.put(node.label, cloneNode);
        q.offer(node);
        
        while(!q.isEmpty()) {
            UndirectedGraphNode cur = q.poll();
            for(UndirectedGraphNode neighbor : cur.neighbors) {
                if(!map.containsKey(neighbor.label)) {
                    UndirectedGraphNode newNeighbor = new UndirectedGraphNode(neighbor.label);
                    map.put(neighbor.label, newNeighbor);
                    q.offer(neighbor);
                }
                map.get(cur.label).neighbors.add(map.get(neighbor.label));
            }
        }
        
        return cloneNode;
    }
}
