/**
 * 
 */
package com.domain.application.controller;

import java.util.Stack;

import com.domain.application.factory.ViewFactory;
import com.domain.framework.controller.IController;
import com.domain.framework.view.AbstractView;

import android.annotation.SuppressLint;
import android.content.Intent;

/**
 * UIController.java
 * 
 * The UIController Class, which helps for add and remove the AbstractView from
 * the Device Screen This Class gives transition effect for adding and removing
 * the AbstractView or any other View(Provided by native platforms)
 * 
 * @author ashishpatel
 * 
 */

public class UIController implements IController {

	/**
	 * private instance of UIControllers for singleton Design Pattern
	 */
	private static UIController instance;
	
	

	private UIController() {
		// TODO Auto-generated constructor stub

	}

	public static UIController getInstance() {
		if (instance == null) {
			// creating new instance of application controller
			instance = new UIController();
		}
		return instance;
	}

	@Override
	public void initialize() {
		// TODO Auto-generated method stub
		// create the stack to hold AbstractViews reference in the application
		

	}
	
	public void pushScreen(int screenId)
	{
		
		Intent intent = new Intent(ApplicationController.getInstance().getApplication().getApplicationContext(),
				ViewFactory.getInstance().getActivityClass(screenId));
		intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		ApplicationController.getInstance().getApplication().startActivity(intent);
		
		
	}
	
	public void popScreen()
	{
		
	}
	

	@Override
	public void destroy() {


	}

	@Override
	public void enable() {
	
	}

	@Override
	public void disable() {
		
	}

	@Override
	public void hideNotify() {
		

	}

	@Override
	public void backKeyPressed() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void showNotify() {
		

	}

	@Override
	public void onDeviceOrientationChanged(int mode) {
		// TODO Auto-generated method stub
		
	}



}
