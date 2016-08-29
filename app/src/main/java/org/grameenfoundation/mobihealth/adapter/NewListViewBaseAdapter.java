package org.grameenfoundation.mobihealth.adapter;

import org.grameenfoundation.mobihealth.R;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


public class NewListViewBaseAdapter extends BaseAdapter{
	 private Context mContext;
	 private final String[] category;
	    private final int[] Imageid;
	
	 public NewListViewBaseAdapter(Context c,String[] category,int[] Imageid ) {
         mContext = c;
         this.Imageid = Imageid;
         this.category = category;
     }
	@Override
	public int getCount() {
	
		return category.length;
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
		 View list;	     
	          if (convertView == null) {
	        	  LayoutInflater inflater = (LayoutInflater) mContext
	        		        .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	        	  list = new View(mContext);
	        	  list = inflater.inflate(R.layout.menu_listview_single, null);
	       
	          } else {
	        	  list = (View) convertView;
	          }
	          TextView textView2 = (TextView) list.findViewById(R.id.item_category);
	            ImageView imageView = (ImageView)list.findViewById(R.id.imageView1);
	            textView2.setText(category[position]);
	            Typeface custom_font = Typeface.createFromAsset(mContext.getAssets(),
	          	      "fonts/Roboto-Thin.ttf");
	            textView2.setTypeface(custom_font);
	            textView2.setTextSize(24);
	            imageView.setImageResource(Imageid[position]);
	            if (position % 2 == 1) {
		 			 list.setBackgroundColor(Color.rgb(255, 149, 156));  
		 			  textView2.setTextColor(Color.WHITE);
		 			} else {
		 				list.setBackgroundColor(Color.WHITE);  
		 				 textView2.setTextColor(Color.rgb(255, 149, 156));
		 			}
	      return list;
	    }
		
	}


