package chapter03;

public class Song {

	private String title;
	private String artist;
	private String album;
	private String composer;
	private int year;
	private int track;
	
	public Song(String title, String artist /* ... */ ){ 
	    
		// some codes...
	    //this.title = title; 
		//this.artist = artist;
		     // ... 
		this(title, artist, null, null, 0, 0);
		Song song = new Song("봄여름\"가을\"겨울", "빅뱅");
		
	
	}
	
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public String getAlbum() {
		return album;
	}

	public void setAlbum(String album) {
		this.album = album;
	}

	public String getComposer() {
		return composer;
	}

	public void setComposer(String composer) {
		this.composer = composer;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getTrack() {
		return track;
	}

	public void setTrack(int track) {
		this.track = track;
	}

	public void show();
}
