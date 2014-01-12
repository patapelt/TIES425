package com.geotrack;



import android.location.Location;
import android.os.Bundle;
import android.app.ListActivity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.ListView;



/**
 * Listaruutu sijainneille.
 * @author Pasi Peltonen
 *
 */
public class LocationList extends ListActivity {
 
	private Locations locations = Locations.getInstance();
	
	
	private CustomAdapter customadapter;
	
	protected void onCreate(Bundle savedInstanceState) {			
		super.onCreate(savedInstanceState);
		
		customadapter = new CustomAdapter(this, R.layout.rowlayout, locations.getLocations());	
		setListAdapter(customadapter);
        

	}
	
	public void onListItemClick(ListView listview, View view, int position,
			long id) {

		Location location = customadapter.getItem(position);
		if (location == null)
			return;
		Intent mapIntent = new Intent(view.getContext(), MapLocations.class);
		mapIntent.putExtra("latitude", (double) (location.getLatitude()));
		mapIntent.putExtra("longitude", (double) (location.getLongitude()));
		startActivity(mapIntent);
	}
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}



}
