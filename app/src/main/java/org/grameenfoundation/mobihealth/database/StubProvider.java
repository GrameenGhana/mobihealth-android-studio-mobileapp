package org.grameenfoundation.mobihealth.database;

import org.grameenfoundation.mobihealth.database.MobiHealthDataClass.MobiHealthDatabase;

import android.content.ContentProvider;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;
import android.text.TextUtils;


public class StubProvider extends ContentProvider {
  private MobiHealthDatabaseHelper mHelper;
  private static final int TODOS = 10;
  private static final int TODO_ID = 20;
  
  private static final String AUTHORITY = "org.grameenfoundation.mobihealth.provider";
  
  private static final String BASE_PATH = "MobiHealth";
  public static final Uri CONTENT_URI = Uri.parse("content://" + AUTHORITY
      + "/" + BASE_PATH);

  
  public static final String CONTENT_TYPE = ContentResolver.CURSOR_DIR_BASE_TYPE
	      + "/todos";
	  public static final String CONTENT_ITEM_TYPE = ContentResolver.CURSOR_ITEM_BASE_TYPE
	      + "/todo";

	  private static final UriMatcher sURIMatcher = new UriMatcher(UriMatcher.NO_MATCH);
	  static {
	    sURIMatcher.addURI(AUTHORITY, BASE_PATH, TODOS);
	    sURIMatcher.addURI(AUTHORITY, BASE_PATH + "/#", TODO_ID);
	  }

