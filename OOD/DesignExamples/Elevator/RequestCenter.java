package Elevator;

import java.util.*;

public class RequestCenter implements Runnable{
	
	private Queue<Request> queue;
	private static RequestCenter instance= null;
	
	private RequestCenter(){
		queue = new LinkedList<Request>();
	}
	
	public static RequestCenter getInstance() {
		if(instance == null) {
			synchronized(RequestCenter.class){
				instance = new RequestCenter();
			}
		}
		return instance;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true){
			processRequest();
		}
	}
	
	public void addRequest(Request request){
		queue.offer(request);
	}
	
	public void removeRequest(Request request){
		queue.remove(request);
	}
	
	public Request getNextRequest() {
		Request shortestReq = null;
		int shortest = Integer.MAX_VALUE;
		int curFloor = Elevator.getInstance().getCurFloor();
		for(Request r : queue){
			int distance = Math.abs(curFloor - r.getToFloor());
			if(distance < shortest){
				shortest = distance;
				shortestReq = r;
			}
		}
		return shortestReq;
	}
	
	public void processRequest() {
		Request req = getNextRequest();
		if(req != null){
			int toFloor = req.getToFloor();
			Elevator.getInstance().moveToTargetFloor(toFloor);
			queue.remove(req);
		}
	}

}
