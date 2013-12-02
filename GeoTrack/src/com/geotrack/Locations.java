package com.geotrack;

import java.util.ArrayList;


import android.location.Location;

public class Locations {
	
	public static Locations instance;
	public ArrayList<Location> locations = new ArrayList<Location>();
	
	public static Locations getInstance() {
		if (instance == null)
			instance = new Locations();
		return instance;
	}
	public void add(Location location) {
		this.locations.add(location);
	}

	public ArrayList<Location> getLocations() {
		return locations;
	}
}