   @Override
   public boolean onCreate() {
     mHelper=new MobiHealthDatabaseHelper(getContext());
	return true;
   }
   /*
    * Return an empty String for MIME type
    */
   public String getType() {
       return new String();
   }
   /*
    * query() always returns no results
    *
    */
   @Override
   public Cursor query(Uri uri,String[] projection,String selection,String[] selectionArgs,String sortOrder) {
	   
	   SQLiteQueryBuilder queryBuilder = new SQLiteQueryBuilder();

	   
	    queryBuilder.setTables(MobiHealthDatabase.LOGIN_ACTIVITY_TABLE_NAME);
	    queryBuilder.setTables(MobiHealthDatabase.USAGE_ACTIVITY_TABLE_NAME);
	    int uriType = sURIMatcher.match(uri);
	    switch (uriType) {
	    case TODOS:
	    
	      break;
	    case TODO_ID:
	      // Adding the ID to the original query
	      queryBuilder.appendWhere(MobiHealthDatabase._ID + "="
	          + uri.getLastPathSegment());
	      break;
	    default:
	      throw new IllegalArgumentException("Unknown URI: " + uri);
	    }

	    SQLiteDatabase db = mHelper.getWritableDatabase();
	    Cursor cursor = queryBuilder.query(db, projection, selection,
	        selectionArgs, null, null, sortOrder);
	    // Make sure that potential listeners are getting notified
	    cursor.setNotificationUri(getContext().getContentResolver(), uri);

	    return cursor;
   }
   /*
    * insert() always returns null (no URI)
    */
   @Override
   public Uri insert(Uri uri, ContentValues values) {
	   int uriType = sURIMatcher.match(uri);
	    SQLiteDatabase sqlDB = mHelper.getWritableDatabase();
	    int rowsDeleted = 0;
	    long id = 0;
	    switch (uriType) {
	    case TODOS:
	      id = sqlDB.insert(MobiHealthDatabase.LOGIN_ACTIVITY_TABLE_NAME, null, values);
	      id = sqlDB.insert(MobiHealthDatabase.USAGE_ACTIVITY_TABLE_NAME, null, values);
	      break;
	    default:
	      throw new IllegalArgumentException("Unknown URI: " + uri);
	    }
	    getContext().getContentResolver().notifyChange(uri, null);
	    return Uri.parse(BASE_PATH + "/" + id);
	  }
   /*
    * delete() always returns "no rows affected" (0)
    */
   @Override
   public int delete(Uri uri, String selection, String[] selectionArgs) {
	   int uriType = sURIMatcher.match(uri);
	    SQLiteDatabase sqlDB = mHelper.getWritableDatabase();
	    int rowsDeleted = 0;
	    switch (uriType) {
	    case TODOS:
	      rowsDeleted = sqlDB.delete(MobiHealthDatabase.LOGIN_ACTIVITY_TABLE_NAME, selection,
	          selectionArgs);
	      rowsDeleted = sqlDB.delete(MobiHealthDatabase.USAGE_ACTIVITY_TABLE_NAME, selection,
		          selectionArgs);
	      
	      break;
	    case TODO_ID:
	      String id = uri.getLastPathSegment();
	      if (TextUtils.isEmpty(selection)) {
	        rowsDeleted = sqlDB.delete(MobiHealthDatabase.LOGIN_ACTIVITY_TABLE_NAME,
	        		MobiHealthDatabase._ID + "=" + id, 
	            null);
	        rowsDeleted = sqlDB.delete(MobiHealthDatabase.USAGE_ACTIVITY_TABLE_NAME,
	        		MobiHealthDatabase._ID + "=" + id, 
	            null);
	
	        
	      } else {
	        rowsDeleted = sqlDB.delete(MobiHealthDatabase.LOGIN_ACTIVITY_TABLE_NAME,
	        		MobiHealthDatabase._ID + "=" + id 
	            + " and " + selection,
	            selectionArgs);
	        rowsDeleted = sqlDB.delete(MobiHealthDatabase.USAGE_ACTIVITY_TABLE_NAME,
	        		MobiHealthDatabase._ID + "=" + id 
	            + " and " + selection,
	            selectionArgs);

	      }
	      break;
	    default:
	      throw new IllegalArgumentException("Unknown URI: " + uri);
	    }
	    getContext().getContentResolver().notifyChange(uri, null);
	    return rowsDeleted;
	  }
   public int update(Uri uri,ContentValues values,String selection,String[] selectionArgs) {
	   int uriType = sURIMatcher.match(uri);
	    SQLiteDatabase sqlDB = mHelper.getWritableDatabase();
	    int rowsUpdated = 0;
	    switch (uriType) {
	    case TODOS:
	      rowsUpdated = sqlDB.update(MobiHealthDatabase.LOGIN_ACTIVITY_TABLE_NAME, 
	          values, 
	          selection,
	          selectionArgs);
	      rowsUpdated = sqlDB.update(MobiHealthDatabase.USAGE_ACTIVITY_TABLE_NAME, 
		          values, 
		          selection,
		          selectionArgs);
	     
	      break;
	    case TODO_ID:
	      String id = uri.getLastPathSegment();
	      if (TextUtils.isEmpty(selection)) {
	        rowsUpdated = sqlDB.update(MobiHealthDatabase.LOGIN_ACTIVITY_TABLE_NAME, 
	            values,
	            MobiHealthDatabase._ID + "=" + id, 
	            null);
	        rowsUpdated = sqlDB.update(MobiHealthDatabase.USAGE_ACTIVITY_TABLE_NAME, 
		            values,
		            MobiHealthDatabase._ID + "=" + id, 
		            null);
	        
	        
	      } else {
	        rowsUpdated = sqlDB.update(MobiHealthDatabase.LOGIN_ACTIVITY_TABLE_NAME, 
	            values,
	            MobiHealthDatabase._ID + "=" + id 
	            + " and " 
	            + selection,
	            selectionArgs);
	        rowsUpdated = sqlDB.update(MobiHealthDatabase.USAGE_ACTIVITY_TABLE_NAME, 
		            values,
		            MobiHealthDatabase._ID + "=" + id 
		            + " and " 
		            + selection,
		            selectionArgs);
	        
	      }
	      break;
	    default:
	      throw new IllegalArgumentException("Unknown URI: " + uri);
	    }
	    getContext().getContentResolver().notifyChange(uri, null);
	    return rowsUpdated;
	  }
@Override
public String getType(Uri uri) {
	// TODO Auto-generated method stub
	return null;
}


}