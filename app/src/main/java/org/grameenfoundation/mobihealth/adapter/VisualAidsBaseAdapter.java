package org.grameenfoundation.mobihealth.adapter;

import org.grameenfoundation.mobihealth.R;

import com.squareup.picasso.Picasso;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class VisualAidsBaseAdapter extends BaseAdapter{
	int[] mThumbIds;
	String[] captions;
	Context mContext;
	
	public VisualAidsBaseAdapter(Context mContext, int[] mThumbIds,String[] captions){
		this.mContext=mContext;
		this.mThumbIds=mThumbIds;
		this.captions=captions;
	}
	@Override
	public int getCount() {
		
		return mThumbIds.length;
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
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
		 image.setScaleType(ImageView.ScaleType.CENTER_CROP);
		 image.setImageResource(mThumbIds[position]);
		 /*
		 Picasso.with(mContext)
		 .load(mThumbIds[position])
		 .placeholder(R.drawable.ic_placeholder)
		 .error(R.drawable.ic_error)
		 .noFade().resize(150, 150)
		 .centerCrop()
		 .into(image);
		 */
		 TextView caption=(TextView) grid.findViewById(R.id.textView_caption);
		 caption.setText(captions[position]);
		return grid;
	}

}
