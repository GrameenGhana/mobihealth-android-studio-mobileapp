package org.grameenfoundation.mobihealth.activity;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.grameenfoundation.mobihealth.R;
import org.grameenfoundation.mobihealth.application.BaseActivity;
import org.grameenfoundation.mobihealth.application.MobiHealth;
import org.grameenfoundation.mobihealth.database.MobiHealthDatabaseHandler;
import org.grameenfoundation.mobihealth.database.MobiHealthDatabaseHelper;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.res.AssetFileDescriptor;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.PowerManager;
import android.telephony.PhoneStateListener;
import android.telephony.SmsManager;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;


public class AlertMessagesActivity extends BaseActivity implements OnClickListener{


	private MediaPlayer mediaPlayer;
	private ImageButton play_button;
	private ImageButton pause_button;
	private ImageButton stop_button;
	private boolean isPaused = false; 
	Handler seekHandler = new Handler();
	private SeekBar seek_bar;
	private PhoneStateListener phoneStateListener = null;
	private int seek_position = 0;
	private TextView audio_duration;
	private SharedPreferences sharedPref;
	private SharedPreferences loginPref;
	private String languageOption;
	private String chps_zone;
	private String community;
	private String fullname;
	private ArrayList<String> dbValues;
	private MobiHealthDatabaseHandler db;
	private TextView messageOneTxt;
	private TextView messageTwoTxt;
	private TextView messageThreeTxt;
	private TextView messageFourTxt;
	private TextView messageFiveTxt;
	private ImageView messageOneImage;
	private ImageView messageTwoImage;
	private ImageView messageThreeImage;
	private ImageView messageFourImage;
	private ImageView messageFiveImage;
	private String submodule;
	private String module;
	private String type;
	private String[] items;
	private String status;
								
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.alert_messages_menu);
		 getActionBar().setDisplayHomeAsUpEnabled(true);
	    items=new String[]{"Pregnant woman in need of care",
	    				"Baby in need of care",
	    				"Baby in need of PNC",
	    				"New pregnancy",
	    				"Home delivery"};
	    
	    int[] images={R.drawable.audio_icon,
	    		R.drawable.audio_icon,
	    		R.drawable.audio_icon,
	    		R.drawable.audio_icon,
	    		R.drawable.audio_icon};
	    
	    //create instance of database handler class
	    db=new MobiHealthDatabaseHandler(AlertMessagesActivity.this);
	    
	    //retrieving language options
	    sharedPref = AlertMessagesActivity.this.getSharedPreferences("myPrefs",MODE_WORLD_READABLE);
		languageOption=sharedPref.getString("option", "English");
		
		loginPref=AlertMessagesActivity.this.getSharedPreferences("loginPrefs", MODE_WORLD_READABLE);
		chps_zone=loginPref.getString("chps_zone", "ASIDOWUI CHPS");
		community=loginPref.getString("community", "Akporkplorto");
		fullname=loginPref.getString("fullname", "name");
		type="SMS";
		
		module=MobiHealth.MODULE_REFERRAL_ALERTS;
		 dbValues=db.getPhoneNumbers(chps_zone);
		 dbValues.add("0544064037");
		 dbValues.add("0245810949");
		 dbValues.add("0540829699");
		 
		 System.out.println(dbValues);
		 messageOneTxt=(TextView) findViewById(R.id.textView2);
		 messageOneTxt.setText(items[0]);
		 messageOneTxt.setOnClickListener(this);
		 
		 messageTwoTxt=(TextView) findViewById(R.id.textView3);
		 messageTwoTxt.setText(items[1]);
		 messageTwoTxt.setOnClickListener(this);
		 
		 messageThreeTxt=(TextView) findViewById(R.id.textView4);
		 messageThreeTxt.setText(items[2]);
		 messageThreeTxt.setOnClickListener(this);
		 
		 messageFourTxt=(TextView) findViewById(R.id.textView5);
		 messageFourTxt.setText(items[3]);
		 messageFourTxt.setOnClickListener(this);
		 
		 messageFiveTxt=(TextView) findViewById(R.id.textView6);
		 messageFiveTxt.setText(items[4]);
		 messageFiveTxt.setOnClickListener(this);
		 
		 messageOneImage=(ImageView) findViewById(R.id.imageView2);
		 messageOneImage.setOnClickListener(this);
		 
		 messageTwoImage=(ImageView) findViewById(R.id.imageView3);
		 messageTwoImage.setOnClickListener(this);
		 
		 messageThreeImage=(ImageView) findViewById(R.id.imageView4);
		 messageThreeImage.setOnClickListener(this);
		 
		 messageFourImage=(ImageView) findViewById(R.id.imageView5);
		 messageFourImage.setOnClickListener(this);
		 
		 messageFiveImage=(ImageView) findViewById(R.id.imageView6);
		 messageFiveImage.setOnClickListener(this);
	}


    
	@Override
	public void onClick(View v) {
		Intent intent;
		String filePath;
		
		String messageToSend;
		String[] phoneNumbers = null;
		switch(v.getId()){
		case R.id.imageView1:
			intent=new Intent(AlertMessagesActivity.this, MenuActivity.class);
			startActivity(intent);
			break;
			
		case R.id.imageView2:
			if(languageOption.equalsIgnoreCase("English")){
    			filePath="english_messages/message_one.ogg";
				playSMSAudio(filePath);
				
			}else if(languageOption.equalsIgnoreCase("Ewe")){
				filePath="ewe_messages/message_one.ogg";
				playSMSAudio(filePath);
			}
			break;
		case R.id.imageView3:
			if(languageOption.equalsIgnoreCase("English")){
				filePath="english_messages/message_two.ogg";
				playSMSAudio(filePath);
			}else if(languageOption.equalsIgnoreCase("Ewe")){
				filePath="ewe_messages/message_two.ogg";
				playSMSAudio(filePath);
			}
			break;
		case R.id.imageView4:
			if(languageOption.equalsIgnoreCase("English")){
				filePath="english_messages/message_three.ogg";
				playSMSAudio(filePath);
			}else if(languageOption.equalsIgnoreCase("Ewe")){
				filePath="ewe_messages/message_three.ogg";
				playSMSAudio(filePath);
			}
			break;
		case R.id.imageView5:
			if(languageOption.equalsIgnoreCase("English")){
				filePath="english_messages/message_four.ogg";
				playSMSAudio(filePath);
			}else if(languageOption.equalsIgnoreCase("Ewe")){
				filePath="ewe_messages/message_four.ogg";
				playSMSAudio(filePath);
			}
			break;
		case R.id.imageView6:
			if(languageOption.equalsIgnoreCase("English")){
				filePath="english_messages/message_five.ogg";
				playSMSAudio(filePath);
			}else if(languageOption.equalsIgnoreCase("Ewe")){
				filePath="ewe_messages/message_five.ogg";
				playSMSAudio(filePath);
				
			}
			break;
		

    	case R.id.textView2:
    		submodule=items[0];
    		messageToSend="Danger signs detected.Pregnant woman needs urgent attention in "+ community+".\n\nFrom "+fullname;
			sendSMS(messageToSend);
				
				
    		break;
    	case R.id.textView3:
    		submodule=items[1];
			messageToSend="Danger signs detected.Baby needs urgent attention in "+community+".\n\nFrom "+fullname;
			sendSMS(messageToSend);
			
			break;
			
    	case R.id.textView4:
    		submodule=items[2];
			messageToSend="A baby in "+community+" needs PNC care.\n\nFrom "+fullname;
			sendSMS(messageToSend);
			break;
			
    	case R.id.textView5:
    		submodule=items[3];
			messageToSend="I have seen a new pregnant client in "+community+".\n\nFrom "+fullname;
			sendSMS(messageToSend);
		
			
			break;
		case R.id.textView6:
			submodule=items[4];
			messageToSend="I have seen a client who had a home delivery in "+community+".\n\nFrom "+fullname;
			sendSMS(messageToSend);
			/*
			for (int i=0; i<dbValues.size();i++){
				
				try {
					phoneNumbers=new String[dbValues.size()];
					phoneNumbers[i]=dbValues.get(i);
					System.out.println(phoneNumbers[i]);
				
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
					
				}
			*/
			break;
    	}
		
		
	}
	
	public void sendSMS(String messageToSend){
		try {

		      String SENT = "sent";
		     String DELIVERED = "delivered";

		      Intent sentIntent = new Intent(SENT);
		     /*Create Pending Intents*/
		     PendingIntent sentPI = PendingIntent.getBroadcast(
		       getApplicationContext(), 0, sentIntent,
		       PendingIntent.FLAG_UPDATE_CURRENT);

		      Intent deliveryIntent = new Intent(DELIVERED);

		      PendingIntent deliverPI = PendingIntent.getBroadcast(
		       getApplicationContext(), 0, deliveryIntent,
		       PendingIntent.FLAG_UPDATE_CURRENT);
		     /* Register for SMS send action */
		     registerReceiver(new BroadcastReceiver() {

		       @Override
		      public void onReceive(Context context, Intent intent) {
		       String result = "";

		        switch (getResultCode()) {

		        case Activity.RESULT_OK:
		        result = "SMS sent!";
		        status= "SMS sent!";
		        break;
		       case SmsManager.RESULT_ERROR_GENERIC_FAILURE:
		        result = "SMS failed to send";
		        status= "SMS failed to send";
		        break;
		       case SmsManager.RESULT_ERROR_RADIO_OFF:
		        result = "Radio off";
		        status="Radio off";
		        break;
		       case SmsManager.RESULT_ERROR_NULL_PDU:
		        result = "No PDU defined";
		        status= "No PDU defined";
		        break;
		       case SmsManager.RESULT_ERROR_NO_SERVICE:
		        result = "No service";
		        status="No service";
		        break;
		       }

		        Toast.makeText(getApplicationContext(), result,
		         Toast.LENGTH_LONG).show();
		      }

		      }, new IntentFilter(SENT));
		     /* Register for Delivery event */
		     registerReceiver(new BroadcastReceiver() {

		       @Override
		      public void onReceive(Context context, Intent intent) {
		       Toast.makeText(getApplicationContext(), "Delivered",
		         Toast.LENGTH_LONG).show();
		      }

		      }, new IntentFilter(DELIVERED));

		      /*Send SMS*/
		     SmsManager smsManager = SmsManager.getDefault();
		     String[] phoneNumbers = null;
		     for (int i=0; i<dbValues.size();i++){
		    	 phoneNumbers=new String[dbValues.size()];
					phoneNumbers[i]=dbValues.get(i);
					System.out.println(phoneNumbers[i]);
		     smsManager.sendTextMessage(phoneNumbers[i], null, messageToSend, sentPI,
		       deliverPI);
		     System.out.println(module+" "+submodule+" "+type+status+ phoneNumbers[i]);
		     db.insertUsageActivity(fullname, module, submodule,type,db.getDateTime()," "," ",status,phoneNumbers[i],MobiHealth.SYNC_STATUS_NEW);
		     }
		     Toast.makeText(getApplicationContext(), "Sending SMS......",
			         Toast.LENGTH_LONG).show();
		    } catch (Exception ex) {
		     Toast.makeText(getApplicationContext(),
		       ex.getMessage().toString(), Toast.LENGTH_LONG)
		       .show();
		     ex.printStackTrace();
		    }
		   }
	
	public void start() {
        mediaPlayer.start();

      this.isPaused = false;
    }

    public void pause() {
   	 mediaPlayer.pause();

      this.isPaused = true;
    }

    public int getDuration() {
      return mediaPlayer.getDuration();
    }

    public int getCurrentPosition() {
      return mediaPlayer.getCurrentPosition();
    }

    public void seekTo(int i) {
   	 mediaPlayer.seekTo(i);
    }

    public boolean isPlaying() {
      return mediaPlayer.isPlaying();
    }

    public int getBufferPercentage() {
      return 0;
    }

    public boolean canPause() {
      return true;
    }

    public boolean canSeekBackward() {
      return true;
    }

    public boolean canSeekForward() {
      return true;
    																																														}
	
    
    private void playSMSAudio(String audioPath) {
        try {
        	AssetFileDescriptor descriptor = AlertMessagesActivity.this.getAssets().openFd(audioPath);
            long start = descriptor.getStartOffset();
            long end = descriptor.getLength();
            mediaPlayer=new MediaPlayer();
            mediaPlayer.setWakeMode(getApplicationContext(), PowerManager.FULL_WAKE_LOCK);
            mediaPlayer.reset();
            mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
            mediaPlayer.setDataSource(descriptor.getFileDescriptor(), start, end);
            mediaPlayer.prepare();
            mediaPlayer.start();  	  
            
            //pop up a media player dialog
            final Dialog dialog = new Dialog(AlertMessagesActivity.this);
			dialog.setContentView(R.layout.media_player_dialog);
			dialog.setTitle("Now playing");
			dialog.setCancelable(false);
			play_button = (ImageButton) dialog.findViewById(R.id.status_btn);
			
			pause_button=(ImageButton) dialog.findViewById(R.id.status_btn_pause);
			
			stop_button=(ImageButton) dialog.findViewById(R.id.stop_btn);
			
			 audio_duration=(TextView) dialog.findViewById(R.id.textView1);
			 mediaPlayerDuration();
			seek_bar=(SeekBar) dialog.findViewById(R.id.seekBar1);
            seek_bar.setMax(mediaPlayer.getDuration());
            seekUpdation();
            
			Button dialogButton = (Button) dialog.findViewById(R.id.ok_btn);
			dialogButton.setText("Cancel");
			// if button is clicked, close the custom dialog
			dialogButton.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
				
		        	
		        	//int position=listView.getSelectedItemPosition();       		
		        
		        	dialog.dismiss();
					mediaPlayer.stop();
					mediaPlayer.release();
		        	mediaPlayer = null;
				}
			});
 				dialog.show();
 				
 				play_button.setOnClickListener(new OnClickListener(){
					@Override
					public void onClick(View v) {
					start();
					}	
				});
 				
 				pause_button.setOnClickListener(new OnClickListener(){
					@Override
					public void onClick(View v) {
					pause();
					}	
				});
 				
 				stop_button.setOnClickListener(new OnClickListener(){
					@Override
					public void onClick(View v) {
					mediaPlayer.stop();
					mediaPlayer.release();
		        	mediaPlayer = null;
		        	dialog.dismiss();
					}	
				});
        } catch (IOException e) {
            Log.e(getString(R.string.app_name), e.getLocalizedMessage());
        	System.out.println("could not play");
        }
    }
   
   Runnable run = new Runnable() { 
	   @Override public void run() { 
		   seekUpdation();
		   } 
	   }; 

   public void seekUpdation() {
   if(seek_bar!=null && mediaPlayer!=null){
	   seek_bar.setProgress(mediaPlayer.getCurrentPosition()); 
	   seekHandler.postDelayed(run, 1000);
   }
	   } 
   		
   @Override
      protected void onStop() { // Activity becomes hidden.
            super.onStop();
            if(this.isPaused == true) {
                seek_position = mediaPlayer.getCurrentPosition();
            }
      }

   
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(mediaPlayer!=null){
        	mediaPlayer.stop();
        	mediaPlayer.release();
        	mediaPlayer = null;
        }
        	 TelephonyManager mgr = (TelephonyManager) getSystemService(TELEPHONY_SERVICE);
             if(mgr != null) {
                 mgr.listen(phoneStateListener, PhoneStateListener.LISTEN_NONE);
             }
    }	
    @Override
      protected void onResume() {
           super.onResume();

           if(this.isPaused == true) { // Restore the playback position if it was paused.
               mediaPlayer.seekTo(seek_position);
           }
      }
	public void mediaPlayerDuration(){
		final int HOUR = 60*60*1000;
	    final int MINUTE = 60*1000;
	    final int SECOND = 1000;
	    
	    int durationInMillis = mediaPlayer.getDuration();
	    int durationHour = durationInMillis/HOUR;
	    int durationMint = (durationInMillis%HOUR)/MINUTE;
	    int durationSec = (durationInMillis%MINUTE)/SECOND;
	    if(durationHour>0){
			audio_duration.setText(String.format("%02d:%02d:%02d", 
	               durationHour,durationMint,durationSec));
	    }else{
	    	audio_duration.setText(String.format("%02d:%02d:%02d", 
	               durationHour,durationMint,durationSec));
	    
	}
	}

}
