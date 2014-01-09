package com.geotrack;

import java.util.ArrayList;
import java.util.Date;


import android.content.Context;
import android.location.Location;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * 
 * @author Pasi Peltonen
 *
 */
public class CustomAdapter extends ArrayAdapter<Location> {
	  private final Context context;
	  private final ArrayList<Location> values;
	  private int layoutResourceId;

	  /**
	 * @param context
	 * @param textViewResourceId
	 * @param values
	 */
	public CustomAdapter(Context context, int textViewResourceId, ArrayList<Location> values) {
	    super(context, textViewResourceId, values);
	    this.context = context;
	    this.layoutResourceId = textViewResourceId;
	    this.values = values;
	  }


	 
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
