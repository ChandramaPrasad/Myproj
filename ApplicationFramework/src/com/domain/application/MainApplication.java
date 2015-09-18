package com.domain.application;

import com.domain.application.controller.ApplicationController;

import android.app.Application;
import android.content.res.Configuration;

public class MainApplication extends Application  {

	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		// TODO Auto-generated method stub
		super.onConfigurationChanged(newConfig);
	}
	
	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
		
		//initialize the application controller
		ApplicationController.getInstance().initialize();
		ApplicationController.getInstance().setApplication(this);
		
		
	}
	
	@Override
	public void onLowMemory() {
		// TODO Auto-generated method stub
		super.onLowMemory();
	}
	
	@Override
	public void onTerminate() {
		// TODO Auto-generated method stub
		super.onTerminate();
	}
	
	@Override
	public void onTrimMemory(int level) {
		// TODO Auto-generated method stub
		super.onTrimMemory(level);
	}
}
