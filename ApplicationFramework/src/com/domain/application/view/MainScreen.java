package com.domain.application.view;

import com.domain.application.R;
import com.domain.application.R.layout;
import com.domain.application.model.GoogleModel;
import com.domain.framework.net.HttpRequestHandler;
import com.domain.framework.net.HttpRequestHandlerImpl;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainScreen extends BaseScreen {

	static MainScreen mainActivity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainActivity = this;
        
       GoogleModel googleModel = new GoogleModel();
       googleModel.initialize();
        
       
        
        
        setContentView(R.layout.activity_main);
    }
    
    public static MainScreen getContext ()
    {
    	return mainActivity;
    }

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}
}
