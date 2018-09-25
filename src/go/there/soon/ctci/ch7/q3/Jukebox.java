package go.there.soon.ctci.ch7.q3;

import java.util.Queue;

public class Jukebox {
	private Queue<User> user;

	public Jukebox() {}

	public Queue<User> getUser() {
		return user;
	}

	public void setUser(Queue<User> user) {
		this.user = user;
	}
}
