package org.grameenfoundation.mobihealth.application;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import android.os.Bundle;
import android.os.Handler;
import android.os.PowerManager;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.io.FileInputStream;
import java.io.IOException;

import org.grameenfoundation.mobihealth.R;
import org.grameenfoundation.mobihealth.database.MobiHealthDatabaseHandler;

public class URLMediaPlayerActivity extends Activity {

    private MediaPlayer mediaPlayer;
    private SeekBar seekBar;
	private Player player;
	private MobiHealthDatabaseHandler db;
	private String module;
	private String submodule;
	private String type;
	private String duration;
	private String duration_played;
	private String extras;
	private TextView totalTime;
	private TelephonyStateListener phoneStateListener;
	private FileInputStream fis;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        player=new Player(URLMediaPlayerActivity.this,mediaPlayer);

        // remove title and go full screen
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        db=new MobiHealthDatabaseHandler(URLMediaPlayerActivity.this);

        // get data from main activity intent
        Intent intent = getIntent();
        final String audioFile = intent.getStringExtra(MobiHealth.AUDIO_URL);
        type=intent.getStringExtra(MobiHealth.TYPE);
        module=intent.getStringExtra(MobiHealth.MODULE);
        extras=intent.getStringExtra(MobiHealth.EXTRAS);
        submodule=intent.getStringExtra(MobiHealth.SUB_MODULE);
        //final String coverImage = intent.getStringExtra(MobiHealth.IMG_URL);
    	phoneStateListener = new TelephonyStateListener(URLMediaPlayerActivity.this,mediaPlayer); 

        // create a media player
        mediaPlayer = new MediaPlayer();

        // try to load data and play
        try {
        	 mediaPlayer.setWakeMode(getApplicationContext(), PowerManager.FULL_WAKE_LOCK);
        	AssetFileDescriptor descriptor = URLMediaPlayerActivity.this.getAssets().openFd(audioFile);
            long start = descriptor.getStartOffset();
            long end = descriptor.getLength();
            // give data to mediaPlayer
            mediaPlayer.setDataSource(descriptor.getFileDescriptor(), start, end);
            // media player asynchronous preparation
            mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
            mediaPlayer.prepare();

            // create a progress dialog (waiting media player preparation)
            final ProgressDialog dialog = new ProgressDialog(URLMediaPlayerActivity.this);

            // set message of the dialog
            dialog.setMessage("Loading...");

            // prevent dialog to be canceled by back button press
            dialog.setCancelable(false);

            // show dialog at the bottom
            dialog.getWindow().setGravity(Gravity.CENTER);

            // show dialog
            dialog.show();


            // inflate layout
            setContentView(R.layout.activity_media_player);

            // display title
            ((TextView)findViewById(R.id.now_playing_text)).setText(audioFile);


            /// Load cover image (we use Picasso Library)

            // Get image view
            ImageView mImageView = (ImageView) findViewById(R.id.coverImage);

            // Image url
          //  String image_url = coverImage;


           // Picasso.with(getApplicationContext()).load(image_url).into(mImageView);

            ///

            mediaPlayer.start();

            // link seekbar to bar view
            seekBar = (SeekBar) findViewById(R.id.seekBar);

            //update seekbar
            mRunnable.run();

            //dismiss dialog
            dialog.dismiss();
            /*
            // execute this code at the end of asynchronous media player preparation
            mediaPlayer.setOnPreparedListener(new OnPreparedListener() {
                public void onPrepared(final MediaPlayer mp) {


                    //start media player
                  
                }
            });
*/

        } catch (IOException e) {
        	e.printStackTrace();
            Activity a = this;
            a.finish();
            Toast.makeText(this, "File not found", Toast.LENGTH_SHORT).show();
        }


    }


    private Handler mHandler = new Handler();
    private Runnable mRunnable = new Runnable() {

        

		@Override
        public void run() {
            if(mediaPlayer != null) {

                //set max value
                int mDuration = mediaPlayer.getDuration();
                seekBar.setMax(mDuration);

                //update total time text view
                totalTime = (TextView) findViewById(R.id.totalTime);
                totalTime.setText(getTimeString(mDuration));

                //set progress to current position
                int mCurrentPosition = mediaPlayer.getCurrentPosition();
                seekBar.setProgress(mCurrentPosition);

                //update current time text view
                TextView currentTime = (TextView) findViewById(R.id.currentTime);
                currentTime.setText(getTimeString(mCurrentPosition));

                //handle drag on seekbar
                seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {

                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {

                    }

                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                        if(mediaPlayer != null && fromUser){
                            mediaPlayer.seekTo(progress);
                        }
                    }
                });


            }

            //repeat above code every second
            mHandler.postDelayed(this, 10);
        }
    };
	



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
        }
        return super.onOptionsItemSelected(item);
    }



    public void play(View view){

            mediaPlayer.start();
    }


    public void pause(View view){

        mediaPlayer.pause();

    }

    public void stop(View view){
        duration=player.mediaPlayerDuration(totalTime,mediaPlayer);
        duration_played=player.mediaPlayerCurrentDuration(mediaPlayer);
        
        db.insertUsageActivity(player.getUserName(),
				module, submodule,type,db.getDateTime(),
				duration,duration_played,player.messageStatus(mediaPlayer),
				extras,MobiHealth.SYNC_STATUS_NEW);
        mediaPlayer.seekTo(0);
        mediaPlayer.pause();
        finish();
    }


    public void seekForward(View view){

        //set seek time
        int seekForwardTime = 5000;

        // get current song position
        int currentPosition = mediaPlayer.getCurrentPosition();
        // check if seekForward time is lesser than song duration
        if(currentPosition + seekForwardTime <= mediaPlayer.getDuration()){
            // forward song
            mediaPlayer.seekTo(currentPosition + seekForwardTime);
        }else{
            // forward to end position
            mediaPlayer.seekTo(mediaPlayer.getDuration());
        }

    }

    public void seekBackward(View view){

        //set seek time
        int seekBackwardTime = 5000;

        // get current song position
        int currentPosition = mediaPlayer.getCurrentPosition();
        // check if seekBackward time is greater than 0 sec
        if(currentPosition - seekBackwardTime >= 0){
            // forward song
            mediaPlayer.seekTo(currentPosition - seekBackwardTime);
        }else{
            // backward to starting position
            mediaPlayer.seekTo(0);
        }

    }


    public void onBackPressed(){
        super.onBackPressed();
        if (mediaPlayer != null) {
        	duration=player.mediaPlayerDuration(totalTime,mediaPlayer);
            duration_played=player.mediaPlayerCurrentDuration(mediaPlayer);      
            db.insertUsageActivity(player.getUserName(),module, submodule,type,db.getDateTime(),duration,duration_played,player.messageStatus(mediaPlayer),extras,MobiHealth.SYNC_STATUS_NEW);
            mediaPlayer.stop();
            //mediaPlayer.reset();
            mediaPlayer.release();
            mediaPlayer = null;
        }
        finish();
    }

    private String getTimeString(long millis) {
        StringBuffer buf = new StringBuffer();

        long hours = millis / (1000*60*60);
        long minutes = ( millis % (1000*60*60) ) / (1000*60);
        long seconds = ( ( millis % (1000*60*60) ) % (1000*60) ) / 1000;

        buf
                .append(String.format("%02d", hours))
                .append(":")
                .append(String.format("%02d", minutes))
                .append(":")
                .append(String.format("%02d", seconds));

        return buf.toString();
    }
}