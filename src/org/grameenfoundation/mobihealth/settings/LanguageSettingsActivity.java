package org.grameenfoundation.mobihealth.settings;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.grameenfoundation.mobihealth.R;
import org.grameenfoundation.mobihealth.activity.MenuActivity;
import org.grameenfoundation.mobihealth.activity.NewPatientRegistrationActivity;
import org.grameenfoundation.mobihealth.activity.WelcomeActivity;
import org.grameenfoundation.mobihealth.adapter.SettingMenuBaseAdapter;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class LanguageSettingsActivity extends Activity implements OnItemClickListener {

	private RadioButton languageEnglishButton;
	private RadioButton languageEweButton;
	private RadioGroup languageOptions;
	private ListView listView;
	private ImageButton dialogButton;
	private RegistrationTask task;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.settings_menu);
	    listView=(ListView) findViewById(R.id.listView1);
	    listView.setOnItemClickListener(this);
	    String[] values={"Language options","Edit profile information","Register Client","Logout"};
	    int[] images={R.drawable.language,
	    			 R.drawable.ic_action_edit,
	    			 R.drawable.ic_people,
	    			 R.drawable.ic_action_system};
	    SettingMenuBaseAdapter adapter=new SettingMenuBaseAdapter(LanguageSettingsActivity.this,values,images);
	    listView.setAdapter(adapter);
	}

	
	
	public void Dialog(){
		final Dialog dialog = new Dialog(LanguageSettingsActivity.this);
		dialog.setContentView(R.layout.language_settings_activity);
		dialog.setTitle("Select a language");
	    
	    languageOptions=(RadioGroup) dialog.findViewById(R.id.language_options);
	    languageEnglishButton=(RadioButton) dialog.findViewById(R.id.language_english);
	    languageEweButton=(RadioButton) dialog.findViewById(R.id.language_ewe);
        
		dialogButton =(ImageButton) dialog.findViewById(R.id.imageButton1);
		dialogButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				dialog.dismiss();
				if(languageOptions.getCheckedRadioButtonId()==R.id.language_english){
					SharedPreferences myPrefs = LanguageSettingsActivity.this.getSharedPreferences("myPrefs", MODE_WORLD_READABLE);
					SharedPreferences.Editor prefsEditor = myPrefs.edit();
					prefsEditor.putString("option", "English");
					prefsEditor.commit();
					 Intent mainIntent = new Intent(LanguageSettingsActivity.this,MenuActivity.class);
					 LanguageSettingsActivity.this.startActivity(mainIntent);
					 LanguageSettingsActivity.this.finish();
				}else if(languageOptions.getCheckedRadioButtonId()==R.id.language_ewe){
					SharedPreferences myPrefs = LanguageSettingsActivity.this.getSharedPreferences("myPrefs", MODE_WORLD_READABLE);
					SharedPreferences.Editor prefsEditor = myPrefs.edit();
					prefsEditor.putString("option", "Ewe");
					prefsEditor.commit();
					Intent mainIntent = new Intent(LanguageSettingsActivity.this,MenuActivity.class);
					 LanguageSettingsActivity.this.startActivity(mainIntent);
					 LanguageSettingsActivity.this.finish();
				}

			}
		});
				dialog.show();	
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		switch(position){
		case 0:
			Dialog();
			break;
			
		case 1:
		
			
			// task=new RegistrationTask();
			 /*
			 String value="staffId="+URLEncoder.encode("1")+
	 					"&facilityId="+URLEncoder.encode("414")+
	 					"&regMode="+URLEncoder.encode("PREGNANT_MOTHER")+
	 					"&firstName="+URLEncoder.encode("Florence")+
	 					"&middleName="+URLEncoder.encode("Lomotiorkor")+
	 					"&lastName="+URLEncoder.encode("Jones")+
	 					"&dob="+URLEncoder.encode("15-08-1990")+
	 					"&estimatedDob="+URLEncoder.encode("FALSE")+
	 					"&nhisNumber="+URLEncoder.encode("1234567")+
	 					"&nhisExpiryDate="+URLEncoder.encode("15-09-2014")+
	 					"&region="+URLEncoder.encode("Greater Accra")+
	 					"&address="+URLEncoder.encode("Accra")+
	 					"&phoneNumber"+URLEncoder.encode("233540827309")+
	 					"&username="+URLEncoder.encode("admin")+
	 					"&password="+URLEncoder.encode("P@ssword");
	 					*/
			// task.execute( "http://41.190.69.163:8080/ghana-national-web/registerPatient");
			 
			break;
		case 2:	
			Intent mainIntent = new Intent(LanguageSettingsActivity.this,NewPatientRegistrationActivity.class);
			 LanguageSettingsActivity.this.startActivity(mainIntent);
			 LanguageSettingsActivity.this.finish();
			break;
		}
		
	}
	

private static class RegistrationTask extends AsyncTask<String, Void, String> {
 	String message="";

	@Override
    protected String doInBackground(String... urls) {
     
		for (String url : urls) {
			DefaultHttpClient httpclient = new DefaultHttpClient();
			    HttpPost httppost = new HttpPost(url);
		
			    try {
			        // Add your data
			        List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
			        nameValuePairs.add(new BasicNameValuePair("staffId", "1"));
			        nameValuePairs.add(new BasicNameValuePair("facilityId", "414"));
			        nameValuePairs.add(new BasicNameValuePair("regMode", "PREGNANT_MOTHER"));
			        nameValuePairs.add(new BasicNameValuePair("firstName", "Florence"));
			        nameValuePairs.add(new BasicNameValuePair("middleName", "Lomotiorkor"));
			        nameValuePairs.add(new BasicNameValuePair("lastName", "Jones"));
			        nameValuePairs.add(new BasicNameValuePair("dob", "15-08-1990"));
			        nameValuePairs.add(new BasicNameValuePair("estimatedDob", "FALSE"));
			        nameValuePairs.add(new BasicNameValuePair("nhisNumber", "1234567"));
			        nameValuePairs.add(new BasicNameValuePair("nhisExpiryDate", "15-09-2014"));
			        nameValuePairs.add(new BasicNameValuePair("region", "Greater Accra"));
			        nameValuePairs.add(new BasicNameValuePair("address", "Accra"));
			        nameValuePairs.add(new BasicNameValuePair("phoneNumber", "233540827309"));
			        nameValuePairs.add(new BasicNameValuePair("username", "admin"));
			        nameValuePairs.add(new BasicNameValuePair("password", "P@ssw0rd"));
			        httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));

			        HttpResponse execute = httpclient.execute(httppost);
					InputStream content = execute.getEntity().getContent();

					BufferedReader buffer = new BufferedReader(
							new InputStreamReader(content));
					String s = "";
					while ((s = buffer.readLine()) != null) {
						message += s;
					}

				} catch (Exception e) {
					e.printStackTrace();
				}
		}
		return message;
	}
	
	
		@Override
		protected void onPostExecute(String result) {
			/*
			 try{
		            JSONArray jArray = new JSONArray(result);
		            for(int i=0; i < jArray.length(); i++) {

		                JSONObject jObject = jArray.getJSONObject(i);

		                String message = jObject.getString("rc");
		                System.out.println(message);
		            //    Toast.makeText(LanguageSettingsActivity.this,message, Toast.LENGTH_LONG).show();
		            } // End Loop
		         

		        } catch (JSONException e) {

		            Log.e("JSONException", "Error: " + e.toString());

		        } 
		}
		*/
			System.out.println(result);
	}
}

}
