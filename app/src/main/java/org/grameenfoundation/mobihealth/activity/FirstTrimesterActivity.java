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
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import org.grameenfoundation.mobihealth.R;
import org.grameenfoundation.mobihealth.adapter.TrimesterListViewAdapter;
import org.grameenfoundation.mobihealth.application.BaseActivity;
import org.grameenfoundation.mobihealth.application.MobiHealth;
import org.grameenfoundation.mobihealth.database.MobiHealthDatabaseHelper;

public class FirstTrimesterActivity extends BaseActivity implements OnItemClickListener{
	private TextView header;
	private ListView listView;
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
	    int[] images={
	    		R.drawable.pregnancy,
	    		R.drawable.nutrition,
	    		R.drawable.pregnancy_normal,
	    		R.drawable.malaria_in_pregnancy,
	    		R.drawable.danger_signs_pregnancy,
	    		R.drawable.medicine
	    	};
	    String[] text={
	    		"ANC",
	    		"Nutrition",
	    		"Normal Signs of Pregnancy",
	    		"Malaria during Pregnancy",
	    		"Danger signs of Pregnancy",
	    		"Medicine Awareness/Facility Delivery"
	    	};
	    header=(TextView) findViewById(R.id.textView1);
	    header.setText("1st Trimester Messages");
	    Typeface custom_font = Typeface.createFromAsset(FirstTrimesterActivity.this.getAssets(),
        	      "fonts/Roboto-MediumItalic.ttf");
	    header.setTypeface(custom_font);
	    TrimesterListViewAdapter adapter=new TrimesterListViewAdapter(FirstTrimesterActivity.this,text,images);
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
			//intent=new Intent(FirstTrimesterActivity.this, FirstTrimesterAudioGallery.class);
			intent=new Intent(FirstTrimesterActivity.this, AudioGalleryActivity.class);
			type="Audio";
			submodule="ANC";
			module=MobiHealth.MODULE_PREGNANCY_MESSAGES;
			extras=MobiHealth.EXTRAS_FIRST_TRIMESTER;
			 eweLocation="Ewe Pregnancy Messages/1st Trimester/ANC";
			 englishLocation="English Pregancy Messages/1st Trimester/ANC";
			 intent.putExtra(MobiHealth.TYPE, type);
				intent.putExtra(MobiHealth.SUB_MODULE, submodule);
				intent.putExtra(MobiHealth.MODULE, module);
				intent.putExtra(MobiHealth.EXTRAS,extras);
				intent.putExtra(MobiHealth.EWE_AUDIO_LOCATION, eweLocation);
				intent.putExtra(MobiHealth.ENGLISH_AUDIO_LOCATION, englishLocation);
			startActivity(intent);
			break;
		case 1:
			//intent=new Intent(FirstTrimesterActivity.this, FirstTrimesterNutritionAudioGallery.class);
			intent=new Intent(FirstTrimesterActivity.this, AudioGalleryActivity.class);
			type="Audio";
			submodule="Normal Signs of Pregnancy";
			module=MobiHealth.MODULE_PREGNANCY_MESSAGES;
			extras=MobiHealth.EXTRAS_FIRST_TRIMESTER;
			 eweLocation="Ewe Pregnancy Messages/1st Trimester/Nutrition";
			 englishLocation="English Pregancy Messages/1st Trimester/Nutrition";
			 intent.putExtra(MobiHealth.TYPE, type);
				intent.putExtra(MobiHealth.SUB_MODULE, submodule);
				intent.putExtra(MobiHealth.MODULE, module);
				intent.putExtra(MobiHealth.EXTRAS,extras);
				intent.putExtra(MobiHealth.EWE_AUDIO_LOCATION, eweLocation);
				intent.putExtra(MobiHealth.ENGLISH_AUDIO_LOCATION, englishLocation);
			startActivity(intent);
			break;
		case 2:
			//intent=new Intent(FirstTrimesterActivity.this, FirstTrimesterNormalSignsAudioGallery.class);
			intent=new Intent(FirstTrimesterActivity.this, AudioGalleryActivity.class);
			type="Audio";
			submodule="Normal Signs of Pregnancy";
			module=MobiHealth.MODULE_PREGNANCY_MESSAGES;
			extras=MobiHealth.EXTRAS_FIRST_TRIMESTER;			
			 eweLocation="Ewe Pregnancy Messages/1st Trimester/Normal Signs of Pregnancy";
			 englishLocation="English Pregancy Messages/1st Trimester/Normal Signs of Pregnancy";
			 intent.putExtra(MobiHealth.TYPE, type);
				intent.putExtra(MobiHealth.SUB_MODULE, submodule);
				intent.putExtra(MobiHealth.MODULE, module);
				intent.putExtra(MobiHealth.EXTRAS,extras);
				intent.putExtra(MobiHealth.EWE_AUDIO_LOCATION, eweLocation);
				intent.putExtra(MobiHealth.ENGLISH_AUDIO_LOCATION, englishLocation);
			startActivity(intent);
			break;
		case 3:
			//intent=new Intent(FirstTrimesterActivity.this, FirstTrimesterMalariaAudioGallery.class);
			intent=new Intent(FirstTrimesterActivity.this, AudioGalleryActivity.class);
			type="Audio";
			submodule="Malaria during Pregnancy";
			module=MobiHealth.MODULE_PREGNANCY_MESSAGES;
			extras=MobiHealth.EXTRAS_FIRST_TRIMESTER;
			 eweLocation="Ewe Pregnancy Messages/1st Trimester/Malaria during Pregnancy";
			 englishLocation="English Pregancy Messages/1st Trimester/Malaria during Pregnancy";
			 intent.putExtra(MobiHealth.TYPE, type);
				intent.putExtra(MobiHealth.SUB_MODULE, submodule);
				intent.putExtra(MobiHealth.MODULE, module);
				intent.putExtra(MobiHealth.EXTRAS,extras);
				intent.putExtra(MobiHealth.EWE_AUDIO_LOCATION, eweLocation);
				intent.putExtra(MobiHealth.ENGLISH_AUDIO_LOCATION, englishLocation);
			startActivity(intent);
			break;
		case 4:
			//intent=new Intent(FirstTrimesterActivity.this, FirstTrimesterDangerSignsAudioGallery.class);
			intent=new Intent(FirstTrimesterActivity.this, AudioGalleryActivity.class);
			type="Audio";
			submodule="Danger Signs of Pregnancy";
			module=MobiHealth.MODULE_PREGNANCY_MESSAGES;
			extras=MobiHealth.EXTRAS_FIRST_TRIMESTER;
			 eweLocation="Ewe Pregnancy Messages/1st Trimester/Danger Signs of Pregnancy";
			 englishLocation="English Pregancy Messages/1st Trimester/Danger Signs of Pregnancy";
			 intent.putExtra(MobiHealth.TYPE, type);
				intent.putExtra(MobiHealth.SUB_MODULE, submodule);
				intent.putExtra(MobiHealth.MODULE, module);
				intent.putExtra(MobiHealth.EXTRAS,extras);
				intent.putExtra(MobiHealth.EWE_AUDIO_LOCATION, eweLocation);
				intent.putExtra(MobiHealth.ENGLISH_AUDIO_LOCATION, englishLocation);
			startActivity(intent);
			break;
		case 5:
			//intent=new Intent(FirstTrimesterActivity.this, FirstTrimesterMedicineAwarenessAudioGallery.class);
			intent=new Intent(FirstTrimesterActivity.this, AudioGalleryActivity.class);
			type="Audio";
			submodule="Medicine Awareness and Facility Delivery";
			module=MobiHealth.MODULE_PREGNANCY_MESSAGES;
			extras=MobiHealth.EXTRAS_FIRST_TRIMESTER;
			 eweLocation="Ewe Pregnancy Messages/1st Trimester/Facility Delivery and Medicine Awareness";
			 englishLocation="English Pregancy Messages/1st Trimester/Facility Delivery and Medicine Awareness";
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
