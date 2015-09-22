package MusicalJukebox;

public class CDPlayer {
	private PlayList p;
	private CD c;
	
	public CDPlayer(PlayList p, CD c) {
		this.p = p;
		this.c = c;
	}
	
	public void playSong(Song song) {
		
	}
	
	public PlayList getPlayList() {
		return p;
	}
	public void setPlayList(PlayList p) {
		this.p = p;
	}
	public CD getCD() {
		return c;
	}
	public void setCD(CD c) {
		this.c = c;
	}
}
