package com.geotrack;


import android.content.Context;
import android.content.Intent;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.widget.Toast;

public class SplashScreen extends FragmentActivity {
 
	public Locations locations = Locations.getInstance();
	boolean loaded = false;
	LocationManager mLocationManager;
   
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash_screen);
		
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
	

    
	
	private LocationListener mLocationListener = new LocationListener() {

		@Override
		public void onLocationChanged(Location location) {
			Toast.makeText(getApplicationContext(), "Latitude: " + location.getLatitude()+" Longitude: "+location.getLongitude(), Toast.LENGTH_SHORT).show();
			locations.add(location);
			if(loaded == false) {
		    loaded = true;
			Intent intent = new Intent(SplashScreen.this, MainActivity.class);
		    SplashScreen.this.startActivity(intent);
		    mLocationManager.removeUpdates(mLocationListener);
			mLocationManager = null;
			mLocationListener = null;
			}
	
			SplashScreen.this.finish();
	
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
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.splash_screen, menu);
		return true;
	}

}
