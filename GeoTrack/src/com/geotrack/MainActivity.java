package com.geotrack;



import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.View;


public class MainActivity extends FragmentActivity {

	
	public Locations locations = Locations.getInstance();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		/*
		String context = Context.LOCATION_SERVICE;
		LocationManager mLocationManager = (LocationManager) getSystemService(context);
		Criteria criteria = new Criteria();
		criteria.setAccuracy(Criteria.ACCURACY_FINE);
		criteria.setAltitudeRequired(false);
		criteria.setBearingRequired(false);
		criteria.setSpeedRequired(false);
		criteria.setCostAllowed(true);
		criteria.setPowerRequirement(Criteria.POWER_HIGH);
		String provider = mLocationManager.getBestProvider(criteria, false);
		mLocationManager.requestLocationUpdates(provider, 0, 0, mLocationListener);	*/
	}

	public void onClick(View v) {
	    	
	    	switch(v.getId()) {
	        
	    	case R.id.listButton:
		    	
	    		Intent ListViewItent = new Intent(v.getContext(),
	    				LocationList.class);
	    		startActivity(ListViewItent);
	    	break;
	    	
	    	case R.id.mapButton:
	    		
	    		Intent MapIntent = new Intent(v.getContext(),
	    				MapLocations.class);
	    		startActivity(MapIntent);      	
	    } 			
	}
	/*
	private final LocationListener mLocationListener = new LocationListener() {

		@Override
		public void onLocationChanged(Location location) {
			Toast.makeText(getApplicationContext(), "Latitude:" + location.getLatitude()+" Longitude:"+location.getLongitude(), Toast.LENGTH_SHORT).show();
			locations.add(location);
			/*Intent i = new Intent(MainActivity.this, LocationList.class);
			i.putExtra("new_variable_name",Double.toString(location.getLatitude()));
			startActivity(i);
			finish();
			
			
			Intent intent = new Intent(SplashScreen.this, MainActivity.class);
		    SplashScreen.this.startActivity(intent);
			SplashScreen.this.finish();*/
			
		/*
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
	*/
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	

}
