package CallCenter;

import java.util.*;

public class CallHandler {
	private static CallHandler instance;
	
	/* 3 levels of employees: respondents, managers, directors. */
	private final int LEVELS = 3;

	/* Initialize 10 respondents, 4 managers, and 2 directors. */
	private final int NUM_RESPONDENTS = 10;
	private final int NUM_MANAGERS = 4;
	private final int NUM_DIRECTORS = 2;
	
	List<List<Employee>> employeeLevels;
	List<List<Call>> callQueues;
	
	public Employee getHandlerForCall(Call call) {
		for(Employee e : employeeLevels.get(0)){
			if(e.isFree()) {
				return e;
			}
		}
		return null;
	}
	
	private CallHandler() {
		employeeLevels = new ArrayList<List<Employee>>();
		List<Employee> respondents = new ArrayList<Employee>();
		for(int i = 0; i < NUM_RESPONDENTS; i++) 
			respondents.add(new Responder());
		employeeLevels.add(respondents);
	}
	
	// Singleton 
	public CallHandler getInstance() {
		if(instance == null) {
			instance = new CallHandler();
		}
		return instance;
	}
	
	public void dispatchCall(Call call) {
		Employee emp = getHandlerForCall(call);
		if(emp != null) {
			emp.pickCall(call);
			call.setHandler(emp);
		} else {
			call.reply("sorry!");
			callQueues.get(call.getRank()).add(call);
		}
	}
	
	public void assignCall(Employee emp) {
		
	}
}
