package go.there.soon.ctci.ch7.q2;

import java.util.ArrayList;
import java.util.List;

public class CallCenter {
	/* 3 levels of employees */
	private final int LEVELS = 3;
	
	private final int NUM_RESPONDENTS = 10;
	private final int NUM_MANAGERS = 4;
	private final int NUM_DIRECTORS = 2;
	
	List<List<Employee>> employeeLevels;
	List<List<Call>> callQueues;
	
	public CallCenter() {
		employeeLevels = new ArrayList<>();
		callQueues = new ArrayList<>();
		
		List<Employee> respondents = new ArrayList<>();
		List<Employee> managers = new ArrayList<>();
		List<Employee> directors = new ArrayList<>();
		
		for(int i = 0; i < NUM_RESPONDENTS; i++)
			respondents.add(new Respondent(this));
		
		for(int i = 0; i < NUM_MANAGERS; i++)
			managers.add(new Manager(this));
		
		for(int i = 0; i < NUM_DIRECTORS; i++)
			directors.add(new Director(this));

		employeeLevels.add(respondents);
		employeeLevels.add(managers);
		employeeLevels.add(directors);
	}
	
	public Employee getHandlerForCall(Call call) {
		for(int level = call.getRank().getRank(); level < LEVELS; level++) {
			List<Employee> employeeLevel = employeeLevels.get(level);
			for(Employee emp : employeeLevel) {
				if(emp.isFree())
					return emp;
			}
		}
		
		return null;
	}
	
	public void dispatchCall(Caller caller) {
		Call call = new Call(caller);
		dispatchCall(call);
	}
	
	public void dispatchCall(Call call) {
		Employee emp = getHandlerForCall(call);
		if(emp != null) {
			emp.receiveCall(call);
			call.setHandler(emp);
		} else {
			call.reply("Please wait for free");
			callQueues.get(call.getRank().getRank()).add(call);
		}
	}
	
	public boolean assignCall(Employee employee) {
		for(int rank = employee.getRank().getRank(); rank > 0; rank--) {
			List<Call> queue = callQueues.get(rank);
			
			if(queue.size() > 0) {
				Call call = queue.remove(0);
				if(call != null) {
					employee.receiveCall(call);
					return true;
				}
			}
		}
		
		return false;
	}
}
