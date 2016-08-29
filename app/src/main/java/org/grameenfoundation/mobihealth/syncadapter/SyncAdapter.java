package org.grameenfoundation.mobihealth.syncadapter;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.grameenfoundation.mobihealth.application.MobiHealth;
import org.grameenfoundation.mobihealth.database.MobiHealthDatabaseHandler;
import org.grameenfoundation.mobihealth.model.UsageTracking;
import org.grameenfoundation.mobihealth.model.User;
import org.grameenfoundation.mobihealth.syncadapter.SyncService.RegistrationTask;

import android.accounts.Account;
import android.content.AbstractThreadedSyncAdapter;
import android.content.ContentProviderClient;
import android.content.ContentResolver;
import android.content.Context;
import android.content.SyncResult;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;

public class SyncAdapter extends AbstractThreadedSyncAdapter {
	// Global variables
    // Define a variable to contain a content resolver instance
	private static MobiHealthDatabaseHandler db;
	private int UsageSyncCount;
	private RegistrationTask task;
	 private static Context mContext;
	
	private static SyncAdapter sSyncAdapter = null;
	 private static ContentResolver mContentResolver = null;
	 
	private static int LoginsyncCount;
    /**
     * Set up the sync adapter
     */
    public SyncAdapter(Context context, boolean autoInitialize) {
        super(context, autoInitialize);
     
    }
   
    /**
     * Set up the sync adapter. This form of the
     * constructor maintains compatibility with Android 3.0
     * and later platform versions
     */
    public SyncAdapter(
            Context context,
            boolean autoInitialize,
            boolean allowParallelSyncs) {
        super(context, autoInitialize, allowParallelSyncs);
        mContext = context;
       
    }
    
    @Override
    public void onPerformSync(Account account,Bundle extras,String authority,ContentProviderClient provider,SyncResult syncResult) {
    	 mContentResolver = mContext.getContentResolver();
    	 db=new MobiHealthDatabaseHandler(mContext);
		  task=new RegistrationTask();
		  LoginsyncCount=db.getAllLoginActivity();
			    UsageSyncCount=db.getRowUsageActivityCount();
			    RegistrationTask task = new RegistrationTask();
			    LoginSyncTask task2 = new LoginSyncTask();
		 
    }
    
    class RegistrationTask extends AsyncTask<String, Void, String> {
     	String message="";
		private HttpResponse execute;

    	@Override
        protected String doInBackground(String... urls) {
         
    		for (String url : urls) {
    			 try {
 			    	if(UsageSyncCount!=0){
 			    		ArrayList<UsageTracking> usageTracking=db.getUsageActivity();
 			 	    for(int i=0;i<usageTracking.size();i++){
 			 	    	DefaultHttpClient httpclient = new DefaultHttpClient();
 	    			    HttpPost httppost = new HttpPost(url);
 			 	    	 List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
 					        nameValuePairs.add(new BasicNameValuePair("user_name", usageTracking.get(i).getUsername()));
 					        nameValuePairs.add(new BasicNameValuePair("module", usageTracking.get(i).getModule()));
 					        nameValuePairs.add(new BasicNameValuePair("sub_module",usageTracking.get(i).getSubModule()));
 					        nameValuePairs.add(new BasicNameValuePair("duration", usageTracking.get(i).getDuration()));
 					        nameValuePairs.add(new BasicNameValuePair("duration_played", usageTracking.get(i).getDurationPlayed()));
 					        nameValuePairs.add(new BasicNameValuePair("action_date", usageTracking.get(i).getActionDate()));
 					        nameValuePairs.add(new BasicNameValuePair("type", usageTracking.get(i).getType()));
 					        nameValuePairs.add(new BasicNameValuePair("status", usageTracking.get(i).getStatus()));
 					        nameValuePairs.add(new BasicNameValuePair("extras", usageTracking.get(i).getExtras()));
 					        nameValuePairs.add(new BasicNameValuePair("_token", "<?php echo csrf_token(); ?>"));
 					        httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
 					        System.out.println(nameValuePairs.toString());
 					        execute = httpclient.execute(httppost);
 			 	    }
 			 	    }
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
    		System.out.println(message);
    		if(message.equals("Saved!")){
    			//db.updateUsageActivitySyncStatus(MobiHealth.SYNC_STATUS_OLD);
    		}
    	}
    }
    
    static class LoginSyncTask extends AsyncTask<String, Void, String> {
     	String message="";
		private HttpResponse execute;

    	@Override
        protected String doInBackground(String... urls) {
         
    		for (String url : urls) {
    			    try {
    			    	if(LoginsyncCount!=0){
    			 	    	ArrayList<User> logindata=db.getLoginActivity();
    			 	    for(int i=0;i<logindata.size();i++){
    			 	    	DefaultHttpClient httpclient = new DefaultHttpClient();
    	    			    HttpPost httppost = new HttpPost(url);
    			 	    	 List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
    					        nameValuePairs.add(new BasicNameValuePair("user_name", logindata.get(i).getUsername()));
    					        nameValuePairs.add(new BasicNameValuePair("date_logged_in", logindata.get(i).getLoginDate()));
    					        nameValuePairs.add(new BasicNameValuePair("time_logged_in",logindata.get(i).getLoginTime()));
    					        httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
    					        execute = httpclient.execute(httppost);
    			 	    }
    			 	    }
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
    		System.out.println(result);
    		if(result.equals("Inserted!")){
    			db.updateLoginActivitySyncStatus(MobiHealth.SYNC_STATUS_OLD);
    		}
    	}
	}
  
}