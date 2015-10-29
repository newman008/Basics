package Amazon;

import java.util.*;

class Graph {
    private int V;
    private int E;
//  private List<UndirectedGraphNode>[] adj;
    public Graph(int V) {
        this.V = V;
        E = 0;
        for(int i = 0; i < V; i++) {
            UndirectedGraphNode node = new UndirectedGraphNode(i);
        }
    }
    public int V() {
        return V;
    }
    public int E() {
        return E;
    }
    public void addEdge(UndirectedGraphNode a, UndirectedGraphNode b) {
        E++;
        a.neighbors.add(b);
        b.neighbors.add(a);
    }
}

class UndirectedGraphNode {
     int label;
     List<UndirectedGraphNode> neighbors;
     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
}

public class NodeWithSameDistance {
    
    
    
    public List<UndirectedGraphNode> nodesWithSameDis(UndirectedGraphNode source, int distance) {
        List<UndirectedGraphNode> res = new ArrayList<UndirectedGraphNode>();
        Queue<UndirectedGraphNode> q = new LinkedList<UndirectedGraphNode>();
        q.offer(source);
        if(distance == 0) {
            res.add(source);
            return res;
        }
        
        while(!q.isEmpty()) {
            
            distance--;
            if(distance == 0) {
                for(int i = 0; i < q.size(); i++) {
                    UndirectedGraphNode cur = q.poll();
                    for(UndirectedGraphNode neighbor : cur.neighbors) {
                        res.add(neighbor);
                    }
                }
                break;
            } else {
                Queue<UndirectedGraphNode> tmp = new LinkedList<UndirectedGraphNode>();
                for(int i = 0; i < q.size(); i++) {
                    UndirectedGraphNode cur = q.poll();
                    for(UndirectedGraphNode neighbor : cur.neighbors) {
                        tmp.offer(neighbor);
                    }
                }
                q = tmp;
            }
            
        }
        
        return res;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        NodeWithSameDistance t = new NodeWithSameDistance();
        /*
         * root -> a1 -> b1, b2, b3
         *      -> a2
         */     
        UndirectedGraphNode root = new UndirectedGraphNode(1);
        UndirectedGraphNode a1 = new UndirectedGraphNode(2);
        UndirectedGraphNode a2 = new UndirectedGraphNode(3);
        root.neighbors.add(a1);
        root.neighbors.add(a2);
        UndirectedGraphNode b1 = new UndirectedGraphNode(4);
        UndirectedGraphNode b2 = new UndirectedGraphNode(5);
        UndirectedGraphNode b3 = new UndirectedGraphNode(6);
        a1.neighbors.add(b1);
        a1.neighbors.add(b2);
        a1.neighbors.add(b3);
        
        for(UndirectedGraphNode node : t.nodesWithSameDis(root, 2)){
            System.out.println(node.label);
        }
    }

}
