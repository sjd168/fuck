package com.example.myapplication;

import android.app.Application;

import com.facebook.stetho.Stetho;

/**
 * Created by SuJinde on 2019/5/28.
 */
public class App extends Application {
	@Override
	public void onCreate() {
		super.onCreate();
		Stetho.initializeWithDefaults(this);
	}
}
