package TreesAndGraphs;

import java.util.*;

/*
 * Given a directed graph, design an algorithm to find out whether there is a route
between two nodes.
 */


public class _42 {
	class DirectedGraph{
		private int V;
		private int E;
		private LinkedList<Integer>[] adj;
		
		public DirectedGraph(int V){
			this.V = V;
			E = 0;
			adj = (LinkedList<Integer>[]) new LinkedList[V];
			for(int v = 0; v < V; v++)
				adj[v] = new LinkedList<Integer>();
		}
		
		public LinkedList<Integer> adj(int i){
			return adj[i];
		}
		
		public int V() {
			return V;
		}
		public int E() {
			return E;
		}
		public void addEdge(int v, int w) {
			adj[v].add(w);
			E++;
		}
	}
	
	public boolean search(DirectedGraph g, int v, int w) {
		return reachable(g, v, w) || reachable(g, w, v);
	}
	
	public boolean reachable(DirectedGraph g, int v, int w) {
		boolean[] visited = new boolean[g.V()];
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(v);
		while(!q.isEmpty()) {
			int cur = q.poll();
			visited[cur] = true;
			for(int a : g.adj(cur)){
				if(!visited[a]){
					if(a == w) return true;
					else {
						visited[a] = true;
						q.offer(a);
					}
				}
			}
		}
		
		return false;
	}
	
	public boolean dfs(DirectedGraph g, int v, int w) {
		boolean[] visited = new boolean[g.V()];
		visited[v] = true;
		for(int i : g.adj[v]){
			if(!visited[i]){
				if(dfs(g, i, w)) return true;
			}
		}
		return false;
	}
	
}
	

