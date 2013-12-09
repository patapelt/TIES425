package com.geotrack;

import java.util.ArrayList;
import java.util.Date;



import android.app.Activity;
import android.content.Context;
import android.location.Location;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomAdapter extends ArrayAdapter<Location> {
	  private final Context context;
	  private final ArrayList<Location> values;
	  private int layoutResourceId;

	  public CustomAdapter(Context context, int textViewResourceId, ArrayList<Location> values) {
	    super(context, textViewResourceId, values);
	    this.context = context;
	    this.layoutResourceId = textViewResourceId;
	    this.values = values;
	  }
	  /*
		public View getView(int position, View convertView, ViewGroup parent) {
			View row = convertView;
			LocationHolder holder = null;

			if (row == null) {
				LayoutInflater inflater = (((Activity) context).getLayoutInflater());
				row = inflater.inflate(R.layout.rowlayout, null);
				//row = inflater.inflate(layoutResourceId, parent, false);
				holder = new LocationHolder();
				holder.time = (TextView) row.findViewById(R.id.time);
				holder.location = (TextView) row.findViewById(R.id.location);
				holder.image = (ImageView) row.findViewById(R.id.icon);
				row.setTag(holder);
			} else
				holder = (LocationHolder) row.getTag();

			Location location = values.get(position);
			Date date = new Date(location.getTime());
			holder.time.setText(date.toLocaleString());
			holder.location.setText(String.format("%f, %f",
					location.getLatitude(), location.getLongitude()));
			holder.image.setImageResource(R.drawable.ic_launcher);
			return row;
		}

		
		static class LocationHolder {
			ImageView image;
			TextView time;
			TextView location;
		}*/


	 
	  public View getView(int position, View convertView, ViewGroup parent) {
		  
	    LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	    View rowView = inflater.inflate(R.layout.rowlayout, parent, false);
	    TextView textViewlocation = (TextView) rowView.findViewById(R.id.location);
	    TextView textViewTime = (TextView) rowView.findViewById(R.id.time);
	    ImageView imageView = (ImageView) rowView.findViewById(R.id.icon);
	    textViewlocation.setText(String.format("%f, %f",values.get(position).getLatitude(),values.get(position).getLongitude()));
	    Date date = new Date(values.get(position).getTime());
	    textViewTime.setText(date.toString());
	    imageView.setImageResource(R.drawable.ic_launcher);
	
	    return rowView;
	  }

}
