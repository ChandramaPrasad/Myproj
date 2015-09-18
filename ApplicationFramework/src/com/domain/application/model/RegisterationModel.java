package com.domain.application.model;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.widget.Toast;

import com.domain.application.controller.ApplicationController;
import com.domain.application.defines.AppConstants;
import com.domain.application.defines.AppDefines;
import com.domain.application.view.MainScreen;
import com.domain.application.view.RegisterScreen;
import com.domain.framework.model.BaseModel;
import com.domain.framework.net.HttpRequestHandlerImpl;

public class RegisterationModel extends BaseModel {
	
	
	private String imei;	
	private String name;
	
	JSONObject jsonObject;
	
	
	
	
	
	public RegisterationModel() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void initialize() {
		// TODO Auto-generated method stub
		super.initialize();
		startAsyncTask();
	}
	

	@Override
	public void onPreExecute() {
		
		String url =  AppConstants.SERVER_URL + "register.php?imei="+imei + 
					"&firstname="+name;
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

	
	public JSONObject getJsonObject() {
		return jsonObject;
	}
	@Override
	public void onPostExecute(Object result) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				System.out.println(">>>> " + result);
				
				try {
					jsonObject = new JSONObject((String)result);
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				informView();
				

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImei() {
		return imei;
	}

	public void setImei(String imei) {
		this.imei = imei;
	}
	

}
