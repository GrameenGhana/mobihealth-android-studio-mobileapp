package org.grameenfoundation.mobihealth.activity;

import org.grameenfoundation.mobihealth.R;
import org.grameenfoundation.mobihealth.database.MobiHealthDatabaseHandler;
import org.grameenfoundation.mobihealth.tasks.UserDetailsTask;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class WelcomeActivity extends Activity {

    private static final int SPLASH_DISPLAY_LENGTH = 3000;
	private MobiHealthDatabaseHandler db;
	private int logInCheck;
	
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);      
        TextView header = (TextView)findViewById(R.id.textView1);
	      Typeface custom_font = Typeface.createFromAsset(getAssets(),
	      "fonts/Roboto-MediumItalic.ttf");
	      header.setTypeface(custom_font);
	      header.setTextSize(24);
	      header.setTextColor(Color.rgb(238,106,80));
	      header.setText("Loading....");
	    
	      //create an instance of the database
	      db=new MobiHealthDatabaseHandler(WelcomeActivity.this);
	      //check if user is logged in
	      logInCheck=db.getRowLoginActivityCount();
	     
        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
            	//if user is not logged in then create the user table with data and open login screen
              UserDetailsTask task=new UserDetailsTask(WelcomeActivity.this);
              task.execute();
              finish();
            }																									
        }, SPLASH_DISPLAY_LENGTH);
    }
    


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.welcome, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    
    
	
	

		
}