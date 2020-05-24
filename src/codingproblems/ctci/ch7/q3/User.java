package codingproblems.ctci.ch7.q3;

import java.util.List;

public class User {
	
	/** Fields */
	private String userName;
	private String firstName;
	private String lastName;
	private long id;
	
	private List<Playlist> playlists;
	private Playlist playlist;
	
	/** Constructor */
	public User(String un, String fn, String ln) {
		userName  = un;
		firstName = fn;
		lastName  = ln;
	}

	/** Behavior methods */
	public void addPlaylist(Playlist p) {
		playlists.add(p);
	}
	
	public void removePlaylist(int index) {
		if(!playlists.isEmpty()) {
			playlists.remove(index);
		}
	}
	
	public void switchPlaylist(int index) {
		playlist = playlists.get(index);
	}
	
	public Playlist getCurrentPlaylist() {
		return playlist;
	}
	
	/** Setters and getters */
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public List<Playlist> getPlaylists() {
		return playlists;
	}

	public void setPlaylists(List<Playlist> playlists) {
		this.playlists = playlists;
	}
}
