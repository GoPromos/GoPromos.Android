package br.com.gopromos.android;

import com.squareup.leakcanary.RefWatcher;

public class TestApp extends App {
	@Override
	public void onCreate() {
		super.onCreate();
	}

	@Override
	protected RefWatcher enableLeakCanary() {
		return RefWatcher.DISABLED;
	}
}
