package com.domain.application.model;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.domain.application.controller.ApplicationController;
import com.domain.application.defines.AppConstants;
import com.domain.framework.model.BaseModel;
import com.domain.framework.net.HttpRequestHandlerImpl;

public class AllLocations extends BaseModel{
	
	 JSONArray locations;
	
	@Override
	public void initialize() {
		// TODO Auto-generated method stub
		super.initialize();
		 
		startAsyncTask();
	}

	@Override
	public void onPreExecute() {
		// TODO Auto-generated method stub
		String url =  AppConstants.SERVER_URL + "locations.php";
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
		// TODO Auto-generated method stub
		System.out.println("AllLocations " + result);
		
		try {
			JSONObject jsonObject = new JSONObject((String)result);
			JSONArray jsonArray = jsonObject.getJSONArray("result");
			locations = jsonArray;
			
			informView();
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	
	public JSONArray getLocations() {
		return locations;
	}
}
