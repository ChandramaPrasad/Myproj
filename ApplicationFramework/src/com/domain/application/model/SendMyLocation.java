package com.domain.application.model;

import java.util.Vector;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.domain.application.controller.ApplicationController;
import com.domain.application.defines.AppConstants;
import com.domain.framework.model.BaseModel;
import com.domain.framework.net.HttpRequestHandlerImpl;

public class SendMyLocation extends BaseModel {

	
	public String imei;
	public String latitude;
	public String longitude;
	

	
	
	
	@Override
	public void initialize() {
		// TODO Auto-generated method stub
		super.initialize();
		
		if(imei!=null)
		{
		startAsyncTask();
		}
	}
	
	public void initializeMyLocation()
	{
		
	}
	
	
	@Override
	public void onPreExecute() {
		// TODO Auto-generated method stub
		
		String url =  AppConstants.SERVER_URL + "mylocation.php?imei="+imei + 
					"&latitude="+latitude +
					"&longitude="+longitude ;
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				httpRequestHandlerImpl = new HttpRequestHandlerImpl(url, ApplicationController.getInstance().getApplication().getApplicationContext());
				httpRequestHandlerImpl.setMethodType(HttpRequestHandlerImpl.HTTP_GET);
	
	}

	@Override
	public Object doInBackground(String... params) {

		byte data[] = httpRequestHandlerImpl.execute();

		return new String(data);
	}

	@Override
	public void onPostExecute(Object result) {
		
				System.out.println("SendMyLocation " + result);
				
	}
	
	public String getImei() {
		return imei;
	}
	
	public String getLatitude() {
		return latitude;
	}
	
	
	public String getLongitude() {
		return longitude;
	}
	
	public void setImei(String imei) {
		this.imei = imei;
	}
	
	
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	
	
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

}
