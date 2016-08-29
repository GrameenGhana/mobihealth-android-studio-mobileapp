package org.grameenfoundation.mobihealth.database;

import android.provider.BaseColumns;

public class MobiHealthDataClass {
		
	public MobiHealthDataClass(){
		
	}
	
	public static abstract class MobiHealthDatabase implements BaseColumns{
	//table names
	public static final String VOLUNTEER_INFO_TABLE_NAME="volunteer_info";
	public static final String CHPS_NURSE_TABLE_NAME="chps_nurse";
	public static final String LOGIN_TABLE_NAME="user_table";
	public static final String LOGIN_ACTIVITY_TABLE_NAME="login_activity";
	public static final String USAGE_ACTIVITY_TABLE_NAME="usage_tracking";
	
	//column names for volunteer info table
	public static final String COL_NAME_OF_VOLUNTEER="volunteer_name";
	public static final String COL_COMMUNITY_RESIDENT="community_resident";
	public static final String COL_VOLUNTEER_PHONE_NUMBER="volunteer_phone_number";
	public static final String COL_VOLUNTEER_STAFF_ID="volunteer_staff_id";
	public static final String COL_VOLUNTEER_CHPS_ZONE="volunteer_chps_zone";

	//column names for 	CHPS nurse table
	public static final String 	COL_NAME_OF_NURSE="nurse_name";
	public static final String COL_CCH_PHONE_NUMBER="cch_phone_number";
	public static final String COL_CHPS_ZONE="chps_zone";
	
	//column names for login table
	public static final String COL_LOGIN_NAME_OF_VOLUNTEER="volunteer_name";
	public static final String COL_USERNAME="username";
	public static final String COL_PASSWORD="password";
	public static final String COL_LOGIN_CHPS_ZONE="chps_zone";
	public static final String COL_LOGIN_COMMUNITY_RESIDENT="community_resident";

	
	//column names for login activity table
	public static final String 	COL_DATE_LOGGED_IN="date_logged_in";
	public static final String 	COL_TIME_LOGGED_IN="time_logged_in";
	public static final String 	COL_USERNAME_LOGIN_ACTIVITY="username";
	public static final String COL_LOGIN_STATUS="status";
	public static final String COL_LOGIN_UPDATE_STATUS="update_status";
	
	//column names for usage tracking table
	public static final String COL_USERNAME_USAGE_TRACKING="user_name";
	public static final String COL_MODULE="module";
	public static final String COL_SUBMODULE="sub_module";
	public static final String COL_TYPE="type";
	public static final String COL_ACTION_DATE="action_date";
	public static final String COL_UPDATE_STATUS_TRACKING="update_status";
	//public static final String COL_STOP_TIME="stop_time";
	public static final String COL_DURATION="duration";
	public static final String COL_DURATION_PLAYED="duration_played";
	public static final String COL_STATUS="status";
	public static final String COL_EXTRAS="extras";
	
	
	}
	
	//table create statement  for volunteer info table
	private static final String TEXT_TYPE = " TEXT";
	private static final String COMMA_SEP = ",";
	
	public static final String VOLUNTEER_INFO_CREATE_TABLE =
	    "CREATE TABLE " + MobiHealthDatabase.VOLUNTEER_INFO_TABLE_NAME + " (" +
	    		MobiHealthDatabase._ID + " INTEGER PRIMARY KEY," +
	    		MobiHealthDatabase.COL_NAME_OF_VOLUNTEER + TEXT_TYPE + COMMA_SEP +
	    		MobiHealthDatabase.COL_COMMUNITY_RESIDENT + TEXT_TYPE + COMMA_SEP +
	    		MobiHealthDatabase.COL_VOLUNTEER_PHONE_NUMBER + TEXT_TYPE + COMMA_SEP +
	    		MobiHealthDatabase.COL_VOLUNTEER_STAFF_ID + TEXT_TYPE + COMMA_SEP +
	    		MobiHealthDatabase.COL_VOLUNTEER_CHPS_ZONE+ TEXT_TYPE + 
	    " )";
	
	//table create statement for chps nurse table
	public static final String CHPS_NURSE_CREATE_TABLE =
		    "CREATE TABLE " + MobiHealthDatabase.CHPS_NURSE_TABLE_NAME + " (" +
		    		MobiHealthDatabase._ID + " INTEGER PRIMARY KEY," +
		    		MobiHealthDatabase.COL_NAME_OF_NURSE + TEXT_TYPE + COMMA_SEP +
		    		MobiHealthDatabase.COL_CCH_PHONE_NUMBER + TEXT_TYPE + COMMA_SEP +
		    		MobiHealthDatabase.COL_CHPS_ZONE + TEXT_TYPE+
		    " )";
	
