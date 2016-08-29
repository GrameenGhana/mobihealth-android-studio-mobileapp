package org.grameenfoundation.mobihealth.database;

import android.content.ContentResolver;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MobiHealthDatabaseHelper extends SQLiteOpenHelper  {

	 public static final int DATABASE_VERSION = 1;
	 public static final String DATABASE_NAME = "MobiHealth.db";  
	 

	 public MobiHealthDatabaseHelper(Context context) {
	        super(context, DATABASE_NAME, null, DATABASE_VERSION);
	      
	    }

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(MobiHealthDataClass.VOLUNTEER_INFO_CREATE_TABLE);
		db.execSQL(MobiHealthDataClass.CHPS_NURSE_CREATE_TABLE);
		db.execSQL(MobiHealthDataClass.LOGIN_ACTIVITY_CREATE_TABLE);
		db.execSQL(MobiHealthDataClass.LOGIN_CREATE_TABLE);
		db.execSQL(MobiHealthDataClass.USAGE_ACTIVITY_CREATE_TABLE);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL(MobiHealthDataClass.CHPS_NURSE_DELETE_TABLE);
		db.execSQL(MobiHealthDataClass.LOGIN_ACTIVITY_DELETE_TABLE);
		db.execSQL(MobiHealthDataClass.LOGIN_DELETE_TABLE);
		db.execSQL(MobiHealthDataClass.VOLUNTEER_INFO_DELETE_TABLE);
		db.execSQL(MobiHealthDataClass.USAGE_ACTIVITY_DELETE_TABLE);	
		
		onCreate(db);
		
	}
	
	public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }
}
