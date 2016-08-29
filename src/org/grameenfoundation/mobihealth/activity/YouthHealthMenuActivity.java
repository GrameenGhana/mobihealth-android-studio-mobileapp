package org.grameenfoundation.mobihealth.activity;

import java.io.File;

import org.grameenfoundation.mobihealth.R;
import org.grameenfoundation.mobihealth.adapter.TrimesterListViewAdapter;
import org.grameenfoundation.mobihealth.application.BaseActivity;
import org.grameenfoundation.mobihealth.application.MobiHealth;
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
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class YouthHealthMenuActivity extends BaseActivity implements OnItemClickListener{

	private ListView listView;
	private TextView header;
	private String type;
	private String submodule;
	private String module;
	private String extras;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.pregnancy_menu_activity);
	    
	    listView=(ListView) findViewById(R.id.pregnancy_menu_listView);
	    String[] values={"Abstinence",
	    		"Rape",
	    		"Teenage Pregnancy"};
	    int[] images={R.drawable.abstinence,
	    		R.drawable.rape,
	    		R.drawable.teenage_pregnancy};
	    header=(TextView) findViewById(R.id.textView1);
	    header.setText("Youth Sexual Health Messages");
	    Typeface custom_font = Typeface.createFromAsset(YouthHealthMenuActivity.this.getAssets(),
        	      "fonts/Roboto-MediumItalic.ttf");
	    header.setTypeface(custom_font);
	    TrimesterListViewAdapter adapter=new TrimesterListViewAdapter(YouthHealthMenuActivity.this,values,images);
	   listView.setAdapter(adapter);
	   listView.setOnItemClickListener(this);
	}

	

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		Intent intent;
		String eweLocation;
		String englishLocation;
		switch (position){
		case 0:
			//intent=new Intent(YouthHealthMenuActivity.this, YouthHealthAbstinenceAudioGallery.class);
			intent=new Intent(YouthHealthMenuActivity.this, AudioGalleryActivity.class);
			type="Audio";
			submodule="Abstinence";
			module=MobiHealth.MODULE_YOUTH_SEXUAL_HEALTH;
			extras=" ";
			 eweLocation="Ewe Health Drama Series/Abstinence";
			 englishLocation="English Health Drama Series/Abstinence";
			 intent.putExtra(MobiHealth.TYPE, type);
				intent.putExtra(MobiHealth.SUB_MODULE, submodule);
				intent.putExtra(MobiHealth.MODULE, module);
				intent.putExtra(MobiHealth.EXTRAS,extras);
				intent.putExtra(MobiHealth.EWE_AUDIO_LOCATION, eweLocation);
				intent.putExtra(MobiHealth.ENGLISH_AUDIO_LOCATION, englishLocation);
			startActivity(intent);
			break;
		case 1	:
			//intent=new Intent(YouthHealthMenuActivity.this, YouthHealthRapeAudioGallery.class);
			intent=new Intent(YouthHealthMenuActivity.this, AudioGalleryActivity.class);
			type="Audio";
			submodule="Rape";
			module=MobiHealth.MODULE_YOUTH_SEXUAL_HEALTH;
			extras="";
			 eweLocation="Ewe Health Drama Series/Rape";
			 englishLocation="English Health Drama Series/Rape";
			 intent.putExtra(MobiHealth.TYPE, type);
				intent.putExtra(MobiHealth.SUB_MODULE, submodule);
				intent.putExtra(MobiHealth.MODULE, module);
				intent.putExtra(MobiHealth.EXTRAS,extras);
				intent.putExtra(MobiHealth.EWE_AUDIO_LOCATION, eweLocation);
				intent.putExtra(MobiHealth.ENGLISH_AUDIO_LOCATION, englishLocation);
			startActivity(intent);
			break;
		case 2:
			//intent=new Intent(YouthHealthMenuActivity.this, YouthHealthTeenagePregnancyAudioGallery.class);
			intent=new Intent(YouthHealthMenuActivity.this, AudioGalleryActivity.class);
			type="Audio";
			submodule="Teenage pregnancy";
			module=MobiHealth.MODULE_YOUTH_SEXUAL_HEALTH;
			extras=" ";
			 eweLocation="Ewe Health Drama Series/Teenage pregnancy";
			 englishLocation="English Health Drama Series/Teenage pregnancy";
			 intent.putExtra(MobiHealth.TYPE, type);
				intent.putExtra(MobiHealth.SUB_MODULE, submodule);
				intent.putExtra(MobiHealth.MODULE, module);
				intent.putExtra(MobiHealth.EXTRAS,extras);
				intent.putExtra(MobiHealth.EWE_AUDIO_LOCATION, eweLocation);
				intent.putExtra(MobiHealth.ENGLISH_AUDIO_LOCATION, englishLocation);
			startActivity(intent);
			break;	
		}	
	}
	
}
