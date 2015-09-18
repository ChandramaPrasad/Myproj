package com.domain.application.model;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Hashtable;
import java.util.Set;
import java.util.TimeZone;
import java.util.UUID;
import java.util.Vector;

import javax.crypto.spec.PSource;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.domain.application.controller.ApplicationController;
import com.domain.framework.model.IModel;
import com.domain.framework.view.AbstractView;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Build;
import android.provider.CalendarContract;
import android.provider.CalendarContract.Reminders;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * LocalModel.java The LocalModel Class , which store the information in cache
 * (runtime memory,RMS, sqllite,preferences) This class can use the platfrom
 * dependent features.
 * 
 * @author Ashish Kumar Patel
 * 
 */

public class LocalModel implements IModel {

	/**
	 * Constructor
	 */
	public LocalModel() {

	}

	@Override
	public void initialize() {

	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void informView() {
		// TODO Auto-generated method stub

	}

	@Override
	public void register(AbstractView view) {
		// TODO Auto-generated method stub

	}

	@Override
	public void unRegister(AbstractView view) {
		// TODO Auto-generated method stub

	}
	
	public String getIMEI()
	{
		
		TelephonyManager telephonyManager = (TelephonyManager) ApplicationController.getInstance().getApplication().getSystemService(Context.TELEPHONY_SERVICE);
		return telephonyManager.getDeviceId().toString();
	
	}

}
