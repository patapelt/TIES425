package com.geotrack;



import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import android.content.Context;
import android.content.Intent;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.View;
import android.widget.Toast;

/**
 * Karttaruutu.
 * @author Pasi Peltonen
 *
 */
public class MapLocations extends FragmentActivity {

	private Locations locations = Locations.getInstance();
	private LocationManager mLocationManager;
	
	
	private GoogleMap mMap;
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_map);
		
		mMap = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map)).getMap();
		
	    for (Location location : locations.getLocations()) {
	    	MarkerOptions marker =
	    	new MarkerOptions().position(new LatLng(location.getLatitude(), location.getLongitude())).title("Latitude: " + String.valueOf(location.getLatitude())+"Longitude: " + String.valueOf(location.getLongitude()));
	    	mMap.addMarker(marker);
	        
		}
 

	    
		Bundle extras = getIntent().getExtras(); 
		
		if(extras != null) {
			double latitude = extras.getDouble("latitude");
			double longitude = extras.getDouble("longitude");
			CameraPosition cameraPosition = new CameraPosition.Builder().target(new LatLng(latitude, longitude)).zoom(12).build();
		    mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
		}
	    mMap.setMyLocationEnabled(true);
  		
	}
	
	
	
	private LocationListener mLocationListener = new LocationListener() {

		@Override
		public void onLocationChanged(Location location) {
			
			Toast.makeText(getApplicationContext(), "Latitude: " + location.getLatitude()+" Longitude: "+location.getLongitude(), Toast.LENGTH_SHORT).show();
		    
		    
		    MarkerOptions marker = new MarkerOptions().position(new LatLng(location.getLatitude(), location.getLongitude())).title("Latitude: " + String.valueOf(location.getLatitude())+"\n"+"Longitude: " + String.valueOf(location.getLongitude()));
			mMap.addMarker(marker);
			
			CameraPosition cameraPosition = new CameraPosition.Builder().target(new LatLng(location.getLatitude(), location.getLongitude())).zoom(12).build();
		    mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
		    
			locations.add(location);
						
		
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
		mLocationManager.requestLocationUpdates(provider, 5000, 15, mLocationListener);
	}
	
	/**
	 * @param w
	 */
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
	
}
