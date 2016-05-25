/**
 * This file was auto-generated by the Titanium Module SDK helper for Android
 * Appcelerator Titanium Mobile
 * Copyright (c) 2009-2010 by Appcelerator, Inc. All Rights Reserved.
 * Licensed under the terms of the Apache Public License
 * Please see the LICENSE included with this distribution for details.
 *
 */
package de.appwerft.spinkit;

import org.appcelerator.kroll.KrollDict;

import android.graphics.Color;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;

//import org.appcelerator.kroll.KrollProxy;
import org.appcelerator.kroll.annotations.Kroll;
import org.appcelerator.kroll.common.Log;
import org.appcelerator.titanium.proxy.TiViewProxy;
import org.appcelerator.titanium.view.TiUIView;

import com.github.ybq.android.spinkit.SpinKitView;
import com.github.ybq.android.spinkit.sprite.Sprite;
import com.github.ybq.android.spinkit.style.*;

import android.app.Activity;

// This proxy can be created by calling Spin.createExample({message: "hello world"})
@Kroll.proxy(creatableInModule = SpinKitModule.class)
public class SpinnerViewProxy extends TiViewProxy {
	private static final String LCAT = "SpinView";
	public int spinnerStyle = 0;
	public int spinnerColor = Color.parseColor("#ffffff");
	private SpinnerView mView;

	// Constructor
	public SpinnerViewProxy() {
		super();
	}

	@Override
	public TiUIView createView(Activity activity) {
		mView = new SpinnerView(this);
		mView.getLayoutParams().autoFillsHeight = true;
		mView.getLayoutParams().autoFillsWidth = true;
		return mView;
	}

	@Override
	public void handleCreationDict(KrollDict options) {
		super.handleCreationDict(options);
		if (options.containsKeyAndNotNull("type")) {
			spinnerStyle = options.getInt("type");
		}
		if (options.containsKeyAndNotNull("color")) {
			spinnerColor = Color.parseColor(options.getString("color"));
		}
	}

	private class SpinnerView extends TiUIView {
		SpinKitView view;

		public SpinnerView(final TiViewProxy proxy) {
			super(proxy);
			LinearLayout container = new LinearLayout(proxy.getActivity());
			container.setLayoutParams(new LayoutParams(
					LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
			view = new SpinKitView(proxy.getActivity());
			view.initView(spinnerColor, spinnerStyle);
			view.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, 1000));
			view.refreshDrawableState();
			Sprite sprite = null;
			switch (spinnerStyle) {
			case 0:
				sprite = new RotatingPlane();
				break;
			case 1:
				sprite = new DoubleBounce();
				break;
			case 2:
				sprite = new Wave();
				break;
			case 3:
				sprite = new WanderingCubes();
				break;
			case 4:
				sprite = new Pulse();
				break;
			case 5:
				sprite = new ChasingDots();
				break;
			case 6:
				sprite = new ThreeBounce();
				break;
			case 7:
				sprite = new Circle();
				break;
			case 8:
				sprite = new CubeGrid();
				break;
			case 9:
				sprite = new FadingCircle();
				break;
			case 10:
				sprite = new FoldingCube();
				break;
			case 11:
				sprite = new RotatingCircle();
				break;
			}
			sprite.setColor(spinnerColor);
			view.setIndeterminateDrawable(sprite);
			container.addView(view);
			setNativeView(container);
		}

		@Override
		public void processProperties(KrollDict d) {
			super.processProperties(d);
		}
	}

}