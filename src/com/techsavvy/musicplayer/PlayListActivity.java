package com.techsavvy.musicplayer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

import android.app.Activity;
import android.app.ListActivity;
import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

public class PlayListActivity extends Activity{
	// Songs list
	public static ArrayList<SongsManager> songList;
	private ListView songView, songViews;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.playlist);
		//Log.v("fdgdggd", "gfhfghfghghfgh");
		songView = (ListView)findViewById(R.id.song_list);
		songList = new ArrayList<SongsManager>();
		getSongList();
		/*Collections.sort(songList, new Comparator<SongsManager>(){
			 public int compare(SongsManager a, SongsManager b){
			    return a.getTitle().compareTo(b.getTitle());
			  }
			});*/
		SongAdapter songAdt = new SongAdapter(this, songList);
		//ListAdapter adapter = new SimpleAdapter(this, songList, R.layout.song, new String[] { "title" }, new int[] {R.id.song_title });
		
		songView.setAdapter(songAdt);
		
		//songViews = (ListView)findViewById(R.id.song_list);	
				//ListView lv = getListView();
		// listening to single listitem click
		songView.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
					int songIndex = position;
				
				// Starting new intent
				Intent in = new Intent(getApplicationContext(),
						MainActivity.class);
				// Sending songIndex to PlayerActivity
				in.putExtra("songIndex", songIndex);
				setResult(100, in);
				// Closing PlayListView
				finish();
			}
		});
		}
			
	/*@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// getting listitem index
				//int songIndex = position;
				
				// Starting new intent
				Log.v("string", "pulkityamini");
				//Intent in = new Intent(getApplicationContext(),
					//	MainActivity.class);
				// Sending songIndex to PlayerActivity
				//in.putExtra("songIndex", songIndex);
				//setResult(100, in);
				// Closing PlayListView
				Log.v("bubbaloo","dhattad tattad");
				//finish();
			}*/

	
	public void getSongList() {
		ContentResolver musicResolver = getContentResolver();
		Uri musicUri = android.provider.MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
		Cursor musicCursor = musicResolver.query(musicUri, null, null, null, null);
		if(musicCursor!=null && musicCursor.moveToFirst()){
			  //get columns
			  int titleColumn = musicCursor.getColumnIndex
			    (android.provider.MediaStore.Audio.Media.TITLE);
			  int idColumn = musicCursor.getColumnIndex
			    (android.provider.MediaStore.Audio.Media._ID);
			  int artistColumn = musicCursor.getColumnIndex
			    (android.provider.MediaStore.Audio.Media.ARTIST);
			  int dataColumn = musicCursor.getColumnIndex(android.provider.MediaStore.Audio.Media.DATA);
			  int albumId = musicCursor.getColumnIndex(android.provider.MediaStore.Audio.Media.ALBUM_ID);
			  //add songs to list
			  do {
			    long thisId = musicCursor.getLong(idColumn);
			    String thisTitle = musicCursor.getString(titleColumn);
			    String thisArtist = musicCursor.getString(artistColumn);
			    String thisData = musicCursor.getString(dataColumn);
			    long thisAlbumId = musicCursor.getLong(albumId);
			    songList.add(new SongsManager(thisId, thisTitle, thisArtist, thisData,thisAlbumId));
			  }
			  while (musicCursor.moveToNext());
			}
		}

	/*@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);
		Log.v("kutti","kamini");
	}*/
}
