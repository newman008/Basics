package MusicalJukebox;

import java.util.*;

public class PlayList {
	private Song song;
	private Queue<Song> songs;
	
	public PlayList(Song song, Queue<Song> songs) {
		this.song = song;
		this.songs = songs;
	}
	
	public Song nextSongToPlay() {
		return songs.peek();
	}
	
	public void addSong(Song song) {
		songs.offer(song);
	}
}
