package org.grameenfoundation.mobihealth.adapter;
import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class SimpleListViewBaseAdapter extends BaseAdapter{
	
	public Context mContext;
	public String[] items;
		
	public SimpleListViewBaseAdapter(Context c, String[] items){
		this.mContext=c;
		this.items=items;
	}
	@Override
	public int getCount() {
		
		return items.length;
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
		 View list = null;
         if (convertView == null) {	 
       	  list = new View(mContext);
       	
         } else {
       	  list = (View) convertView;  
         }
         
         if (position % 2 == 1) {
 			 list.setBackgroundColor(Color.rgb(255, 149, 156));  
 		
 			} else {
 				list.setBackgroundColor(Color.WHITE);  
 		TextView items_text=new TextView(mContext);
 		items_text.setText(items[position]);
 			}
  return list;
	}

}
