package chapter03;

public class SongApp {
	public static void main(String[] args) {
//		Song song = new Song();
//		song.setTitle("좋은날");
//		song.setArtist("아이유");
//		song.setComposer("이민수");
//		song.setAlbum("Real");
//		song.setYear(2010);
//		song.setTrack(3);
		Song song = new Song("좋은날", "아이유", "이민수", "Real", 2010, 3);
		song.show();
		
		Song song2 = new Song("봄여름가을겨울", "빅뱅");
		song2.show();
	}
}