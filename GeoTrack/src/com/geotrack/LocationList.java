package com.geotrack;



import android.location.Location;
import android.os.Bundle;
import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;


public class LocationList extends ListActivity {
 
	private Locations locations = Locations.getInstance();
	
	
	private CustomAdapter customadapter;
	
	protected void onCreate(Bundle savedInstanceState) {			
		super.onCreate(savedInstanceState);
		
		
	
	
		/*
		ArrayList<Location> list = new ArrayList<Location>();
		list.add("eoritjio");
		list.add("oeitoji");
		*/
		/*
		Bundle extras = getIntent().getExtras();
		if (extras != null) {
		    String value = extras.getString("new_variable_name");
		    list.add(value);
		}  */
		

		//setContentView(R.layout.rowlayout);
		customadapter = new CustomAdapter(this, R.layout.rowlayout, locations.getLocations());
		//setListAdapter(new CustomAdapter(this, locations.getLocations()));
		setListAdapter(customadapter);
        

	}
	
	public void onListItemClick(ListView listview, View view, int position,
			long id) {
		//Toast.makeText(getApplicationContext(), Integer.toString(position), Toast.LENGTH_SHORT).show();
		
		Location location = customadapter.getItem(position);
		if (location == null)
			return;
		Intent mapIntent = new Intent(view.getContext(), MapLocations.class);
		mapIntent.putExtra("latitude", (int) (location.getLatitude() * 1E6));
		mapIntent.putExtra("longitude", (int) (location.getLongitude() * 1E6));
		startActivity(mapIntent);
	}
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}



}
