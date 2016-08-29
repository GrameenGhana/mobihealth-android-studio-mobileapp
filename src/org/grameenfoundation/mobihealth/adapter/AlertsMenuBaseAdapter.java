package org.grameenfoundation.mobihealth.adapter;

import org.grameenfoundation.mobihealth.R;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

public class AlertsMenuBaseAdapter extends BaseAdapter {
	public String[] category;
	public Context mContext;
	public int[] imageId;
	public TextView textView;
	public ImageView imageView;
	
	public AlertsMenuBaseAdapter(Context c,String[] category,int[] imageId){
		this.category=category;
		this.mContext=c;
		this.imageId=imageId;
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
			return getNewView(position);
   }
	
	private View getNewView(int position){
        int columnIndex=position%2;
        int index=position/2;
      
        
        try
        {
                        if(columnIndex==0){
                                return (View)getTextView(category[position]);
                        }else if(columnIndex==1){ 
                                return (View)getImageView(imageId[position]);	
                        }else {
                                return (View)getTextView("---");
                        }
                
                
        }catch(Exception ex){
                Log.e("AlertMenuBaseAdapter.getNewView", ex.getMessage());
                return null;
        }

}
	 private TextView getTextView(String t){
         TextView textView=new TextView(mContext);
         textView.setLayoutParams(new GridView.LayoutParams(GridView.LayoutParams.WRAP_CONTENT,GridView.LayoutParams.WRAP_CONTENT));
         textView.setPadding(8, 8, 8, 8);
         textView.setText(t);
         textView.setTextColor(Color.BLACK);    
         return textView;
 }
	 
	 private ImageView getImageView(int imageId){
		 ImageView imageView=new ImageView(mContext);
		 imageView.setLayoutParams(new GridView.LayoutParams(GridView.LayoutParams.WRAP_CONTENT,GridView.LayoutParams.WRAP_CONTENT));
		 imageView.setPadding(8, 8, 8, 8);
		 imageView.setMaxHeight(68);
		 imageView.setMaxWidth(68);
		 imageView.setImageResource(imageId);    
         return imageView;
 }
}
