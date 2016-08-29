package org.grameenfoundation.mobihealth.adapter;

import java.util.ArrayList;

import org.grameenfoundation.mobihealth.R;

import android.content.Context;
import android.graphics.Bitmap;
import android.media.ThumbnailUtils;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class VisualAidsVideoBaseAdapter extends BaseAdapter{
	ArrayList<String> mThumbIds;
	ArrayList<String> thumbNails;
	String[] captions;
	Context mContext;
	Bitmap bmThumbnail;
	
	public VisualAidsVideoBaseAdapter(Context mContext, ArrayList<String> mThumbIds,ArrayList<String> thumbNails,String[] captions){
		this.mContext=mContext;
		this.mThumbIds=mThumbIds;
		this.captions=captions;
		this.thumbNails=thumbNails;
	}
	@Override
	public int getCount() {
		
		return mThumbIds.size();
	}

	@Override
	public Object getItem(int position) {
		
		return null;
	}

	@Override
	public long getItemId(int position) {
		
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View grid;
		 if (convertView == null) {
       	  LayoutInflater inflater = (LayoutInflater) mContext
       		        .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
       	grid = new View(mContext);
       	grid = inflater.inflate(R.layout.visual_aids_grid_single, null);
      
         } else {
        	 grid = (View) convertView;
         }
		 ImageView image=(ImageView) grid.findViewById(R.id.imageView_thumbnail);
		 bmThumbnail=ThumbnailUtils.createVideoThumbnail(thumbNails.get(position),MediaStore.Video.Thumbnails.MINI_KIND);
		 if(bmThumbnail !=null){
			 image.setImageBitmap(bmThumbnail);
		 }
		 
		 TextView caption=(TextView) grid.findViewById(R.id.textView_caption);
		 caption.setText(captions[position]);
		return grid;
	}

}
