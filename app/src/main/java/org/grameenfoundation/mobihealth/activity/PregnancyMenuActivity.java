package org.grameenfoundation.mobihealth.activity;

import java.io.File;

import org.grameenfoundation.mobihealth.R;
import org.grameenfoundation.mobihealth.adapter.NewListViewBaseAdapter;
import org.grameenfoundation.mobihealth.database.MobiHealthDatabaseHelper;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;

public class PregnancyMenuActivity extends Activity implements OnItemClickListener{

	private ListView listView;
	
	int[] images={
			R.drawable.first_trimester,
			R.drawable.second_trimester,
			R.drawable.third_trimester
		};

	private TextView header;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.pregnancy_menu_activity);
	    header=(TextView) findViewById(R.id.textView1);
	    header.setText("Pregnancy Messages");
	    Typeface custom_font = Typeface.createFromAsset(PregnancyMenuActivity.this.getAssets(),
        	      "fonts/Roboto-MediumItalic.ttf");
	    header.setTypeface(custom_font);
	    listView=(ListView) findViewById(R.id.pregnancy_menu_listView);
	    String[] values={"1st Trimester","2nd Trimester","3rd Trimester"};
	    NewListViewBaseAdapter adapter=new NewListViewBaseAdapter(PregnancyMenuActivity.this,values,images);
	   listView.setAdapter(adapter);
	   listView.setOnItemClickListener(this);
	}

	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.action_bar_all, menu);
        return super.onCreateOptionsMenu(menu);
    }

   @Override
   public boolean onOptionsItemSelected(MenuItem item) {
       // Handle presses on the action bar items
       switch (item.getItemId()) {
           case R.id.action_logout:
   			AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
   					PregnancyMenuActivity.this);
	 
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
							 Intent intent=new Intent(PregnancyMenuActivity.this, WelcomeActivity.class);
								startActivity(intent);
								PregnancyMenuActivity.this.finish();
							
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
				
               return true;
               
           case R.id.action_home:
        	   Intent goHome = new Intent(Intent.ACTION_MAIN);
 	          goHome.setClass(PregnancyMenuActivity.this, MenuActivity.class);
 	          goHome.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
 	          startActivity(goHome);
 	          finish();
 	         
        	   return true;
           default:
               return super.onOptionsItemSelected(item);
       }
   }
	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		Intent intent;
		switch (position){
		case 0:
			intent=new Intent(PregnancyMenuActivity.this, FirstTrimesterActivity.class);
			startActivity(intent);
			break;
		case 1	:
			intent=new Intent(PregnancyMenuActivity.this, SecondTrimesterActivity.class);
			startActivity(intent);
			break;
		case 2:
			intent=new Intent(PregnancyMenuActivity.this, ThirdTrimesterActivity.class);
			startActivity(intent);
			break;
		}
		
	}



}
