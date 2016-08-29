package org.grameenfoundation.mobihealth.tasks;

import org.grameenfoundation.mobihealth.activity.LoginActivity;
import org.grameenfoundation.mobihealth.activity.MenuActivity;
import org.grameenfoundation.mobihealth.activity.WelcomeActivity;
import org.grameenfoundation.mobihealth.database.MobiHealthDatabaseHandler;
import org.json.JSONArray;
import org.json.JSONException;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.preference.PreferenceManager;

public class UserDetailsTask  extends AsyncTask<String, String, String>{
	private MobiHealthDatabaseHandler db;
	private Context ctx;
	private int logInCheck;
	
	
	public UserDetailsTask(Context ctx) {
		this.ctx = ctx;
		
	}
	@Override
	protected String doInBackground(String... params) {
		db=new MobiHealthDatabaseHandler(ctx);
		 logInCheck=db.getRowLoginActivityCount();
		  if (logInCheck <= 0){
			  
		   db.insertUserTable("Florence Jones", "florence.jones", "admin", "BEREKUSO CHPS", "Akporkplorto");
       	   db.insertUserTable("Augustina Yirenkyi", "augustina.yirenkyi", "admin", "BEREKUSO CHPS", "Akporkplorto");
       	   db.insertUserTable("Patience Ahadzi", "patience.ahadzi", "12197", "Vida Adjokatse", "Akporkplorto");
       	   db.insertUserTable("Gifty Sossah", "gifty.sossah", "12204", "Courage Adjei", "Agbeve");
       	   db.insertUserTable("Adorkanu Doris", "adorkanu.doris", "12215", "Vasty Sedziafa", "Adigblikope");
       	   db.insertUserTable("Bertha Wormadey", "bertha.wormadey", "12227", "Genevieve Sakpetor", "Tsatukope");
       	   db.insertUserTable("Victoria Madugu", "victoria.madugu", "12236", "Courage Adjei", "Kuve");
       	   db.insertUserTable("Fauster Assumah", "fauster.assumah", "12243", "Vasty Sedziafa", "Kua");
       	   db.insertUserTable("Martin Kofi Kpodo", "martin.kpodo", "12258", "Genevieve Sakpetor", "Tadze");
       	   
       	   db.insertUserTable("Zormelo Esinam", "zormelo.esinam", "12262", "Sandra Amenu", "Tsavanya");
       	   db.insertUserTable("Benedicta Agawu", "benedicta.agawu", "12270", "Carolina Senyetor", "Dekpevia");
       	   db.insertUserTable("Patience Adzornya", "patience.adzornya", "12289", "Frank Adevu", "Besakope");
       	   db.insertUserTable("Kodzo Vivor", "kodzo.vivor", "12291", "Stella Nuque", "Dorkploame");
       	   db.insertUserTable("Richard Gakpo", "richard.gakpo", "12301", "Stella Nuque", "Tokpo");
       	   db.insertUserTable("Lily Awuya", "lily.awuya", "12317", "Frank Adevu", "Awuyakope");
       	   db.insertUserTable("Reindoff Amu", "reindoff.amu", "12329", "Sandra Amenu", "Tordzinu");
       	   
       	   db.insertUserTable("Adjei Gbeve Mawuli", "adjei.mawuli", "12338", "Esther Yamoah", "Dalive");
       	   db.insertUserTable("Gloria Dorgbenu", "gloria.dorgbenu", "12340", "Esther Yamoah", "Nusetor");
       	   db.insertUserTable("Tsikudo Nanana Sam", "tsikudo.sam", "12355", "Doris Gbeku", "Tsikudokope");
       	   db.insertUserTable("Rejoice Kpetigo", "rejoice.kpetigo", "12364", "Doris Gbeku", "Adidokope");
       	   db.insertUserTable("Caroline Narteh", "caroline.narteh", "12372", "Esther Yamoah", "Amusukope");
       	   db.insertUserTable("Robert Etse Aglago", "robert.aglago", "12386", "Esther Yamoah", "Wetorkor");
       	   db.insertUserTable("Seth Atsu Aglago", "seth.aglago", "12393", "Esther Yamoah", "Torzikpota");
       	   db.insertUserTable("Admin Admin", "admin", "admin", "BEREKUSO CHPS", "Torzikpota");
       	   
       	   db.insertChpsNurse("Genevieve Sakpetor", "0245749128", "Genevieve Sakpetor");
       	   db.insertChpsNurse("Vida Adjokatse", "0245749444", "Vida Adjokatse");
       	   db.insertChpsNurse("Vasty Sedziafa", "0245750376", "Vasty Sedziafa");
       	   db.insertChpsNurse("Courage Adjei", "0504316061", "Courage Adjei");
       	   db.insertChpsNurse("Courage Adjei", "0504316059", "Courage Adjei");// new nurse Xoese Gagakuma
       	   db.insertChpsNurse("Sandra Amenu", "0245749081", "Sandra Amenu");
       	   db.insertChpsNurse("Stella Nuque", "0549356784", "Stella Nuque");
       	   db.insertChpsNurse("Frank Adevu", "0245750097", "Frank Adevu");
       	   db.insertChpsNurse("Carolina Senyetor", "0245748108", "Carolina Senyetor");
       	   db.insertChpsNurse("Esther Yamoah", "0245748870", "Esther Yamoah");
       	   db.insertChpsNurse("Doris Gbeku", "0547737518", "Doris Gbeku");
       	   
       	   db.insertChpsNurse("John Doe", "0540827309", "BEREKUSO CHPS");
       	   db.insertChpsNurse("John Doe", "0269845566", "BEREKUSO CHPS");
       	   db.insertChpsNurse("John Doe", "0540100773", "BEREKUSO CHPS");
       	   
       	   
       	   db.insertChpsNurse("Victoria Kpelly", "0544064037", "DALIVE CHPS");
       	   db.insertChpsNurse("Victoria Kpelly", "0544064037", "ASIDOWUI CHPS");
       	   db.insertChpsNurse("Victoria Kpelly", "0544064037", "DORKPLOAME CHPS");
       	   
       	   db.insertChpsNurse("Ellen Sarpong-Akorsah", "0245810949", "DALIVE CHPS");
       	   db.insertChpsNurse("Ellen Sarpong-Akorsah", "0245810949", "ASIDOWUI CHPS");
       	   db.insertChpsNurse("Ellen Sarpong-Akorsah", "0245810949", "DORKPLOAME CHPS");
       	   
       	   db.insertChpsNurse("Alfred", "0540829699", "DALIVE CHPS");
       	   db.insertChpsNurse("Alfred", "0540829699", "ASIDOWUI CHPS");
       	   db.insertChpsNurse("Alfred", "0540829699", "DORKPLOAME CHPS");
       	   Intent mainIntent = new Intent(ctx,LoginActivity.class);
       	   ctx.startActivity(mainIntent);
		  }else{
       	   //take the user to the main menu
       	   Intent mainIntent = new Intent(ctx,MenuActivity.class);
              ctx.startActivity(mainIntent);

          }
		return null;
	}
	 @Override
     protected void onPostExecute(String result) {
	
     }
}
