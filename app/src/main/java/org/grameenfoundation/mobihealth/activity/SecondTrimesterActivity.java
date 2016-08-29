package org.grameenfoundation.mobihealth.activity;

import java.io.File;

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
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;

import org.grameenfoundation.mobihealth.R;
import org.grameenfoundation.mobihealth.adapter.TrimesterListViewAdapter;
import org.grameenfoundation.mobihealth.application.BaseActivity;
import org.grameenfoundation.mobihealth.application.MobiHealth;
import org.grameenfoundation.mobihealth.database.MobiHealthDatabaseHelper;

public class SecondTrimesterActivity extends BaseActivity implements OnItemClickListener{
	private ListView listView;
	private TextView header;
	private String type;
	private String submodule;
	private String module;
	private String extras;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.trimester_menu_activity);
	    listView=(ListView) findViewById(R.id.pregnancy_menu_listView);
	    header=(TextView) findViewById(R.id.textView1);
	    header.setText("2nd Trimester Messages");
	    Typeface custom_font = Typeface.createFromAsset(SecondTrimesterActivity.this.getAssets(),
        	      "fonts/Roboto-MediumItalic.ttf");
	    header.setTypeface(custom_font);
	    String[] text={
	    		"Birth Preparedness/Facility Delivery",
	    		"Warning Signs of Pregnancy",
	    		"Malaria & Antenatal Care",
	    		"Nutrition",
	    		"Hygiene/Sex/Food safety"
	    	};
	    	
	    	int[] images={
	    		R.drawable.birth_preparedness,
	    		R.drawable.warning_signs,
	    		R.drawable.pregnancymalaria,
	    		R.drawable.nutrition,
	    		R.drawable.handwashing
	    	};
	    TrimesterListViewAdapter adapter=new TrimesterListViewAdapter(SecondTrimesterActivity.this,text,images);
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
			//intent=new Intent(SecondTrimesterActivity.this, SecondTrimesterBirthPreparednessAudioGallery.class);
			intent=new Intent(SecondTrimesterActivity.this, AudioGalleryActivity.class);
			type="Audio";
			submodule="Birth Preparedness";
			module=MobiHealth.MODULE_PREGNANCY_MESSAGES;
			extras=MobiHealth.EXTRAS_SECOND_TRIMESTER;
			 eweLocation="Ewe Pregnancy Messages/2nd Trimester/Birth Preparedness";
			 englishLocation="English Pregancy Messages/2nd Trimester/Birth Preparedness";
			 intent.putExtra(MobiHealth.TYPE, type);
				intent.putExtra(MobiHealth.SUB_MODULE, submodule);
				intent.putExtra(MobiHealth.MODULE, module);
				intent.putExtra(MobiHealth.EXTRAS,extras);
				intent.putExtra(MobiHealth.EWE_AUDIO_LOCATION, eweLocation);
				intent.putExtra(MobiHealth.ENGLISH_AUDIO_LOCATION, englishLocation);
			startActivity(intent);
			break;
		case 1:
			//intent=new Intent(SecondTrimesterActivity.this, SecondTrimesterWarningSignsAudioGallery.class);
			intent=new Intent(SecondTrimesterActivity.this, AudioGalleryActivity.class);
			type="Audio";
			submodule="Warning signs of pregnancy";
			module=MobiHealth.MODULE_PREGNANCY_MESSAGES;
			extras=MobiHealth.EXTRAS_SECOND_TRIMESTER;
			 eweLocation="Ewe Pregnancy Messages/2nd Trimester/Danger or Warning signs of pregnancy";
			 englishLocation="English Pregancy Messages/2nd Trimester/Danger or Warning signs of pregnancy";
			 intent.putExtra(MobiHealth.TYPE, type);
				intent.putExtra(MobiHealth.SUB_MODULE, submodule);
				intent.putExtra(MobiHealth.MODULE, module);
				intent.putExtra(MobiHealth.EXTRAS,extras);
				intent.putExtra(MobiHealth.EWE_AUDIO_LOCATION, eweLocation);
				intent.putExtra(MobiHealth.ENGLISH_AUDIO_LOCATION, englishLocation);
			startActivity(intent);
			break;
		case 2:
			//intent=new Intent(SecondTrimesterActivity.this, SecondTrimesterMalariaAudioGallery.class);
			intent=new Intent(SecondTrimesterActivity.this, AudioGalleryActivity.class);
			type="Audio";
			submodule="Malaria and ANC";
			module=MobiHealth.MODULE_PREGNANCY_MESSAGES;
			extras=MobiHealth.EXTRAS_SECOND_TRIMESTER;
			 eweLocation="Ewe Pregnancy Messages/2nd Trimester/Malaria and ANC";
			 englishLocation="English Pregancy Messages/2nd Trimester/Malaria and ANC";
			 intent.putExtra(MobiHealth.TYPE, type);
				intent.putExtra(MobiHealth.SUB_MODULE, submodule);
				intent.putExtra(MobiHealth.MODULE, module);
				intent.putExtra(MobiHealth.EXTRAS,extras);
				intent.putExtra(MobiHealth.EWE_AUDIO_LOCATION, eweLocation);
				intent.putExtra(MobiHealth.ENGLISH_AUDIO_LOCATION, englishLocation);
			startActivity(intent);
			break;
		case 3:
			//intent=new Intent(SecondTrimesterActivity.this, SecondTrimesterNutritionAudioGallery.class);
			intent=new Intent(SecondTrimesterActivity.this, AudioGalleryActivity.class);
			type="Audio";
			submodule="Nutrition";
			module=MobiHealth.MODULE_PREGNANCY_MESSAGES;
			extras=MobiHealth.EXTRAS_SECOND_TRIMESTER;
			 eweLocation="Ewe Pregnancy Messages/2nd Trimester/Nutrition";
			 englishLocation="English Pregancy Messages/2nd Trimester/Nutrition";
			 intent.putExtra(MobiHealth.TYPE, type);
				intent.putExtra(MobiHealth.SUB_MODULE, submodule);
				intent.putExtra(MobiHealth.MODULE, module);
				intent.putExtra(MobiHealth.EXTRAS,extras);
				intent.putExtra(MobiHealth.EWE_AUDIO_LOCATION, eweLocation);
				intent.putExtra(MobiHealth.ENGLISH_AUDIO_LOCATION, englishLocation);
			startActivity(intent);
			break;
		case 4:
			//intent=new Intent(SecondTrimesterActivity.this, SecondTrimesterHygieneAudioGallery.class);
			intent=new Intent(SecondTrimesterActivity.this, AudioGalleryActivity.class);
			type="Audio";
			submodule="Hygiene,sex and food safety";
			module=MobiHealth.MODULE_PREGNANCY_MESSAGES;
			extras=MobiHealth.EXTRAS_SECOND_TRIMESTER;
			 eweLocation="Ewe Pregnancy Messages/2nd Trimester/Hygiene, sex and food safety";
			 englishLocation="English Pregancy Messages/2nd Trimester/Hygiene, sex and food safety";
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
