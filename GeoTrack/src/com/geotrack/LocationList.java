package com.geotrack;


import android.location.Location;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class LocationList extends Activity {

	private Locations locations = Locations.getInstance();
	//private LocationAdapter locationAdapter;
	
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
		

		setContentView(R.layout.activity_list_view);
		ListView lv = (ListView) findViewById(R.id.listView1);
		lv.setAdapter(new ArrayAdapter<Location>(this, android.R.layout.simple_list_item_1, locations.getLocations()));
        

	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}



}
