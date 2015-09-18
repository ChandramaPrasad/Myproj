package com.domain.application.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

import com.domain.application.MainApplication;
import com.domain.application.defines.AppDefines;
import com.domain.application.factory.ViewFactory;
import com.domain.application.model.ModelFacade;
import com.domain.framework.controller.Controller;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Fragment;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * ApplicationController.java
 * 
 * The ApplicationController Class, which helps to manage different Controllers,
 * Models, Views. This Class will be initialize as the platform requirement.
 * example : MIDlet in J2ME : UiApplication in Blackberry : Activity in Android
 * : public static void main(String args[]) for java platform The Concept used
 * in this application framework can be used in any platform after tweaking some
 * changes.
 * 
 * 
 * @author ashishpatel
 * 
 */

public class ApplicationController extends Controller {

	/**
	 * private instance of ApplicationController for singleton Design Pattern
	 */
	private static ApplicationController instance;

	/**
	 * private instance of ModelFacade. I only can be used via getter method,
	 * and there will be no setter method for this variable. so do not make it
	 * public
	 */
	public ModelFacade modelFacade;

	/**
	 * private instance of UIController for managing different AbstractViews
	 */
	public UIController uiController;

	/**
	 * private instance of ViewFactory for fast accessing.
	 */
	public ViewFactory viewFactory;

	public Context context;

	private MainApplication application;

	/**
	 * Constructor of ApplicationController
	 */
	private ApplicationController() {
		// Create the instance of ModelFacade
		modelFacade = new ModelFacade();

	}

	// --------------------------------------------------------------------------------------------------------
	/**
	 * Get Single instance of ApplicationController
	 * 
	 * @return ApplicationController single instance
	 */
	public static ApplicationController getInstance() {
		if (instance == null) {
			// creating new instance of application controller
			instance = new ApplicationController();
		}
		return instance;
	}

	/**
	 * This Function will get called from MainActivity or Any Activity which is
	 * going to display first screen after launching this application
	 * 
	 * @param activity
	 */
	public void initialize() {

		// initialize the ModelFacade
		modelFacade.initialize();

		// set the reference for UI Controller
		uiController = UIController.getInstance();

		// initialize the UIController
		uiController.initialize();

		// set the viewFactory reference for further use in code.
		viewFactory = ViewFactory.getInstance();

	}

	public MainApplication getApplication() {
		return application;
	}

	public void setApplication(MainApplication application) {
		this.application = application;
	}

	public void launchSplashScreen() {

		uiController.pushScreen(ViewFactory.SPLASH_SCREEN);
	}

	/**
	 * This function must get called before exiting the application. otherwise
	 * there will be chances for memory leakages.
	 */
	@Override
	public void destroy() {
		// System.out.println("StoryViewActivity.onStop()");

		if (modelFacade != null) {
			// Destroy the ModelFacade
			modelFacade.destroy();
			// set modelFacade to null for garbage collection
			modelFacade = null;
		}

		if (uiController != null) {
			uiController.destroy();
			uiController = null;
		}

		if (viewFactory != null) {
			viewFactory.releaseAllScreen();
			viewFactory = null;
		}

		if (instance != null) {
			// added by yogesh
			instance = null;
		}

		super.destroy();
	}

	@Override
	public void enable() {

		if (uiController != null) {
			uiController.enable();
		}
		super.enable();

	}

	@Override
	public void disable() {

		if (uiController != null) {
			uiController.disable();
		}
		super.disable();
	}

	@Override
	public void hideNotify() {

		if (uiController != null) {
			uiController.hideNotify();
		}
		super.hideNotify();

	}

	@Override
	public void backKeyPressed() {
		// super.backKeyPressed();
		if (uiController != null) {
			uiController.backKeyPressed();
		}

	}

	@Override
	public void showNotify() {

		if (uiController != null) {
			uiController.showNotify();
		}
		super.showNotify();

	}

	@Override
	public void handleEvent(int eventId) {
		super.handleEvent(eventId);
		handleEvent(eventId, null);
	}

	// /////////// ONLY for TEMP USE END /////

	@SuppressLint({ "ParserError", "NewApi" })
	@Override
	public void handleEvent(int eventId, final Object eventObjects) {
		// TODO Auto-generated method stub
		super.handleEvent(eventId, eventObjects);

		switch (eventId) {
		case AppDefines.EVENT_ID_SPLASH_SCREEN: {

		}
			break;
		case AppDefines.EVENT_ID_MAIN_SCREEN:

		{
			uiController.pushScreen(ViewFactory.MAIN_SCREEN);
		}

			break;
		case AppDefines.EVENT_ID_REGISTER_SCREEN:

		{
			uiController.pushScreen(ViewFactory.REGISTER_SCREEN);
		}

			break;
		case AppDefines.EVENT_ID_MAP_SCREEN:

		{
			uiController.pushScreen(ViewFactory.MAP_SCREEN);
		}

			break;


		}

	}

	/**
	 * Get the reference of ModelFacade
	 * 
	 * @return ModelFacade
	 */
	public ModelFacade getModelFacade() {
		return modelFacade;
	}

	/**
	 * Get the reference of UIController
	 * 
	 * @return
	 */
	public UIController getUiController() {
		return uiController;
	}

	public Context getContext() {
		// System.out.println("context "+context);
		return context;
	}

	public void setContext(Context context) {
		this.context = context;
	}

	public void closeStackedActivity() {

	}

	public void closeApplication() {

	}

}
