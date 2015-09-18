package com.domain.framework.model;

import com.domain.framework.view.AbstractView;

/**
 * IModel.java An Interface which should be implemented by Model in application.
 * 
 * @author ashishpatel
 * 
 */

public interface IModel {
	/**
	 * Initializing Model Data
	 */
	public void initialize();

	/**
	 * To Destroy Model data.
	 */
	public void destroy();

	/**
	 * To Register AbstaractView with model
	 */
	public void register(AbstractView view);

	/**
	 * To UnRegister a AbstractView
	 */
	public void unRegister(AbstractView view);

	/**
	 * To Inform AbtractViews about any update in model
	 */
	public void informView();

}
