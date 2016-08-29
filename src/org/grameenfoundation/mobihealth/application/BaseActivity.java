package org.grameenfoundation.mobihealth.application;

import java.io.File;

import org.grameenfoundation.mobihealth.R;
import org.grameenfoundation.mobihealth.activity.MenuActivity;
import org.grameenfoundation.mobihealth.activity.WelcomeActivity;
import org.grameenfoundation.mobihealth.database.MobiHealthDatabaseHelper;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class BaseActivity  extends Activity{
	Context mContext;


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
	    // Inflate the menu items for use in the action bar
	    MenuInflater inflater = getMenuInflater();
	    inflater.inflate(R.menu.action_bar_all, menu);
	    return super.onCreateOptionsMenu(menu);
	}
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
	
		Intent intent;
	    switch (item.getItemId()) {
	        case R.id.action_home:
	        	 Intent goHome = new Intent(Intent.ACTION_MAIN);
	 	          goHome.setClass(BaseActivity.this, MenuActivity.class);
	 	          goHome.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
	 	          startActivity(goHome);
	 	          finish();
	 	         
	            return true;
	        	
        case R.id.action_logout:
        	logout();
        	
        	return true;
	        default:
	            return super.onOptionsItemSelected(item);
	    }
	
	
	}
	
	private void logout() {
		AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
				BaseActivity.this);
 
			// set title
			alertDialogBuilder.setTitle("Logout");
 
			// set dialog message
			alertDialogBuilder
				.setMessage("You will be logged out.Continue?")
				.setCancelable(false)
				.setIcon(R.drawable.ic_warning)
				.setPositiveButton("Yes",new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog,int id) {
						 getBaseContext().deleteDatabase(MobiHealthDatabaseHelper.DATABASE_NAME);
						 String filePath = getApplicationContext().getFilesDir().getPath()+"/"+"shared_prefs/loginPrefs.xml";
						 File deletePrefFile = new File(filePath );
						  deletePrefFile.delete();
						  dialog.cancel();
						 Intent intent=new Intent(BaseActivity.this, WelcomeActivity.class);
							startActivity(intent);
							BaseActivity.this.finish();
						
					}
				  })
				.setNegativeButton("No",new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog,int id) {
						  dialog.cancel();
						
					}
				});
 
				// create alert dialog
				AlertDialog alertDialog = alertDialogBuilder.create();
 
				// show it
				alertDialog.show();
			
	}
}
