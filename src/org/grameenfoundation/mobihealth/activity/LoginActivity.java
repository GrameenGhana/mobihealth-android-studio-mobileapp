package org.grameenfoundation.mobihealth.activity;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.grameenfoundation.mobihealth.R;
import org.grameenfoundation.mobihealth.application.MobiHealth;
import org.grameenfoundation.mobihealth.database.MobiHealthDatabaseHandler;
import org.grameenfoundation.mobihealth.settings.LanguageSettingsActivity;






import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.format.Time;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends Activity implements OnClickListener{

	private EditText username;
	private EditText password;
	private String username_entered;
	private String password_entered;
	private MobiHealthDatabaseHandler db;
	private ArrayList<String> values;
	private String current_time;
	private String current_date;
	private Button login_button;
	private Intent intent;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.login_activity);
	    //create an instance of the database handler class
	   db=new MobiHealthDatabaseHandler(LoginActivity.this);
	    username=(EditText) findViewById(R.id.editUsername);
	    password=(EditText) findViewById(R.id.editPassword);
	  
	    login_button=(Button) findViewById(R.id.button1);
	    login_button.setOnClickListener(this);
	    
	    //take system date and time
	    Time time = new Time();
	    time.setToNow();
	    current_time= time.hour +":"+time.minute;
	    current_date=time.monthDay +"-" +time.month + "-" +time.year;
	    
	}
	
	//verify log in details of user
	public void verifyLoginDetails(){
		String verified_username = null;
		String verified_password = null;
		String fullname = null;
		String[] split_fullname;
		String firstname = null;
		String chps_zone = null;
		String community=null;
		
		// if log in details exist then assign them to variables
		values=db.verifyLogin(username_entered, password_entered);
		if(values.size()!=0){
			verified_username=values.get(0);
			verified_password=values.get(1);
			fullname=values.get(2);
			split_fullname=fullname.split(" ");
			firstname=split_fullname[0];
			chps_zone=values.get(3);
			community=values.get(4);		
		}else{
			System.out.println("Unknown values");
		}
		
		//if log in details match those from the database them add them to a shared preferences file for easy access
		if(username_entered.equalsIgnoreCase(verified_username) &&password_entered.equalsIgnoreCase(verified_password)){
			String status="logged in";
			db.insertLoginActivity(current_date, current_time, verified_username, verified_password, status,MobiHealth.SYNC_STATUS_NEW);
			SharedPreferences myPrefs = LoginActivity.this.getSharedPreferences("loginPrefs", MODE_WORLD_READABLE);
			SharedPreferences.Editor prefsEditor = myPrefs.edit();
			prefsEditor.putString("fname", firstname);
			prefsEditor.putString("fullname", fullname);
			prefsEditor.putString("chps_zone", chps_zone);
			prefsEditor.putString("community", community);
			prefsEditor.putString("username",verified_username);
			prefsEditor.commit();
			intent=new Intent(LoginActivity.this, MenuActivity.class);
			startActivity(intent);
			finish();
		}	else if (values.size()==0){
			AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
					LoginActivity.this);
	 
				// set title
				alertDialogBuilder.setTitle("Sign in");
	 
				// set dialog message
				alertDialogBuilder
					.setMessage("Login incorrect. Please try again")
					.setCancelable(false)
					.setIcon(R.drawable.ic_error)
					.setPositiveButton("Cancel",new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog,int id) {
							// if this button is clicked, close
							// current activity
							LoginActivity.this.finish();
						}
					  })
					.setNegativeButton("Ok",new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog,int id) {
							// if this button is clicked, just close
							// the dialog box and do nothing
							dialog.cancel();
						}
					});
	 
					// create alert dialog
					AlertDialog alertDialog = alertDialogBuilder.create();
	 
					// show it
					alertDialog.show();
				}
		}
		
		
	
	
	@Override
	public void onClick(View v) {
		switch(v.getId()){
		case R.id.button1:
		    username_entered=username.getText().toString();
		    password_entered=password.getText().toString();
		    //calling login verification method
			verifyLoginDetails();
			break;
		}
		
	}

}
