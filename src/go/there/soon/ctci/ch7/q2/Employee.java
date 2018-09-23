package go.there.soon.ctci.ch7.q2;

abstract class Employee {
	private Call currentCall = null;
	protected Rank rank;
	private CallCenter callCenter;

	public Employee(CallCenter callCenter) {
		this.callCenter = callCenter;
	}
	
	/** start the conversation */
	public void receiveCall(Call call) {
		currentCall = call;
	}
	
	/** issue is resolved, finish the call */
	public void callCompleted() {
		if(currentCall != null) {
			currentCall.disconnect();
			currentCall = null;
		}
		
		assignNewCall();
	}
	
	public void escalateAndReassign() {
		if(currentCall != null) {
			currentCall.incrementRank();
			callCenter.dispatchCall(currentCall);
			currentCall = null;
		}
		
		assignNewCall();
	}
	
	public boolean assignNewCall() {
		if(!isFree()) {
			return false;
		}
		
		return callCenter.assignCall(this);
	}
	public boolean isFree() {
		return (currentCall == null);
	}
	
	/** Setters and getters */
	public Rank getRank() {
		return rank;
	}

	public void setRank(Rank rank) {
		this.rank = rank;
	}
}
