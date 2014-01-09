package com.geotrack;

import java.util.ArrayList;
import com.google.android.maps.GeoPoint;
import android.location.Location;

/**
 * Lista sijaintien s�il�mist� varten.
 * @author Pasi Peltonen
 *
 */
public class Locations {
	
	public static Locations instance;
	public ArrayList<Location> locations = new ArrayList<Location>();
	
	public static Locations getInstance() {
		if (instance == null)
			instance = new Locations();
		return instance;
	}
	
	/**
	 * Lis�t��n sijainti sijaintilistaan jos siell� ei viel� ole kyseist� sijaintia.
	 * @param location
	 */
	public void add(Location location) {
		if(!this.locations.contains(location)) {
		this.locations.add(location);
		}
	}

	/**
	 * @return sijainnit
	 */
	public ArrayList<Location> getLocations() {
		return locations;
	}
	


}
