package com.geotrack;

import java.util.List;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.ItemizedOverlay;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;
import com.google.android.maps.Overlay;
import com.google.android.maps.OverlayItem;


import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Toast;

public class MapLocations extends MapActivity {

	private Locations locations = Locations.getInstance();
	private LocationManager mLocationManager;
	private ItemsOverlay itemsoverlay;
	//private ItemizedOverlay<OverlayItem> itemsoverlay;

	private List<Overlay> mapOverlays;
	private MapController mapcontroller;
	private MapView mapView;
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_map);
		
        this.mapView = (MapView) findViewById(R.id.map);
        mapView.setBuiltInZoomControls(true);
        
        mapOverlays = mapView.getOverlays();
        Drawable drawable = this.getResources().getDrawable(R.drawable.ic_launcher);
     

        itemsoverlay = new ItemsOverlay(drawable, this);
        
       
		for (Location location : locations.getLocations()) {
			OverlayItem overlayitem = new OverlayItem(Locations.toGeoPoint(location),"Location","Latitude: "+String.valueOf(location.getLatitude())+"\n"+"Longitude: " +String.valueOf(location.getLongitude()));
			
			itemsoverlay.addOverlay(overlayitem);
	        //mapOverlays.add(itemsoverlay);
		}
		
		
        this.mapcontroller = mapView.getController();
		
		Intent intent = this.getIntent();
		int lat = intent.getIntExtra("latitude", Integer.MAX_VALUE);
		int lon = intent.getIntExtra("longitude", Integer.MAX_VALUE);
		if (lat != Integer.MAX_VALUE && lon != Integer.MAX_VALUE)
			mapcontroller.animateTo(new GeoPoint(lat, lon));
	
		mapOverlays.add(itemsoverlay);
            
		
  		
	}
	
	
	
	private LocationListener mLocationListener = new LocationListener() {

		@Override
		public void onLocationChanged(Location location) {
			Toast.makeText(getApplicationContext(), "Latitude: " + location.getLatitude()+" Longitude: "+location.getLongitude(), Toast.LENGTH_SHORT).show();
			//OverlayItem overlayitem = new OverlayItem(Locations.toGeoPoint(location),"Location","Latitude: "+String.valueOf(location.getLatitude())+"\n"+"Longitude: " +String.valueOf(location.getLongitude()));
			GeoPoint geopoint = Locations.toGeoPoint(location);
			mapcontroller.animateTo(geopoint);
			itemsoverlay.addOverlay(new OverlayItem(geopoint,"Location","Latitude: "+String.valueOf(location.getLatitude())+"\n"+"Longitude: " +String.valueOf(location.getLongitude())));
			locations.add(location);
			//mapOverlays.add(itemsoverlay);			
		
	      }

		@Override
		public void onProviderDisabled(String arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onProviderEnabled(String arg0) {

			
		}

		@Override
		public void onStatusChanged(String arg0, int arg1, Bundle arg2) {
			
			
		}
			
	};
	
	public void onResume() {
		super.onResume();
		String context = Context.LOCATION_SERVICE;
		mLocationManager = (LocationManager) getSystemService(context);		
		Criteria criteria = new Criteria();
		criteria.setAccuracy(Criteria.ACCURACY_FINE);
		criteria.setAltitudeRequired(false);
		criteria.setBearingRequired(false);
		criteria.setSpeedRequired(false);
		criteria.setCostAllowed(true);
		criteria.setPowerRequirement(Criteria.POWER_HIGH);
		String provider = mLocationManager.getBestProvider(criteria, false);
		mLocationManager.requestLocationUpdates(provider, 0, 0, mLocationListener);
	}
	
	public void onClick(View w) {
		
		Intent listIntent = new Intent(w.getContext(), LocationList.class);
		startActivity(listIntent);
		
		
	}
	
	
	
	public void onPause() {
		super.onPause();
		mLocationManager.removeUpdates(mLocationListener);
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
