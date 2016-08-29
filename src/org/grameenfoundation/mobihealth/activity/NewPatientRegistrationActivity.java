package org.grameenfoundation.mobihealth.activity;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.grameenfoundation.mobihealth.R;
import org.grameenfoundation.mobihealth.application.BaseActivity;
import org.grameenfoundation.mobihealth.application.MobiHealth;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.FragmentManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.Spinner;
import android.widget.TableLayout;

public class NewPatientRegistrationActivity extends BaseActivity implements OnClickListener ,OnItemSelectedListener,OnItemClickListener, OnCheckedChangeListener {

	private static EditText staff_id;
	private EditText facility_id;
	private EditText reg_date;
	private Spinner reg_mode;
	private EditText motech_id;
	private Spinner client_type;
	private EditText first_name;
	private ImageView reg_date_calendar;
	private EditText middle_name;
	private EditText last_name;
	private EditText date_of_birth;
	private ImageView dob_calendar;
	private RadioGroup estimated_dob;
	private RadioGroup sex;
	private RadioGroup insured;
	private Spinner region;
	private EditText address;
	private EditText phone_number;
	private EditText nhis_number;
	private EditText nhis_expiry_date;
	private Button submit;
	private LinearLayout motech_id_layout;
	private LinearLayout gender_layout;
	private LinearLayout insured_layout;
	private String gender;
	private String selected_region;
	private String nhis_number_entered;
	private String nhis_expiry_date_entered;
	private ImageView expiry_date_calendar;
	private LinearLayout add_care_history_layout;
	private LinearLayout care_history_layout;
	private CheckBox vita_checkbox;
	private TableLayout vita_layout;
	private TableLayout IPTi_layout;
	private TableLayout BCG_layout;
	private TableLayout OPV_layout;
	private TableLayout penta_layout;
	private TableLayout measles_layout;
	private TableLayout YF_layout;
	private TableLayout rotavirus_layout;
	private TableLayout pneumococcal_layout;
	private TableLayout malaria_layout;
	private TableLayout diarrhoea_layout;
	private TableLayout pneumonia_layout;
	private CheckBox IPTi_checkbox;
	private CheckBox BCG_checkbox;
	private CheckBox OPV_checkbox;
	private CheckBox penta_checkbox;
	private CheckBox measles_checkbox;
	private CheckBox yf_checkbox;
	private CheckBox rotavirus_checkbox;
	private CheckBox pneumococcal_checkbox;
	private CheckBox malaria_checkbox;
	private CheckBox diarrhoea_checkbox;
	private CheckBox pneumonia_checkbox;
	private LoginSyncTask task;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.new_client_registration);
	    
	    	staff_id=(EditText) findViewById(R.id.editText_staffID);
	    	facility_id=(EditText) findViewById(R.id.editText_facilityID);
	    	reg_date=(EditText) findViewById(R.id.editText_regDate);
	    	reg_date_calendar=(ImageView) findViewById(R.id.imageView_regDate);
	    	reg_date_calendar.setOnClickListener(this);
	    	reg_mode=(Spinner) findViewById(R.id.spinner_regMode);
	    	populateRegModeSpinner();
	    	motech_id_layout=(LinearLayout) findViewById(R.id.LinearLayout_motechID);
	    	gender_layout=(LinearLayout) findViewById(R.id.LinearLayout_gender);
	    	insured_layout=(LinearLayout) findViewById(R.id.LinearLayout_insured);
	    	add_care_history_layout=(LinearLayout) findViewById(R.id.LinearLayout_addCareHistory);
	    	care_history_layout=(LinearLayout) findViewById(R.id.LinearLayout_careHistory);
	    	vita_layout=(TableLayout) findViewById(R.id.TableLayout_vitA);
	    	IPTi_layout=(TableLayout) findViewById(R.id.TableLayout_IPTi);
	    	BCG_layout=(TableLayout) findViewById(R.id.TableLayout_bcg);
	    	OPV_layout=(TableLayout) findViewById(R.id.TableLayout_OPV);
	    	penta_layout=(TableLayout) findViewById(R.id.TableLayout_penta);
	    	measles_layout=(TableLayout) findViewById(R.id.TableLayout_measles);
	    	YF_layout=(TableLayout) findViewById(R.id.TableLayout_yf);
	    	rotavirus_layout=(TableLayout) findViewById(R.id.TableLayout_rotavirus);
	    	pneumococcal_layout=(TableLayout) findViewById(R.id.TableLayout_pneumococcal);
	    	malaria_layout=(TableLayout) findViewById(R.id.TableLayout_malaria);
	    	diarrhoea_layout=(TableLayout) findViewById(R.id.TableLayout_diarrhoea);
	    	pneumonia_layout=(TableLayout) findViewById(R.id.TableLayout_pneumonia);
	    	vita_checkbox=(CheckBox) findViewById(R.id.checkBox_vitA);
	    	IPTi_checkbox=(CheckBox) findViewById(R.id.checkBox_IPTi);
	    	BCG_checkbox=(CheckBox) findViewById(R.id.checkBox_bcg);
	    	OPV_checkbox=(CheckBox) findViewById(R.id.checkBox_opv);
	    	penta_checkbox=(CheckBox) findViewById(R.id.checkBox_penta);
	    	measles_checkbox=(CheckBox) findViewById(R.id.checkBox_measles);
	    	yf_checkbox=(CheckBox) findViewById(R.id.checkBox_yf);
	    	rotavirus_checkbox=(CheckBox) findViewById(R.id.checkBox_rotavirus);
	    	pneumococcal_checkbox=(CheckBox) findViewById(R.id.checkBox_pneumococcal);
	    	malaria_checkbox=(CheckBox) findViewById(R.id.checkBox_malaria);
	    	diarrhoea_checkbox=(CheckBox) findViewById(R.id.checkBox_diarrhoea);
	    	pneumonia_checkbox=(CheckBox) findViewById(R.id.checkBox_pneumonia);
	    	reg_mode.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

	            @Override
	            public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long arg3) {
	            	switch(position){
	    			case 1:
	    				motech_id_layout.setVisibility(View.VISIBLE);
	    				break;
	    			}
	            }

	            @Override
	            public void onNothingSelected(AdapterView<?> arg0) {

	            }

	        });
	    	motech_id=(EditText) findViewById(R.id.editText_motechID);
	    	client_type=(Spinner) findViewById(R.id.spinner_clientType);
	    	populateClientTypeSpinner();
	    	client_type.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

	            @Override
	            public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long arg3) {
	            	switch(position){
	    			case 0:
	    				gender="Female";
	    				break;
	    			case 1:
	    				gender_layout.setVisibility(View.VISIBLE);
	    				add_care_history_layout.setVisibility(View.VISIBLE);
	    				care_history_layout.setVisibility(View.VISIBLE);
	    				if(sex.getCheckedRadioButtonId()==R.id.radio_female){
	    					gender="female";
	    				}else if(sex.getCheckedRadioButtonId()==R.id.radio_male){
	    					gender="male";
	    				}
	    				break;
	    			case 2:
	    				gender="Female";
	    				
	    				break;
	    			case 3:
	    				gender_layout.setVisibility(View.VISIBLE);
	    				
	    				if(sex.getCheckedRadioButtonId()==R.id.radio_female){
	    					gender="female";
	    				}else if(sex.getCheckedRadioButtonId()==R.id.radio_male){
	    					gender="male";
	    				}
	    				break;
	    		}
	            }
	            @Override
	            public void onNothingSelected(AdapterView<?> arg0) {

	            }
	            
	        });
	    	first_name=(EditText) findViewById(R.id.editText_firstName);
	    	middle_name=(EditText) findViewById(R.id.editText_middleName);
	    	last_name=(EditText) findViewById(R.id.editText_lastName);
	    	date_of_birth=(EditText) findViewById(R.id.editText_dob);
	    	dob_calendar=(ImageView) findViewById(R.id.imageView_dob);
	    	dob_calendar.setOnClickListener(this);
	    	expiry_date_calendar=(ImageView) findViewById(R.id.imageView_nhisExpiryDate);
	    	expiry_date_calendar.setOnClickListener(this);
	    	estimated_dob=(RadioGroup) findViewById(R.id.radioGroup_estimatedDob);
	    	sex=(RadioGroup) findViewById(R.id.radioGroup_sex);
	    	insured=(RadioGroup) findViewById(R.id.radioGroup_insured);
	    	insured.setOnCheckedChangeListener(this);
	    	region=(Spinner) findViewById(R.id.spinner_region);
	    	populateRegionSpinner();
	    	region.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

	            @Override
	            public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long arg3) {
	            	selected_region=region.getSelectedItem().toString();
	            }
	            @Override
	            public void onNothingSelected(AdapterView<?> arg0) {

	            }
	            
	        });
	    	address=(EditText) findViewById(R.id.editText_address);
	    	phone_number=(EditText) findViewById(R.id.editText_phoneNumber);
	    	nhis_number=(EditText) findViewById(R.id.editText_nhisNumber);
	    	nhis_expiry_date=(EditText) findViewById(R.id.editText_nhisExpiryDate);
	    	submit=(Button) findViewById(R.id.button_submit);
	    	submit.setOnClickListener(new OnClickListener(){

				@Override
				public void onClick(View v) {
					 task=new LoginSyncTask();
					 task.execute( "http://192.168.10.154:8080/motech-platform-server/module/ghananational/api/patients/welcome");
					
				}
	    		
	    	});
	    	//submit.setOnClickListener(this);
	    	
	}

	
	
	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		
		
	}

	@Override
	public void onItemSelected(AdapterView<?> parent, View view, int position,
			long id) {
		
	}

	@Override
	public void onNothingSelected(AdapterView<?> parent) {
		
		
	}

	public void onCheckBoxClicked(View view) {
	    // Is the view now checked?
	    boolean checked = ((CheckBox) view).isChecked();
	    
	    // Check which checkbox was clicked
	    switch(view.getId()) {
	        case R.id.checkBox_vitA:
	            if (checked)
	               vita_layout.setVisibility(View.VISIBLE);
	            else
	            	   vita_layout.setVisibility(View.GONE);
	            break;
	        case R.id.checkBox_IPTi:
	            if (checked)
	            	IPTi_layout.setVisibility(View.VISIBLE);
	            else
	            	IPTi_layout.setVisibility(View.GONE);
	            break;
	        case R.id.checkBox_bcg:
	            if (checked)
	            	BCG_layout.setVisibility(View.VISIBLE);
	            else
	            	BCG_layout.setVisibility(View.GONE);
	            break;
	        case R.id.checkBox_opv:
	            if (checked)
	            	OPV_layout.setVisibility(View.VISIBLE);
	            else
	            	OPV_layout.setVisibility(View.GONE);
	            break;
	        case R.id.checkBox_penta:
	            if (checked)
	            	penta_layout.setVisibility(View.VISIBLE);
	            else
	            	penta_layout.setVisibility(View.GONE);
	            break;
	        case R.id.checkBox_measles:
	            if (checked)
	            	measles_layout.setVisibility(View.VISIBLE);
	            else
	            	measles_layout.setVisibility(View.GONE);
	            break;
	        case R.id.checkBox_yf:
	            if (checked)
	            	YF_layout.setVisibility(View.VISIBLE);
	            else
	            	YF_layout.setVisibility(View.GONE);
	            break;
	        case R.id.checkBox_rotavirus:
	            if (checked)
	            	rotavirus_layout.setVisibility(View.VISIBLE);
	            else
	            	rotavirus_layout.setVisibility(View.GONE);
	            break;
	        case R.id.checkBox_pneumococcal:
	            if (checked)
	            	pneumococcal_layout.setVisibility(View.VISIBLE);
	            else
	            	pneumococcal_layout.setVisibility(View.GONE);
	            break;
	        case R.id.checkBox_malaria:
	            if (checked)
	            	malaria_layout.setVisibility(View.VISIBLE);
	            else
	            	malaria_layout.setVisibility(View.GONE);
	            break;
	        case R.id.checkBox_diarrhoea:
	            if (checked)
	            	diarrhoea_layout.setVisibility(View.VISIBLE);
	            else
	            	diarrhoea_layout.setVisibility(View.GONE);
	            break;
	        case R.id.checkBox_pneumonia:
	            if (checked)
	            	pneumonia_layout.setVisibility(View.VISIBLE);
	            else
	            	pneumonia_layout.setVisibility(View.GONE);
	            break;
	    }
	}


	@Override
	public void onClick(View v) {
	
		switch(v.getId()){
		case R.id.imageView_regDate:
			 // DialogFragment newFragment = new DatePickerRegDateFragment();
			  //  newFragment.show(getSupportFragmentManager(), "datePicker");
			break;
			
		case R.id.imageView_dob:
			// DialogFragment newFragment2 = new DatePickerDOBFragment();
			    //newFragment2.show(getSupportFragmentManager(), "datePicker");
			break;
			
		case R.id.imageView_nhisExpiryDate:
			// DialogFragment newFragment3 = new DatePickerNhisExpiryDateFragment();																	
			  //  newFragment3.show(getSupportFragmentManager(), "datePicker");
			break;
		case R.id.button_submit:
			 task=new LoginSyncTask();
			 task.execute( "http://192.168.10.154:8080/motech-platform-server/module/ghananational/api/patients/addPatient");
			break;
		}
		
	}
	
	public void populateRegionSpinner(){
	String[] regions={"Greater Accra Region",
						"Central Region",
						"Western Region",
						"Eastern Region",
						"Northern Region",
						"Upper East Region",
						"Upper West Region",
						"Brong Ahafo Region",
						"Volta Region",
						"Ashanti Region"};	
	ArrayAdapter<String> adapter=new ArrayAdapter<String>(NewPatientRegistrationActivity.this,android.R.layout.simple_list_item_1,regions);
	region.setAdapter(adapter);	
	}
	
	public void populateRegModeSpinner(){
		String[] reg_mode_items={"AUTO_GENERATED_ID",
									"USE_PREPRINTED_ID"};	
		ArrayAdapter<String> adapter=new ArrayAdapter<String>(NewPatientRegistrationActivity.this,android.R.layout.simple_list_item_1,reg_mode_items);
		reg_mode.setAdapter(adapter);	
		}
	
	public void populateClientTypeSpinner(){
		String[] reg_mode_items={"PREGNANT_MOTHER",
									"CHILD_UNDER_FIVE",
									"OTHER",
									"MOTHER_OF_INFANT"};	
		ArrayAdapter<String> adapter=new ArrayAdapter<String>(NewPatientRegistrationActivity.this,android.R.layout.simple_list_item_1,reg_mode_items);
		client_type.setAdapter(adapter);	
		}
	
	/*
	
	public class DatePickerRegDateFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener {

		private Calendar c;

		@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
			// Use the current date as the default date in the picker
			c = Calendar.getInstance();
			int year = c.get(Calendar.YEAR);
			int month = c.get(Calendar.MONTH);
			int day = c.get(Calendar.DAY_OF_MONTH);

			// Create a new instance of DatePickerDialog and return it
			return new DatePickerDialog(getActivity(), this, year, month, day);
}

		public void onDateSet(DatePicker view, int year, int month, int day) {          
			SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MMM-dd");
			reg_date.setText(format1.format((new StringBuilder().append(year+1).append("-")
																.append(month+1).append("-")
																.append(day))));
		}
	}
	
	public class DatePickerDOBFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener {

		private Calendar c;

		@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
			// Use the current date as the default date in the picker
			c = Calendar.getInstance();
			int year = c.get(Calendar.YEAR);
			int month = c.get(Calendar.MONTH);
			int day = c.get(Calendar.DAY_OF_MONTH);

			// Create a new instance of DatePickerDialog and return it
			return new DatePickerDialog(getActivity(), this, year, month, day);
}

		public void onDateSet(DatePicker view, int year, int month, int day) {          
			SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MMM-dd");
			date_of_birth.setText(format1.format((new StringBuilder().append(year+1).append("-")
																.append(month+1).append("-")
																.append(day))));
		}
	}
	
	public class DatePickerNhisExpiryDateFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener {

		private Calendar c;

		@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
			// Use the current date as the default date in the picker
			c = Calendar.getInstance();
			int year = c.get(Calendar.YEAR);
			int month = c.get(Calendar.MONTH);
			int day = c.get(Calendar.DAY_OF_MONTH);

			// Create a new instance of DatePickerDialog and return it
			return new DatePickerDialog(getActivity(), this, year, month, day);
}

		public void onDateSet(DatePicker view, int year, int month, int day) {          
			SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MMM-dd");
			nhis_expiry_date.setText(format1.format((new StringBuilder().append(year+1).append("-")
																.append(month+1).append("-")
																.append(day))));
		}
	}

	*/



	@Override
	public void onCheckedChanged(RadioGroup group, int checkedId) {
		switch(checkedId){
		case R.id.radio_yes:
			insured_layout.setVisibility(View.VISIBLE);
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
				    String staff_id_entered=staff_id.getText().toString();
				    try {
				        // Add your data
				        List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
				        nameValuePairs.add(new BasicNameValuePair("staffId", "1"));
				        nameValuePairs.add(new BasicNameValuePair("facilityId", "414"));
				        //nameValuePairs.add(new BasicNameValuePair("regMode", "PREGNANT_MOTHER"));
				        nameValuePairs.add(new BasicNameValuePair("firstName", "Florence"));
				        nameValuePairs.add(new BasicNameValuePair("middleName", "Lomotiorkor"));
				        nameValuePairs.add(new BasicNameValuePair("lastName", "Jones"));
				        nameValuePairs.add(new BasicNameValuePair("dob", "15-08-1990"));
				        nameValuePairs.add(new BasicNameValuePair("gender", "Female"));
				        nameValuePairs.add(new BasicNameValuePair("estimatedDob", "FALSE"));
				        nameValuePairs.add(new BasicNameValuePair("nhisNumber", "1234567"));
				        nameValuePairs.add(new BasicNameValuePair("nhisExpiryDate", "15-09-2014"));
				        nameValuePairs.add(new BasicNameValuePair("region", "Greater Accra"));
				        nameValuePairs.add(new BasicNameValuePair("address", "Accra"));
				        nameValuePairs.add(new BasicNameValuePair("phoneNumber", "233540827309"));
				       // nameValuePairs.add(new BasicNameValuePair("username", "admin"));
				        nameValuePairs.add(new BasicNameValuePair("apiKey", "sfsujdfibfbsifabifab"));
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
		
		protected void onPostExecute(String result) {
    		System.out.println(result);
    		
    	}
	}
	
	static class LoginSyncTask extends AsyncTask<String, Void, String> {
     	String message="";
		private HttpResponse execute;

    	@Override
        protected String doInBackground(String... urls) {
         
    		for (String url : urls) {
				DefaultHttpClient client = new DefaultHttpClient();
				HttpGet httpGet = new HttpGet(url);
				try {
					HttpResponse execute = client.execute(httpGet);
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
    		
    		
    	}
	}

}
