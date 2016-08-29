package org.grameenfoundation.mobihealth.application;

import android.content.Context;
import android.media.MediaPlayer;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;

public class TelephonyStateListener extends PhoneStateListener {

	
    private boolean isPaused;
	private Player player;
	MediaPlayer mediaplayer;
    
    public TelephonyStateListener(Context context,MediaPlayer mediaplayer)
	{
		context=MobiHealth.getAppContext();
		 player=new Player(context,mediaplayer);
		 this.mediaplayer=mediaplayer;
	}

	@Override
    public void onCallStateChanged(int state, String incomingNumber) {
        if (state == TelephonyManager.CALL_STATE_RINGING) {
            //Incoming call: Pause music
            boolean s = isPaused;
            mediaplayer.pause();
            isPaused = s; // Want to restore the state before we paused for phone call.
        } else if(state == TelephonyManager.CALL_STATE_IDLE) {
            //Not in call: Play music
            if(isPaused == true) {
            	mediaplayer.pause();
            }
            else {
                if(!player.isPlaying(mediaplayer)) { // Only start if it's not currently started.
                	mediaplayer.start();
                }
            }
        } else if(state == TelephonyManager.CALL_STATE_OFFHOOK) {
            //A call is dialing, active or on hold. Pause music
            boolean s = isPaused;
            mediaplayer.pause();
            isPaused = s; // Want to restore the state before we paused for phone call.
        }
        super.onCallStateChanged(state, incomingNumber);
    }
}
