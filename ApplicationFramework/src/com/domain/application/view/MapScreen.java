package com.domain.application.view;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Dialog;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.domain.application.R;
import com.domain.application.controller.ApplicationController;
import com.domain.application.model.AllLocations;
import com.domain.application.model.SendMyLocation;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapScreen extends BaseScreen implements LocationListener {

	AllLocations allLocations;
	SendMyLocation sendMyLocation;
	GoogleMap googleMap;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_map);
		


		allLocations = new AllLocations();
		sendMyLocation = new SendMyLocation();

		allLocations.register(this);
		sendMyLocation.register(this);

		initializeGoogleMap();

		startSendingMyLocation();
		startGettingAllLocaitons();

	}

	public void initializeGoogleMap() {
		// Getting Google Play availability status
		int status = GooglePlayServicesUtil
				.isGooglePlayServicesAvailable(getBaseContext());

		// Showing status
		if (status != ConnectionResult.SUCCESS) { // Google Play Services are
													// not available

			int requestCode = 10;
			Dialog dialog = GooglePlayServicesUtil.getErrorDialog(status, this,
					requestCode);
			dialog.show();


		} else { // Google Play Services are available

			// Getting reference to the SupportMapFragment of activity_main.xml
			SupportMapFragment fm = (SupportMapFragment) getSupportFragmentManager()
					.findFragmentById(R.id.fragment1);

			// Getting GoogleMap object from the fragment
			googleMap = fm.getMap();

			// Enabling MyLocation Layer of Google Map
			googleMap.setMyLocationEnabled(true);

			// Getting LocationManager object from System Service
			// LOCATION_SERVICE
			LocationManager locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);

			// Creating a criteria object to retrieve provider
			Criteria criteria = new Criteria();
			criteria.setAccuracy(Criteria.ACCURACY_FINE);
			// Getting the name of the best provider
			String provider = locationManager.getBestProvider(criteria, true);

			// Getting Current Location
			Location location = locationManager.getLastKnownLocation(provider);

			if (location != null) {
				onLocationChanged(location);
			}
			locationManager.requestLocationUpdates(provider, 20000, 0, this);
		}
	}

	@Override
	public void onLocationChanged(Location location) {

		TextView tvLocation = (TextView) findViewById(R.id.tv_location);

		// Getting latitude of the current location
		double latitude = location.getLatitude();

		// Getting longitude of the current location
		double longitude = location.getLongitude();

		// Creating a LatLng object for the current location
		LatLng latLng = new LatLng(latitude, longitude);

		// Showing the current location in Google Map
		googleMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));

		// Zoom in the Google Map
		 googleMap.animateCamera(CameraUpdateFactory.zoomTo(15));

		// Setting latitude and longitude in the TextView tv_location
		tvLocation.setText("Latitude:" + latitude + ", Longitude:" + longitude);

		String imei = ApplicationController.getInstance().getModelFacade()
				.getLocalModel().getIMEI();

		sendMyLocation.setImei(imei);
		sendMyLocation.setLatitude("" + latitude);

		sendMyLocation.setLongitude("" + longitude);

	}

	@Override
	public void onProviderDisabled(String provider) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onProviderEnabled(String provider) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onStatusChanged(String provider, int status, Bundle extras) {
		// TODO Auto-generated method stub
	}

	public void startSendingMyLocation() {
		Thread t = new Thread(new Runnable() {

			@Override
			public void run() {

				while (true) {
					

					// TODO Auto-generated method stub
					try {
						sendMyLocation.initialize();
						Thread.sleep(30000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});
		t.start();
	}

	public void startGettingAllLocaitons() {
		Thread t = new Thread(new Runnable() {

			@Override
			public void run() {

				while (true) {
					allLocations.initialize();
					// TODO Auto-generated method stub
					try {
						Thread.sleep(30000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});
		t.start();
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		googleMap.clear();

		try {
			if (allLocations.getLocations() != null) {
				JSONArray jsonArray = allLocations.getLocations();

				double lat = 0.0;
				double lng = 0.0;
				String name;
				for (int i = 0; i < jsonArray.length(); i++) {

					JSONObject jsonObject = jsonArray.getJSONObject(i);
					
					lat = Double.parseDouble(jsonObject.getString("latitude"));
					lng = Double.parseDouble(jsonObject.getString("longitude"));
					name=jsonObject.getString("firstname");
					
					googleMap.addMarker(new MarkerOptions().position(
							new LatLng(lat, lng)).title(name));
					

				}
				

			}
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		
	}
	
	
}
