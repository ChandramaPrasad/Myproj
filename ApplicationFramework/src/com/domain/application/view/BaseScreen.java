package com.domain.application.view;

import com.domain.framework.view.AbstractView;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

public abstract class BaseScreen extends FragmentActivity implements
		AbstractView {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	}

	@Override
	public void initialize() {
		// TODO Auto-generated method stub

	}

	@Override
	public void reInitialize() {
		// TODO Auto-generated method stub

	}

	@Override
	public void freeResource() {
		// TODO Auto-generated method stub

	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void enable() {
		// TODO Auto-generated method stub

	}

	@Override
	public void disable() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean hideNotify() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean showNotify() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean backKeyPressed() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public abstract void update();

	@Override
	public void onDeviceOrientationChanged(int mode) {
		// TODO Auto-generated method stub

	}

}
