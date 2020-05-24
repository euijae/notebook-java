package codingproblems.ctci.ch7.q3;

public class Song {
	
	/** Fields */
	private Album album;
	private String title;
	private long id;
	
	/** Constructor */
	public Song() {
		super();
	}

	/** Getters and setters */
	public Album getAlbum() {
		return album;
	}

	public void setAlbum(Album album) {
		this.album = album;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Song [album=" + album.getTitle() + ", title=" + title + "]";
	}
}
