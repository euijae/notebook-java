package go.there.soon.ctci.ch7.q2;

public class Call {
	private Rank rank;
	private Caller caller;
	private Employee handler;
	
	public Call(Caller c) {
		rank = Rank.Respondent;
		caller = c;
	}
	
	public void setHandler(Employee e) {
		setHandler(e);
	}
	
	public void reply(String message) {
		System.out.println(message);
	}
	
	public void disconnect() {
		reply("Thank you for calling.");
	}
	
	public Rank incrementRank() {
		if(rank == Rank.Respondent) {
			rank = Rank.Manager;
		} else if(rank == Rank.Manager) {
			rank = Rank.Director;
		} 
			
		return rank;
	}
	
	/** Setters and getters */
	public Rank getRank() {
		return rank;
	}
	
	public void setRank(Rank rank) {
		this.rank = rank;
	}

	public Caller getCaller() {
		return caller;
	}

	public void setCaller(Caller caller) {
		this.caller = caller;
	}

	public Employee getHandler() {
		return handler;
	}
}