	//	table create statement for login table 
	public static final String LOGIN_CREATE_TABLE =
		    "CREATE TABLE " + MobiHealthDatabase.LOGIN_TABLE_NAME + " (" +
		    		MobiHealthDatabase._ID + " INTEGER PRIMARY KEY," +
		    		MobiHealthDatabase.COL_LOGIN_NAME_OF_VOLUNTEER + TEXT_TYPE + COMMA_SEP +
		    		MobiHealthDatabase.COL_USERNAME + TEXT_TYPE + COMMA_SEP +
		    		MobiHealthDatabase.COL_PASSWORD+ TEXT_TYPE+ COMMA_SEP +
		    		MobiHealthDatabase.COL_LOGIN_CHPS_ZONE+ TEXT_TYPE+ COMMA_SEP+
		    		MobiHealthDatabase.COL_LOGIN_COMMUNITY_RESIDENT+TEXT_TYPE+
		    " )";
	
	//	table create statement for login activity table
	public static final String LOGIN_ACTIVITY_CREATE_TABLE =
		    "CREATE TABLE " + MobiHealthDatabase.LOGIN_ACTIVITY_TABLE_NAME + " (" +
		    		MobiHealthDatabase._ID + " INTEGER PRIMARY KEY," +
		    		MobiHealthDatabase.COL_DATE_LOGGED_IN + TEXT_TYPE + COMMA_SEP +
		    		MobiHealthDatabase.COL_TIME_LOGGED_IN + TEXT_TYPE + COMMA_SEP +
		    		MobiHealthDatabase.COL_USERNAME_LOGIN_ACTIVITY+ TEXT_TYPE + COMMA_SEP +
		    		MobiHealthDatabase.COL_LOGIN_STATUS+ TEXT_TYPE+ COMMA_SEP +
		    		MobiHealthDatabase.COL_LOGIN_UPDATE_STATUS+ TEXT_TYPE+
		    " )";
	
//	table create statement for login activity table
	public static final String USAGE_ACTIVITY_CREATE_TABLE=
		    "CREATE TABLE " + MobiHealthDatabase.USAGE_ACTIVITY_TABLE_NAME + " (" +
		    		MobiHealthDatabase._ID + " INTEGER PRIMARY KEY," +
		    		MobiHealthDatabase.COL_USERNAME_USAGE_TRACKING + TEXT_TYPE + COMMA_SEP +
		    		MobiHealthDatabase.COL_MODULE + TEXT_TYPE + COMMA_SEP +
		    		MobiHealthDatabase.COL_SUBMODULE + TEXT_TYPE + COMMA_SEP +
		    		MobiHealthDatabase.COL_TYPE+ TEXT_TYPE+	COMMA_SEP+
		    		MobiHealthDatabase.COL_ACTION_DATE+ TEXT_TYPE+	COMMA_SEP+
		    		MobiHealthDatabase.COL_DURATION+ TEXT_TYPE+	COMMA_SEP+
		    		MobiHealthDatabase.COL_DURATION_PLAYED+ TEXT_TYPE+	COMMA_SEP+
		    		MobiHealthDatabase.COL_STATUS+ TEXT_TYPE+	COMMA_SEP+
		    		MobiHealthDatabase.COL_EXTRAS+ TEXT_TYPE+	COMMA_SEP+
		    		MobiHealthDatabase.COL_UPDATE_STATUS_TRACKING+ TEXT_TYPE+
		    " )";
	
	public static final String VOLUNTEER_INFO_DELETE_TABLE =
		    "DROP TABLE IF EXISTS " + MobiHealthDatabase.VOLUNTEER_INFO_TABLE_NAME;
	
	public static final String CHPS_NURSE_DELETE_TABLE =
		    "DROP TABLE IF EXISTS " + MobiHealthDatabase.CHPS_NURSE_TABLE_NAME;
	
	public static final String LOGIN_DELETE_TABLE =
		    "DROP TABLE IF EXISTS " + MobiHealthDatabase.LOGIN_TABLE_NAME;
	
	public static final String LOGIN_ACTIVITY_DELETE_TABLE =
		    "DROP TABLE IF EXISTS " + MobiHealthDatabase.LOGIN_ACTIVITY_TABLE_NAME;
	
	public static final String USAGE_ACTIVITY_DELETE_TABLE =
		    "DROP TABLE IF EXISTS " + MobiHealthDatabase.USAGE_ACTIVITY_TABLE_NAME;
}
