package com.geotrack;



import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


/**
 * Sovelluksen p‰‰ikkuna.
 * @author Pasi Peltonen
 *
 */
public class MainActivity extends FragmentActivity {

	
	public Locations locations = Locations.getInstance();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

	}

	/**
	 * @param v
	 */
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
	

	
	public boolean onOptionsItemSelected(MenuItem item) {
       
        switch (item.getItemId()) {
            case R.id.action_about:
            openAbout();
            break;
            default:
            break;            
        }
        return true;
    }

	/**
	 * Avataan about dialogi.
	 * 
	 */
	public void openAbout() {
		
        AlertDialog.Builder alertbox = new AlertDialog.Builder(this);

        alertbox.setTitle("About Geotrack");
        alertbox.setMessage("GeoTrack\nTIES425\nPasi Peltonen");

        
        alertbox.setNeutralButton("Ok", new DialogInterface.OnClickListener() {
               
                public void onClick(DialogInterface arg0, int arg1) {

                }
        });
        alertbox.show();	
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	

}
