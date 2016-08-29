																																																											package org.grameenfoundation.mobihealth.adapter;

import java.util.ArrayList;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.grameenfoundation.mobihealth.R;

public class FirstTrimesterAudioBaseAdapter extends BaseAdapter {
	private LayoutInflater mInflater;
	private Context mContext;

	private final int[] Imageid;
	private final String[] audioName;
	
	public FirstTrimesterAudioBaseAdapter(Context c, int[] imageid, String[] audioName) {
		this.mContext=c;
		this.Imageid=imageid;
		this.audioName=audioName;																	
		//this.songname=songname;
		mInflater = (LayoutInflater) mContext
			        .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}
	@Override
	public int getCount() {
		
		 return audioName.length;
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
	            grid = inflater.inflate(R.layout.audio_menu_listview, null);
	            
	            
	          } else {
	            grid = (View) convertView;
	          }
	          TextView textView = (TextView) grid.findViewById(R.id.textView1);
	            ImageView imageView = (ImageView)grid.findViewById(R.id.imageView1);
	            imageView.setImageResource(Imageid[position]);
	            textView.setText(audioName[position]);
	            if (position % 2 == 1) {
	            	grid.setBackgroundColor(Color.rgb(255, 149, 156));  
	            	textView.setTextColor(Color.WHITE);
		 			} else {
		 				grid.setBackgroundColor(Color.WHITE);  
		 				textView.setTextColor(Color.rgb(255, 149, 156));
		 			}
	      return grid;
	    }
	
}
