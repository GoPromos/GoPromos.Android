package br.com.gopromos.android;

import android.os.StrictMode;

import br.com.gopromos.android.logger.CLog;
import br.com.gopromos.android.trackers.ActivityLifecycleTracker;
import br.com.gopromos.android.trackers.FragmentLifecycleTracker;
import br.com.gopromos.android.trackers.FrescoCacheStatsTracker;
import com.facebook.imagepipeline.core.ImagePipelineConfig;
import com.facebook.stetho.Stetho;
import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;
import com.tspoon.traceur.Traceur;

public class DebugApp extends App {
	@Override
	public void onCreate() {
		if (LeakCanary.isInAnalyzerProcess(this)) {
			return;
		}

		super.onCreate();

		Stetho.initialize(
			Stetho.newInitializerBuilder(this)
				.enableDumpapp(Stetho.defaultDumperPluginsProvider(this))
				.enableWebKitInspector(Stetho.defaultInspectorModulesProvider(this))
				.build());

		trackActivitiesAndFragmentsLifecycle();
		Traceur.enableLogging();

		enableStrictMode();
	}

	@Override
	public void onTrimMemory(int level) {
		super.onTrimMemory(level);
		CLog.d("[ onTrimMemory ] " + level);
	}

	@Override
	protected RefWatcher enableLeakCanary() {
		return LeakCanary.refWatcher(this).buildAndInstall();
	}

	private void enableStrictMode() {
		StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder()
			.detectAll()
			.penaltyFlashScreen()
			.penaltyLog()
			.penaltyDeath()
			.build());

		StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder()
			.detectAll()
			.penaltyLog()
			.penaltyDeath()
			.build());
	}

	@Override
	protected void trackFresco(ImagePipelineConfig.Builder builder) {
		builder.setImageCacheStatsTracker(new FrescoCacheStatsTracker());
	}

	private void trackActivitiesAndFragmentsLifecycle() {
		final FragmentLifecycleTracker fragmentLifecycleTracker = new FragmentLifecycleTracker();
		final ActivityLifecycleTracker activityLifecycleTracker = new ActivityLifecycleTracker(fragmentLifecycleTracker);

		registerActivityLifecycleCallbacks(activityLifecycleTracker);
	}
}
