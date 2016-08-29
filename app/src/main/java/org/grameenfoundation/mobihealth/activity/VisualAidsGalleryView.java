package org.grameenfoundation.mobihealth.activity;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import org.grameenfoundation.mobihealth.R;






import org.grameenfoundation.mobihealth.adapter.PinchZoom;
import org.grameenfoundation.mobihealth.database.MobiHealthDatabaseHelper;

import com.squareup.picasso.Picasso;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class VisualAidsGalleryView extends Activity {

	private int position;
	private PinchZoom image;
	private Bitmap bitmap;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.visual_aids_gallery_view);
	    image=(PinchZoom) findViewById(R.id.imageView1);
	    
	    Bundle bundle = getIntent().getExtras();
	    position= getIntent().getIntExtra("position",-1);
	  
	    if(position!=-	1){
	    	switch(position){
	    	case 0:
	    		/*
	    	Picasso.with(VisualAidsGalleryView.this)
	    	.load(R.raw.full_one)
	    	.placeholder(R.drawable.ic_placeholder)
	    	.noFade()
	    	.error(R.drawable.ic_error)
	    	.into(image);
	    	*/
	    	image.setImageBitmap(
	    		    decodeSampledBitmapFromResource(getResources(), R.raw.full_one, 400, 400));
	    	break;
	    	case 1:
	    		/*
		    	Picasso.with(VisualAidsGalleryView.this)
		    	.load(R.raw.full_two)
		    	.placeholder(R.drawable.ic_placeholder)
		    	.noFade()
		    	.error(R.drawable.ic_error)
		    	.into(image);
		    	*/
		    	image.setImageBitmap(
		    		    decodeSampledBitmapFromResource(getResources(), R.raw.full_two, 400, 400));
		    	break;
	    	case 2:
	    		/*
		    	Picasso.with(VisualAidsGalleryView.this)
		    	.load(R.raw.full_three)
		    	.placeholder(R.drawable.ic_placeholder)
		    	.noFade()
		    	.error(R.drawable.ic_error)
		    	.into(image);
		    	*/
		    	image.setImageBitmap(
		    		    decodeSampledBitmapFromResource(getResources(), R.raw.full_three,400, 400));
		    	break;
	    	case 3:
	    		/*
		    	Picasso.with(VisualAidsGalleryView.this)
		    	.load(R.raw.full_four)
		    	.placeholder(R.drawable.ic_placeholder)
		    	.noFade()
		    	.error(R.drawable.ic_error)
		    	.into(image);
		    	*/
		    	image.setImageBitmap(
		    		    decodeSampledBitmapFromResource(getResources(), R.raw.full_four, 400, 400));
		    	break;
	    	case 4:
	    		/*
		    	Picasso.with(VisualAidsGalleryView.this)
		    	.load(R.raw.full_five)
		    	.placeholder(R.drawable.ic_placeholder)
		    	.noFade()
		    	.error(R.drawable.ic_error)
		    	.into(image);
		    	*/
		    	image.setImageBitmap(
		    		    decodeSampledBitmapFromResource(getResources(), R.raw.full_five, 400, 400));
		    	break;
	    	case 5:
	    		/*
		    	Picasso.with(VisualAidsGalleryView.this)
		    	.load(R.raw.full_six)
		    	.placeholder(R.drawable.ic_placeholder)
		    	.noFade()
		    	.error(R.drawable.ic_error)
		    	.into(image);
		    	*/
		    	image.setImageBitmap(
		    		    decodeSampledBitmapFromResource(getResources(), R.raw.full_six, 400, 400));
		    	break;
	    	case 6:
	    		/*
		    	Picasso.with(VisualAidsGalleryView.this)
		    	.load(R.raw.full_seven)
		    	.placeholder(R.drawable.ic_placeholder)
		    	.noFade()
		    	.error(R.drawable.ic_error)
		    	.into(image);
		    	*/
		    	image.setImageBitmap(
		    		    decodeSampledBitmapFromResource(getResources(), R.raw.full_seven, 400, 400));
		    	break;
	    	}
	   
	    }else{
	    	Context context = getApplicationContext();
	    	CharSequence text = "Image not found!";
	    	int duration = Toast.LENGTH_LONG;
	    	Toast toast = Toast.makeText(context, text, duration);
	    	toast.show();
	    }
	    
	}
	public static int calculateInSampleSize(
            BitmapFactory.Options options, int reqWidth, int reqHeight) {
    // Raw height and width of image
    final int height = options.outHeight;
    final int width = options.outWidth;
    int inSampleSize = 1;

    if (height > reqHeight || width > reqWidth) {

        final int halfHeight = height / 2;
        final int halfWidth = width / 2;

        // Calculate the largest inSampleSize value that is a power of 2 and keeps both
        // height and width larger than the requested height and width.
        while ((halfHeight / inSampleSize) > reqHeight
                && (halfWidth / inSampleSize) > reqWidth) {
            inSampleSize *= 2;
        }
    }

    return inSampleSize;
}
	public static Bitmap decodeSampledBitmapFromResource(Resources res, int resId,
	        int reqWidth, int reqHeight) {

	    // First decode with inJustDecodeBounds=true to check dimensions
	    final BitmapFactory.Options options = new BitmapFactory.Options();
	    options.inJustDecodeBounds = true;
	    BitmapFactory.decodeResource(res, resId, options);

	    // Calculate inSampleSize
	    options.inSampleSize = calculateInSampleSize(options, reqWidth, reqHeight);

	    // Decode bitmap with inSampleSize set
	    options.inJustDecodeBounds = false;
	    return BitmapFactory.decodeResource(res, resId, options);
	}
	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.action_bar_all, menu);
        return super.onCreateOptionsMenu(menu);
    }

   @Override
   public boolean onOptionsItemSelected(MenuItem item) {
       // Handle presses on the action bar items
       switch (item.getItemId()) {
           case R.id.action_logout:
   			AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
   					VisualAidsGalleryView.this);
	 
				// set title
				alertDialogBuilder.setTitle("Logout");
	 
				// set dialog message
				alertDialogBuilder
					.setMessage("You will be logged out.Continue?")
					.setCancelable(false)
					.setIcon(R.drawable.ic_warning)
					.setPositiveButton("Yes",new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog,int id) {
							 getBaseContext().deleteDatabase(MobiHealthDatabaseHelper.DATABASE_NAME);
							 String filePath = getApplicationContext().getFilesDir().getPath()+"/"+"shared_prefs/loginPrefs.xml";
							 File deletePrefFile = new File(filePath );
							  deletePrefFile.delete();
							  dialog.cancel();
							 Intent intent=new Intent(VisualAidsGalleryView.this, WelcomeActivity.class);
								startActivity(intent);
								VisualAidsGalleryView.this.finish();
							
						}
					  })
					.setNegativeButton("No",new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog,int id) {
							  dialog.cancel();
							
						}
					});
	 
					// create alert dialog
					AlertDialog alertDialog = alertDialogBuilder.create();
	 
					// show it
					alertDialog.show();
				
               return true;
               
           case R.id.action_home:
        	   Intent goHome = new Intent(Intent.ACTION_MAIN);
 	          goHome.setClass(VisualAidsGalleryView.this, MenuActivity.class);
 	          goHome.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
 	          startActivity(goHome);
 	          finish();
 	         
        	   return true;
           default:
               return super.onOptionsItemSelected(item);
       }
   }
  
}
