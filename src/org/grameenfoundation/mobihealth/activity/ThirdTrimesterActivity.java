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

public class ThirdTrimesterActivity extends BaseActivity implements OnItemClickListener{
	
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
	    header.setText("3rd Trimester Messages");
	    Typeface custom_font = Typeface.createFromAsset(ThirdTrimesterActivity.this.getAssets(),
        	      "fonts/Roboto-MediumItalic.ttf");
	    header.setTypeface(custom_font);
	    String[] text={
	    		"Normal signs of pregnancy",
	    		"ANC",
	    		"Labor signs/Facility Delivery",
	    		"Breastfeeding",
	    		"PNC/Immunization",
	    		"Fonatelle/Cord care",
	    		"Warning signs of Pregnancy",
	    		"Handwashing"
	    	};
	    	
	    	int[] images={
	    		R.drawable.pregnancy,
	    		R.drawable.antenatal,
	    		R.drawable.labor_signs,
	    		R.drawable.breastfeeding,
	    		R.drawable.immunization,
	    		R.drawable.fonatelle,
	    		R.drawable.warning_signs,
	    		R.drawable.handwashing
	    	};
	    TrimesterListViewAdapter adapter=new TrimesterListViewAdapter(ThirdTrimesterActivity.this,text,images);
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
			//intent=new Intent(ThirdTrimesterActivity.this, ThirdTrimesterNormalSignsAudioGallery.class);
			intent=new Intent(ThirdTrimesterActivity.this, AudioGalleryActivity.class);
			type="Audio";
			submodule="Normal Signs of Pregnancy";
			module=MobiHealth.MODULE_PREGNANCY_MESSAGES;
			extras=MobiHealth.EXTRAS_THIRD_TRIMESTER;
			 eweLocation="Ewe Pregnancy Messages/3rd Trimester/Normal Signs of Pregnancy";
			 englishLocation="English Pregancy Messages/3rd Trimester/Normal Signs of Pregnancy";
			 intent.putExtra(MobiHealth.TYPE, type);
				intent.putExtra(MobiHealth.SUB_MODULE, submodule);
				intent.putExtra(MobiHealth.MODULE, module);
				intent.putExtra(MobiHealth.EXTRAS,extras);
				intent.putExtra(MobiHealth.EWE_AUDIO_LOCATION, eweLocation);
				intent.putExtra(MobiHealth.ENGLISH_AUDIO_LOCATION, englishLocation);
			startActivity(intent);
			break;
		case 1:
			//intent=new Intent(ThirdTrimesterActivity.this, ThirdTrimesterANCAudioGallery.class);
			intent=new Intent(ThirdTrimesterActivity.this, AudioGalleryActivity.class);
			type="Audio";
			submodule="ANC";
			module=MobiHealth.MODULE_PREGNANCY_MESSAGES;
			extras=MobiHealth.EXTRAS_THIRD_TRIMESTER;
			 eweLocation="Ewe Pregnancy Messages/3rd Trimester/ANC";
			 englishLocation="English Pregancy Messages/3rd Trimester/ANC";
			 intent.putExtra(MobiHealth.TYPE, type);
				intent.putExtra(MobiHealth.SUB_MODULE, submodule);
				intent.putExtra(MobiHealth.MODULE, module);
				intent.putExtra(MobiHealth.EXTRAS,extras);
				intent.putExtra(MobiHealth.EWE_AUDIO_LOCATION, eweLocation);
				intent.putExtra(MobiHealth.ENGLISH_AUDIO_LOCATION, englishLocation);
			startActivity(intent);
			break;
		case 2:
			//intent=new Intent(ThirdTrimesterActivity.this, ThirdTrimesterLaborSignsAudioGallery.class);
			intent=new Intent(ThirdTrimesterActivity.this, AudioGalleryActivity.class);
			type="Audio";
			submodule="Labor Signs and facility delivery";
			module=MobiHealth.MODULE_PREGNANCY_MESSAGES;
			extras=MobiHealth.EXTRAS_THIRD_TRIMESTER;
			 eweLocation="Ewe Pregnancy Messages/3rd Trimester/Labor Signs and facility delivery";
			 englishLocation="English Pregancy Messages/3rd Trimester/Labor Signs and facility delivery";
			 intent.putExtra(MobiHealth.TYPE, type);
				intent.putExtra(MobiHealth.SUB_MODULE, submodule);
				intent.putExtra(MobiHealth.MODULE, module);
				intent.putExtra(MobiHealth.EXTRAS,extras);
				intent.putExtra(MobiHealth.EWE_AUDIO_LOCATION, eweLocation);
				intent.putExtra(MobiHealth.ENGLISH_AUDIO_LOCATION, englishLocation);
			startActivity(intent);
			break;
		case 3:
			//intent=new Intent(ThirdTrimesterActivity.this, ThirdTrimesterBreastfeedingAudioGallery.class);
			intent=new Intent(ThirdTrimesterActivity.this, AudioGalleryActivity.class);
			type="Audio";
			submodule="Breastfeeding";
			module=MobiHealth.MODULE_PREGNANCY_MESSAGES;
			extras=MobiHealth.EXTRAS_THIRD_TRIMESTER;
			 eweLocation="Ewe Pregnancy Messages/3rd Trimester/Breastfeeding";
			 englishLocation="English Pregancy Messages/3rd Trimester/Breastfeeding";
			 intent.putExtra(MobiHealth.TYPE, type);
				intent.putExtra(MobiHealth.SUB_MODULE, submodule);
				intent.putExtra(MobiHealth.MODULE, module);
				intent.putExtra(MobiHealth.EXTRAS,extras);
				intent.putExtra(MobiHealth.EWE_AUDIO_LOCATION, eweLocation);
				intent.putExtra(MobiHealth.ENGLISH_AUDIO_LOCATION, englishLocation);
			startActivity(intent);
			break;
		case 4:
			//intent=new Intent(ThirdTrimesterActivity.this, ThirdTrimesterPNCAudioGallery.class);
			intent=new Intent(ThirdTrimesterActivity.this, AudioGalleryActivity.class);
			type="Audio";
			submodule="PNC and Immunization";
			module=MobiHealth.MODULE_PREGNANCY_MESSAGES;
			extras=MobiHealth.EXTRAS_THIRD_TRIMESTER;
			 eweLocation="Ewe Pregnancy Messages/3rd Trimester/PNC and Immunization";
			 englishLocation="English Pregancy Messages/3rd Trimester/PNC and Immunization";
			 intent.putExtra(MobiHealth.TYPE, type);
				intent.putExtra(MobiHealth.SUB_MODULE, submodule);
				intent.putExtra(MobiHealth.MODULE, module);
				intent.putExtra(MobiHealth.EXTRAS,extras);
				intent.putExtra(MobiHealth.EWE_AUDIO_LOCATION, eweLocation);
				intent.putExtra(MobiHealth.ENGLISH_AUDIO_LOCATION, englishLocation);
			startActivity(intent);
			break;
		case 5:
			//intent=new Intent(ThirdTrimesterActivity.this, ThirdTrimesterFonatelleAudioGallery.class);
			intent=new Intent(ThirdTrimesterActivity.this, AudioGalleryActivity.class);
			type="Audio";
			submodule="Fontanelle and Cord Care";
			module=MobiHealth.MODULE_PREGNANCY_MESSAGES;
			extras=MobiHealth.EXTRAS_THIRD_TRIMESTER;
			 eweLocation="Ewe Pregnancy Messages/3rd Trimester/Fontanelle and Cord Care";
			 englishLocation="English Pregancy Messages/3rd Trimester/Fontanelle and Cord Care";
			 intent.putExtra(MobiHealth.TYPE, type);
				intent.putExtra(MobiHealth.SUB_MODULE, submodule);
				intent.putExtra(MobiHealth.MODULE, module);
				intent.putExtra(MobiHealth.EXTRAS,extras);
				intent.putExtra(MobiHealth.EWE_AUDIO_LOCATION, eweLocation);
				intent.putExtra(MobiHealth.ENGLISH_AUDIO_LOCATION, englishLocation);
			startActivity(intent);
			break;
		case 6:
			//intent=new Intent(ThirdTrimesterActivity.this, ThirdTrimesterWarningSignsAudioGallery.class);
			intent=new Intent(ThirdTrimesterActivity.this, AudioGalleryActivity.class);
			type="Audio";
			submodule="Warning Signs of Pregnancy";
			module=MobiHealth.MODULE_PREGNANCY_MESSAGES;
			extras=MobiHealth.EXTRAS_THIRD_TRIMESTER;
			 eweLocation="Ewe Pregnancy Messages/3rd Trimester/Warning Sign of Pregnancy";
			 englishLocation="English Pregancy Messages/3rd Trimester/Warning Sign of Pregnancy";
			 intent.putExtra(MobiHealth.TYPE, type);
				intent.putExtra(MobiHealth.SUB_MODULE, submodule);
				intent.putExtra(MobiHealth.MODULE, module);
				intent.putExtra(MobiHealth.EXTRAS,extras);
				intent.putExtra(MobiHealth.EWE_AUDIO_LOCATION, eweLocation);
				intent.putExtra(MobiHealth.ENGLISH_AUDIO_LOCATION, englishLocation);
			startActivity(intent);
			break;
		case 7:
			//intent=new Intent(ThirdTrimesterActivity.this, ThirdTrimesterHandWashingAudioGallery.class);
			intent=new Intent(ThirdTrimesterActivity.this, AudioGalleryActivity.class);
			type="Audio";
			submodule="Handwashing";
			module=MobiHealth.MODULE_PREGNANCY_MESSAGES;
			extras=MobiHealth.EXTRAS_THIRD_TRIMESTER;
			 eweLocation="Ewe Pregnancy Messages/3rd Trimester/Handwashing";
			 englishLocation="English Pregancy Messages/3rd Trimester/Handwashing";
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
