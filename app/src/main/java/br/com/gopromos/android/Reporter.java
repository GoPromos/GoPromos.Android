package br.com.gopromos.android;

import com.crashlytics.android.Crashlytics;
import com.google.firebase.crash.FirebaseCrash;

import br.com.gopromos.android.logger.CLog;
import io.fabric.sdk.android.Fabric;

public final class Reporter {
	public static void report(Throwable throwable) {
		CLog.e(throwable);

		if (BuildConfig.DEBUG) {
			return;
		}

		if (FirebaseCrash.isCrashCollectionEnabled()) {
			FirebaseCrash.report(throwable);
		}

		if (Fabric.isInitialized()) {
			Crashlytics.logException(throwable);
		}
	}
}
