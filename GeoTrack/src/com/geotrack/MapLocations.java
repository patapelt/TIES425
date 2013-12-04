package com.geotrack;

import java.util.List;

import com.google.android.maps.MapActivity;
import com.google.android.maps.MapView;
import com.google.android.maps.Overlay;
import com.google.android.maps.OverlayItem;


import android.graphics.drawable.Drawable;
import android.location.Location;
import android.os.Bundle;
import android.view.Menu;

public class MapLocations extends MapActivity {

	private Locations locations = Locations.getInstance();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_map);
		
        MapView mapView = (MapView) findViewById(R.id.map);
        mapView.setBuiltInZoomControls(true);
       
        List<Overlay> mapOverlays = mapView.getOverlays();
        Drawable drawable = this.getResources().getDrawable(R.drawable.ic_launcher);
     

        ItemsOverlay itemsoverlay = new ItemsOverlay(drawable, this);
       
		for (Location location : locations.getLocations()) {
			OverlayItem overlayitem = new OverlayItem(Locations.toGeoPoint(location),"Location","Latitude: "+String.valueOf(location.getLatitude())+"\n"+"Longitude: " +String.valueOf(location.getLongitude()));
			itemsoverlay.addOverlay(overlayitem);
	        mapOverlays.add(itemsoverlay);
		}
             
  
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.map, menu);
		return true;
	}

	@Override
	protected boolean isRouteDisplayed() {
		// TODO Auto-generated method stub
		return false;
	}

}
