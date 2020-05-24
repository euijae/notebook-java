package codingproblems.ctci.ch7.q3;

import java.util.List;

public class Album {
	private List<Song> songs;
	private String title;
	
	public Album(List<Song> songs) {
		for(Song song : songs) {
			this.songs.add(song);
		}
	}

	public List<Song> getSongs() {
		return songs;
	}

	public void setSongs(List<Song> songs) {
		this.songs = songs;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
}
