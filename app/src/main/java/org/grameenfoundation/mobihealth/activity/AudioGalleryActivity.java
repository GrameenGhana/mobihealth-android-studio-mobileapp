package org.grameenfoundation.mobihealth.activity;

import java.io.File;

import org.grameenfoundation.mobihealth.R;
import org.grameenfoundation.mobihealth.adapter.FirstTrimesterAudioBaseAdapter;
import org.grameenfoundation.mobihealth.application.BaseActivity;
import org.grameenfoundation.mobihealth.application.MobiHealth;
import org.grameenfoundation.mobihealth.application.Player;
import org.grameenfoundation.mobihealth.application.TelephonyStateListener;
import org.grameenfoundation.mobihealth.application.URLMediaPlayerActivity;
import org.grameenfoundation.mobihealth.database.MobiHealthDatabaseHandler;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

public class AudioGalleryActivity extends BaseActivity implements OnItemClickListener {

	private ListView audioGrid;
	private String[] songList;
	private int[] imageid;
	private String[] songname;
	private Player player;
	private String path;
	private MobiHealthDatabaseHandler db;
	private String type;
	private String submodule;
	private String module;
	private String extras;
	private Intent intent;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.first_trimester_gallery);
	    audioGrid=(ListView) findViewById(R.id.first_trimester_audio_gridview);
	    player=new Player(AudioGalleryActivity.this);
	    intent = getIntent();
	    preparePlayer();
	}
	
	 public void preparePlayer(){
		 try{
			String eweLocation=intent.getStringExtra(MobiHealth.EWE_AUDIO_LOCATION);
			String ewePath=eweLocation+File.separator;
			String englishLocation=intent.getStringExtra(MobiHealth.ENGLISH_AUDIO_LOCATION);
			String englishPath=englishLocation+File.separator;
			songList=player.loadAssets(englishLocation,eweLocation,
	 				  		ewePath,englishPath);
			path=player.getFilePath(eweLocation, englishLocation);
			populateImages();
			populateSongNames();
			db=new MobiHealthDatabaseHandler(AudioGalleryActivity.this);
			FirstTrimesterAudioBaseAdapter adapter= new FirstTrimesterAudioBaseAdapter(AudioGalleryActivity.this,imageid,songname);
			audioGrid.setAdapter(adapter);
			audioGrid.setOnItemClickListener(this);
			type=intent.getStringExtra(MobiHealth.TYPE);
			submodule=intent.getStringExtra(MobiHealth.SUB_MODULE);
			module=intent.getStringExtra(MobiHealth.MODULE);
			extras=intent.getStringExtra(MobiHealth.EXTRAS);
			
		 }catch(Exception e){
			 e.printStackTrace();
			 
		 }
	 }
	  public void populateImages(){
			 imageid=new int[songList.length];  
			 
			 for(int i=0;i<songList.length;i++){
				 imageid[i]=R.drawable.treble;
			 }
		   }
		   
		   public void populateSongNames(){
				 songname=new String[songList.length];  
				 
				 for(int i=0;i<songList.length;i++){
					 int increment =1+i;
					 songname[i]="Message "+increment;
				 }
			   }

		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id) {
			Intent intent=new Intent(AudioGalleryActivity.this,URLMediaPlayerActivity.class);
			intent.putExtra(MobiHealth.AUDIO_URL, path+songList[position]);
			intent.putExtra(MobiHealth.TYPE, type);
			intent.putExtra(MobiHealth.SUB_MODULE, submodule);
			intent.putExtra(MobiHealth.MODULE, module);
			intent.putExtra(MobiHealth.EXTRAS,extras);
			startActivity(intent);
		}
		   
}
