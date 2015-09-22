package InterviewQuestions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class AvgLatency {
	
	private int window_size;
	private Map<String, Queue<Integer>> map = new HashMap<String, Queue<Integer>>();
	
	AvgLatency(List<String> methods, int window_size) {
		this.window_size = window_size;
		for(String str : methods) {
			map.put(str, new LinkedList<Integer>());
		}
	}
	
	public double getAvgLatency(String method) {
		double sum = 0;
		if(map.get(method).size() == 0) return sum;
		for(int latency : map.get(method)){
			sum += latency;
		}
		return sum / map.get(method).size(); 
	}
	
	public void addLatency(String method, int latency) {
		if(map.containsKey(method)) {
			if(map.get(method).size() < this.window_size){
				map.get(method).offer(latency);
			} else {
				map.get(method).poll();
				map.get(method).offer(latency);
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> methods = new ArrayList<String>();
		methods.add("GET");
		methods.add("POST");
		methods.add("DELETE");
		AvgLatency a = new AvgLatency(methods, 3);
		
		a.addLatency("GET", 10);
		a.addLatency("GET", 6);
		a.addLatency("GET", 6);
		a.addLatency("GET", 9);
		System.out.print(a.getAvgLatency("GET"));
	}

}
