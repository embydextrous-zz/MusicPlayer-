package com.techsavvy.musicplayer;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.HashMap;

public class SongsManager {
	// SDCard Path
	//final String MEDIA_PATH = new String("/sdcard/");
	//private ArrayList<HashMap<String, String>> songsList = new ArrayList<HashMap<String, String>>();
	private long id;
	private String title;
	private String artist;
	private String path;
	private long albumId;

	// Constructor
	public SongsManager(long songId, String songTitle, String songArtist, String songPath, long songAlbumId){
		id=songId;
		title= songTitle;
		artist = songArtist;
		path = songPath;
		albumId = songAlbumId;
	}
	
	
	public long getID(){return id;}
	public String getTitle(){return title;}
	public String getArtist(){return artist;}
	public String getPath() {return path;}
	public long getAlbumId(){return albumId;}
}