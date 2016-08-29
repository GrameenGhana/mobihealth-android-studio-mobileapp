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
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class ChildCareMenu extends BaseActivity implements OnItemClickListener{

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
	    setContentView(R.layout.pregnancy_menu_activity);
	    
	    listView=(ListView) findViewById(R.id.pregnancy_menu_listView);
	    String[] values={"Acute Respiratory Infection and Pneumonia",
	    		"Danger Signs in Newborns",
	    		"Family Planning",
	    		"Healthcare Utilization during PNC",
	    		"Immunization",
	    		"Malaria during Infancy",
	    		"Newborn and Infant Care",
	    		"Nutrition and Breastfeeding",
	    		"Personal Care during Motherhood and Developing Baby",
	    		"Treatment of Diarhoea"};
	    
	    int[] images={R.drawable.respiratory,
	    			  R.drawable.danger_signs_pregnancy,
	    			  R.drawable.family_planning,
	    			  R.drawable.healthcare,
	    			  R.drawable.immunization,
	    			  R.drawable.malaria_infancy,
	    			  R.drawable.birth_preparedness,
	    			  R.drawable.breastfeeding,
	    			  R.drawable.motherhood,
	    			  R.drawable.diarhoea};
	    TrimesterListViewAdapter adapter=new TrimesterListViewAdapter(ChildCareMenu.this,values,images);
	   listView.setAdapter(adapter);				
	   listView.setOnItemClickListener(this);
	   
	   header=(TextView) findViewById(R.id.textView1);
	    header.setText("Baby's 1st year Messages");
	    Typeface custom_font = Typeface.createFromAsset(ChildCareMenu.this.getAssets(),
       	      "fonts/Roboto-MediumItalic.ttf");
	    header.setTypeface(custom_font);
	}


	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		Intent intent;
		String eweLocation;
		String englishLocation;
		switch (position){
		case 0:
			intent=new Intent(ChildCareMenu.this, AudioGalleryActivity.class);
			type="Audio";
			submodule="Acute respiratory infection and Pneumonia";
			module=MobiHealth.MODULE_BABY_FIRST_YEAR;
			extras=" ";
			 eweLocation="Ewe Baby 1st Year Messages/Acute respiratory infection and Pneumonia";
			 englishLocation="English Baby 1st Year Messages/Acute respiratory infection and Pneumonia";
			intent.putExtra(MobiHealth.TYPE, type);
			intent.putExtra(MobiHealth.SUB_MODULE, submodule);
			intent.putExtra(MobiHealth.MODULE, module);
			intent.putExtra(MobiHealth.EXTRAS,extras);
			intent.putExtra(MobiHealth.EWE_AUDIO_LOCATION, eweLocation);
			intent.putExtra(MobiHealth.ENGLISH_AUDIO_LOCATION, englishLocation);
			startActivity(intent);
			break;
		case 1	:
			//intent=new Intent(ChildCareMenu.this, ChildCareDangerSignsAudioGallery.class);
			intent=new Intent(ChildCareMenu.this, AudioGalleryActivity.class);
			type="Audio";
			submodule="Danger signs in newborns";
			module=MobiHealth.MODULE_BABY_FIRST_YEAR;
			extras=" ";
			 eweLocation="Ewe Baby 1st Year Messages/Danger signs in newborns";
			 englishLocation="English Baby 1st Year Messages/Danger signs in newborns";
			 intent.putExtra(MobiHealth.TYPE, type);
				intent.putExtra(MobiHealth.SUB_MODULE, submodule);
				intent.putExtra(MobiHealth.MODULE, module);
				intent.putExtra(MobiHealth.EXTRAS,extras);
				intent.putExtra(MobiHealth.EWE_AUDIO_LOCATION, eweLocation);
				intent.putExtra(MobiHealth.ENGLISH_AUDIO_LOCATION, englishLocation);
			startActivity(intent);
			break;
		case 2:
			//intent=new Intent(ChildCareMenu.this, ChildCareFamilyPlanningAudioGallery.class);
			intent=new Intent(ChildCareMenu.this, AudioGalleryActivity.class);
			type="Audio";
			submodule="Family planning";
			module=MobiHealth.MODULE_BABY_FIRST_YEAR;
			extras=" ";
			 eweLocation="Ewe Baby 1st Year Messages/Family planning";
			 englishLocation="English Baby 1st Year Messages/Family planning";
			 intent.putExtra(MobiHealth.TYPE, type);
				intent.putExtra(MobiHealth.SUB_MODULE, submodule);
				intent.putExtra(MobiHealth.MODULE, module);
				intent.putExtra(MobiHealth.EXTRAS,extras);
				intent.putExtra(MobiHealth.EWE_AUDIO_LOCATION, eweLocation);
				intent.putExtra(MobiHealth.ENGLISH_AUDIO_LOCATION, englishLocation);
			startActivity(intent);
			break;
		case 3:
			//intent=new Intent(ChildCareMenu.this, ChildCarePNCAudioGallery.class);
			intent=new Intent(ChildCareMenu.this, AudioGalleryActivity.class);
			type="Audio";
			submodule="Healthcare utilization during PNC";
			module=MobiHealth.MODULE_BABY_FIRST_YEAR;
			extras=" ";
			 eweLocation="Ewe Baby 1st Year Messages/Healthcare utililization during PNC";
			 englishLocation="English Baby 1st Year Messages/Healthcare utililization during PNC";
			 intent.putExtra(MobiHealth.TYPE, type);
				intent.putExtra(MobiHealth.SUB_MODULE, submodule);
				intent.putExtra(MobiHealth.MODULE, module);
				intent.putExtra(MobiHealth.EXTRAS,extras);
				intent.putExtra(MobiHealth.EWE_AUDIO_LOCATION, eweLocation);
				intent.putExtra(MobiHealth.ENGLISH_AUDIO_LOCATION, englishLocation);
			startActivity(intent);
			break;
		case 4:
			//intent=new Intent(ChildCareMenu.this, ChildCareImmunizationAudioGallery.class);
			intent=new Intent(ChildCareMenu.this, AudioGalleryActivity.class);
			type="Audio";
			module=MobiHealth.MODULE_BABY_FIRST_YEAR;
			submodule="Immunization";
			extras=" ";
			 eweLocation="Ewe Baby 1st Year Messages/Immunization";
			 englishLocation="English Baby 1st Year Messages/Immunization";
			 intent.putExtra(MobiHealth.TYPE, type);
				intent.putExtra(MobiHealth.SUB_MODULE, submodule);
				intent.putExtra(MobiHealth.MODULE, module);
				intent.putExtra(MobiHealth.EXTRAS,extras);
				intent.putExtra(MobiHealth.EWE_AUDIO_LOCATION, eweLocation);
				intent.putExtra(MobiHealth.ENGLISH_AUDIO_LOCATION, englishLocation);
			startActivity(intent);
			break;
		case 5:
			//intent=new Intent(ChildCareMenu.this, ChildCareMalariaAudioGallery.class);
			intent=new Intent(ChildCareMenu.this, AudioGalleryActivity.class);
			type="Audio";
			submodule="Malaria during infancy";
			module=MobiHealth.MODULE_BABY_FIRST_YEAR;
			extras=" ";
			 eweLocation="Ewe Baby 1st Year Messages/Malaria during infancy";
			 englishLocation="English Baby 1st Year Messages/Malaria during infancy";
			 intent.putExtra(MobiHealth.TYPE, type);
				intent.putExtra(MobiHealth.SUB_MODULE, submodule);
				intent.putExtra(MobiHealth.MODULE, module);
				intent.putExtra(MobiHealth.EXTRAS,extras);
				intent.putExtra(MobiHealth.EWE_AUDIO_LOCATION, eweLocation);
				intent.putExtra(MobiHealth.ENGLISH_AUDIO_LOCATION, englishLocation);
			startActivity(intent);
			break;
		case 6:
			//intent=new Intent(ChildCareMenu.this, ChildCareInfantCareAudioGallery.class);
			intent=new Intent(ChildCareMenu.this, AudioGalleryActivity.class);
			type="Audio";
			module=MobiHealth.MODULE_BABY_FIRST_YEAR;
			submodule="Newborn and infant care";
			extras=" ";
			 eweLocation="Ewe Baby 1st Year Messages/Newborn and infant care";
			 englishLocation="English Baby 1st Year Messages/Newborn and infant care";
			 intent.putExtra(MobiHealth.TYPE, type);
				intent.putExtra(MobiHealth.SUB_MODULE, submodule);
				intent.putExtra(MobiHealth.MODULE, module);
				intent.putExtra(MobiHealth.EXTRAS,extras);
				intent.putExtra(MobiHealth.EWE_AUDIO_LOCATION, eweLocation);
				intent.putExtra(MobiHealth.ENGLISH_AUDIO_LOCATION, englishLocation);
			startActivity(intent);
			break;
		case 7:
			//intent=new Intent(ChildCareMenu.this, ChildCareNutritionAudioGallery.class);
			intent=new Intent(ChildCareMenu.this, AudioGalleryActivity.class);
			type="Audio";
			submodule="Nutrition and Breastfeeding";
			module=MobiHealth.MODULE_BABY_FIRST_YEAR;
			extras=" ";
			 eweLocation="Ewe Baby 1st Year Messages/Nutrition and Breastfeeding";
			 englishLocation="English Baby 1st Year Messages/Nutrition and Breastfeeding";
			 intent.putExtra(MobiHealth.TYPE, type);
				intent.putExtra(MobiHealth.SUB_MODULE, submodule);
				intent.putExtra(MobiHealth.MODULE, module);
				intent.putExtra(MobiHealth.EXTRAS,extras);
				intent.putExtra(MobiHealth.EWE_AUDIO_LOCATION, eweLocation);
				intent.putExtra(MobiHealth.ENGLISH_AUDIO_LOCATION, englishLocation);
			startActivity(intent);
			break;
		case 8:
			//intent=new Intent(ChildCareMenu.this, ChildCarePersonalCareAudioGallery.class);
			intent=new Intent(ChildCareMenu.this, AudioGalleryActivity.class);
			type="Audio";
			submodule="Personal care during motherhood and developing baby";
			module=MobiHealth.MODULE_BABY_FIRST_YEAR;
			extras=" ";
			 eweLocation="Ewe Baby 1st Year Messages/Personal care during motherhood and developing baby";
			 englishLocation="English Baby 1st Year Messages/Personal care during motherhood and developing baby";
			 intent.putExtra(MobiHealth.TYPE, type);
				intent.putExtra(MobiHealth.SUB_MODULE, submodule);
				intent.putExtra(MobiHealth.MODULE, module);
				intent.putExtra(MobiHealth.EXTRAS,extras);
				intent.putExtra(MobiHealth.EWE_AUDIO_LOCATION, eweLocation);
				intent.putExtra(MobiHealth.ENGLISH_AUDIO_LOCATION, englishLocation);
			startActivity(intent);
			break;
		case 9:
			intent=new Intent(ChildCareMenu.this, AudioGalleryActivity.class);
			type="Audio";
			module=MobiHealth.MODULE_BABY_FIRST_YEAR;
			submodule="Treatment of Diarhoea";
			extras=" ";
			 eweLocation="Ewe Baby 1st Year Messages/Treatment of Diarhoea";
			 englishLocation="English Baby 1st Year Messages/Treatment of Diarhoea";
			 intent.putExtra(MobiHealth.TYPE, type);
				intent.putExtra(MobiHealth.SUB_MODULE, submodule);
				intent.putExtra(MobiHealth.MODULE, module);
				intent.putExtra(MobiHealth.EXTRAS,extras);
				intent.putExtra(MobiHealth.EWE_AUDIO_LOCATION, eweLocation);
				intent.putExtra(MobiHealth.ENGLISH_AUDIO_LOCATION, englishLocation);
			//intent=new Intent(ChildCareMenu.this, ChildCareDiarhoeaAudioGallery.class);
			startActivity(intent);
			break;
			
		}
		
	}
	
	


}
