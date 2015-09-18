package com.domain.application.view;

import com.domain.application.R;
import com.domain.application.R.id;
import com.domain.application.R.layout;
import com.domain.application.controller.ApplicationController;
import com.domain.application.defines.AppConstants;
import com.domain.application.defines.AppDefines;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class SplashScreen extends BaseScreen  {

	
	

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash);
		
		new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                
                SplashScreen.this.finish();
                ApplicationController.getInstance().handleEvent(AppDefines.EVENT_ID_REGISTER_SCREEN);
            }
        }, AppConstants.SPLASH_DISPLAY_LENGTH);
		
		
		
			}


	
	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}



	
	
	
	
	
}
