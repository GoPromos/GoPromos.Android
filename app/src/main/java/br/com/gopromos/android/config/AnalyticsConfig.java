package br.com.gopromos.android.config;

import android.app.Application;
import android.support.annotation.NonNull;

import br.com.gopromos.android.BuildConfig;
import com.google.firebase.analytics.FirebaseAnalytics;

import br.com.gopromos.android.analytics.AnalyticsActivityLifecycle;

public final class AnalyticsConfig {
	public static void setup(@NonNull Application application) {
		if (BuildConfig.DEBUG) {
			return;
		}

		application.registerActivityLifecycleCallbacks(new AnalyticsActivityLifecycle());
		FirebaseAnalytics.getInstance(application).setAnalyticsCollectionEnabled(!BuildConfig.DEBUG);
	}
}
