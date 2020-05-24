package codingproblems.ctci.ch7.q3;

import java.util.List;

public class Playlist {
	private User user;
	private List<Song> songs;
	private int currentIndex;
	private boolean isRepeat;
	private boolean isShuffle;
	
	public Playlist() {
		currentIndex = 0;
		isRepeat = false;
		isShuffle = false;
	}

	public void addSong(Song song) {
		songs.add(song);
	}
	
	public Song playNext() {
		int size = songs.size();
		currentIndex = (currentIndex + 1) % size;
		return getCurrentSong();
	}
	
	public Song playPrev() {
		int size = songs.size();
		currentIndex -= 1;
		if(currentIndex < 0) {
			currentIndex += size;
		}
		
		return getCurrentSong();
	}
	
	public Song getCurrentSong() {
		return songs.get(currentIndex);
	}
	
	public void removeSong(int index) {
		if(index < 0 || songs.size() < 1)
			return;
		
		if(songs.size() > index) {
			songs.remove(index);
		}
	}

	/** getters and setters */
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Song> getSongs() {
		return songs;
	}

	public void setSongs(List<Song> songs) {
		this.songs = songs;
	}

	public int getCurrentIndex() {
		return currentIndex;
	}

	public void setCurrentIndex(int currentIndex) {
		this.currentIndex = currentIndex;
	}

	public boolean isRepeat() {
		return isRepeat;
	}

	public void setRepeat(boolean isRepeat) {
		this.isRepeat = isRepeat;
	}

	public boolean isShuffle() {
		return isShuffle;
	}

	public void setShuffle(boolean isShuffle) {
		this.isShuffle = isShuffle;
	}
}
