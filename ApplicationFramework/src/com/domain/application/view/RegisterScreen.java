package com.domain.application.view;

import org.json.JSONException;

import android.app.Activity;
import android.app.AlertDialog;

import android.content.Context;

import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.domain.application.R;
import com.domain.application.R.id;
import com.domain.application.R.layout;
import com.domain.application.controller.ApplicationController;
import com.domain.application.defines.AppDefines;
import com.domain.application.model.RegisterationModel;
import com.domain.framework.model.AsyncTaskListener;

public class RegisterScreen extends BaseScreen implements OnClickListener {

	EditText nameEditText;
	Button registerButton;

	String imei;
	String name;

	TelephonyManager telephonyManager;
	RegisterationModel registerModel;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_register);
		nameEditText = (EditText) findViewById(R.id.name_edittext);
		registerButton = (Button) findViewById(R.id.register_button);

		telephonyManager = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);

		registerButton.setOnClickListener(this);

		registerModel = new RegisterationModel();
		registerModel.register(this);
		
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if (v.equals(registerButton)) {

			imei = telephonyManager.getDeviceId().toString();
			name = nameEditText.getText().toString();

			if (name.equals("")) {
				AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
						this);
				alertDialogBuilder.setMessage("\t\t\t\t\t Enter Your Name    ");
				alertDialogBuilder.setPositiveButton("OK", null);
				alertDialogBuilder.setCancelable(true);
				alertDialogBuilder.create().show();
			} else if (name.toString().matches("[a-zA-Z ]+") == false) {
				AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
						this);
				alertDialogBuilder.setMessage("\t\t\t\t\t Invalid Name    ");
				alertDialogBuilder.setPositiveButton("OK", null);
				alertDialogBuilder.setCancelable(true);
				alertDialogBuilder.create().show();
			} else {

				registerModel.setImei(imei);
				registerModel.setName(name);
				registerModel.initialize();
			
			}

			 //ApplicationController.getInstance().handleEvent(AppDefines.EVENT_ID_MAP_SCREEN);

		}

	}

	

	@Override
	public void update() {
		// TODO Auto-generated method stub
		try {
			if (registerModel.getJsonObject().getInt("error_code") == -1) {
				ApplicationController.getInstance().handleEvent(
						AppDefines.EVENT_ID_MAP_SCREEN);
			} else {

				runOnUiThread(new Runnable() {

					@Override
					public void run() {
						// TODO Auto-generated method stub
						try {
							Toast.makeText(
									RegisterScreen.this,
									registerModel.getJsonObject().getString(
											"error_message"), Toast.LENGTH_LONG)
									.show();
						} catch (JSONException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				});

			}
		} catch (Exception e) {

		}

	}

	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		finish();
		super.onStop();
	}
}
