package com.domain.application.model;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.domain.application.view.MainScreen;
import com.domain.framework.model.BaseModel;
import com.domain.framework.net.HttpRequestHandlerImpl;

public class GoogleModel extends BaseModel {

	public GoogleModel() {
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
		// TODO Auto-generated method stub
		httpRequestHandlerImpl = new HttpRequestHandlerImpl(
				"http://172.16.1.32/test/test.php", MainScreen.getContext());
		//httpRequestHandlerImpl.setMethodType(HttpRequestHandlerImpl.HTTP_GET);
		httpRequestHandlerImpl.setMethodType(HttpRequestHandlerImpl.HTTP_POST);

	}

	@Override
	public Object doInBackground(String... params) {
		// TODO Auto-generated method stub
		
		JSONObject jsonObject = new JSONObject();
	
		JSONArray jsonArray = new JSONArray();
		jsonArray.put("ashwini");
		jsonArray.put("alpesh");
		jsonArray.put("kalyani");
		jsonArray.put("vickram");
		
		
		try {
			jsonObject.put("id", new Integer(1));
			jsonObject.put("name", "ashish");
			jsonObject.put("address", "sonegaon");
			jsonObject.put("trainee", jsonArray);
			
			String name = jsonObject.getString("name");
			
			JSONArray trainee = jsonObject.getJSONArray("trainee");
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	//	System.out.println("jsonObject"+jsonObject.toString());
		
	
		
		
		
		byte data[] = httpRequestHandlerImpl.execute(jsonObject.toString());

		return new String(data);
	}

	@Override
	public void onPostExecute(Object result) {
		// TODO Auto-generated method stub
		System.out.println(">>>> " + result);
	}

}
