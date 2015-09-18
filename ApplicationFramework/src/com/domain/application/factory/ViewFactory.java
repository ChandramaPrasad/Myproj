/**
 * 
 */
package com.domain.application.factory;

import com.domain.application.controller.ApplicationController;
import com.domain.application.view.MainScreen;
import com.domain.application.view.MapScreen;
import com.domain.application.view.RegisterScreen;
import com.domain.application.view.SplashScreen;
import com.domain.framework.view.AbstractView;

import android.content.Context;

/**
 * ViewFactory.java The Class which returns the AbstractView (Screen) to the
 * application frame. Developer should use this class to get the reference of
 * any screen in the application. He should not create the screen by him/her
 * self
 * 
 * @author ashishpatel
 * 
 */
public class ViewFactory {

	/**
	 * Splash Screen ID
	 */
	public static final int SPLASH_SCREEN = 0;

	public static final int MAIN_SCREEN = 1;

	public static final int REGISTER_SCREEN = 2;

	public static final int MAP_SCREEN = 3;

	/**
	 * Reference of Application Controller
	 */
	ApplicationController applicationController = null;

	/**
	 * Singleton instance of ViewFactory
	 */
	private static ViewFactory instance = null;

	/**
	 * Constructor
	 */

	private ViewFactory() {
		applicationController = ApplicationController.getInstance();

	}

	/**
	 * Get Single instance of ViewFactory
	 * 
	 * @return ViewFactory single instance
	 */
	public static ViewFactory getInstance() {
		if (instance == null) {
			instance = new ViewFactory();
		}
		return instance;
	}

	/**
	 * To get the different AbstractView from given id This function should only
	 * use when we have single activity in whole applicaiton
	 * 
	 * 
	 * @param id
	 *            AbstractView/Screen ID
	 * @return AbstractView
	 */
	public AbstractView getAbstractView(int id) {
		try {
			switch (id) {

			case SPLASH_SCREEN: {
				return null;
			}

			}

		} catch (Exception e) {
			// System.out.println("ViewFactory.getAbstractView()" + e);

		}
		return null;
	}

	/**
	 * This function should only be used when whole application is made by
	 * multiple activity.
	 * 
	 * @param id
	 * @return
	 */
	public Class getActivityClass(int id) {

		switch (id) {

		case SPLASH_SCREEN: {
			return SplashScreen.class;
		}
		case MAIN_SCREEN:

		{
			return MainScreen.class;
		}
		case REGISTER_SCREEN:

		{
			return RegisterScreen.class;
		}
		case MAP_SCREEN: {
			return MapScreen.class;
		}
		default:
			break;
		}

		return null;

	}

	public void releaseScreen(AbstractView absView) {

	}

	/**
	 * Release All Screen before exiting the application
	 */
	public void releaseAllScreen() {

	}

}
