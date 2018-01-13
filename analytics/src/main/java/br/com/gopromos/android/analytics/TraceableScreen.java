package br.com.gopromos.android.analytics;

import android.support.annotation.NonNull;

@FunctionalInterface
public interface TraceableScreen {
	@NonNull
	@Screen
	String getScreenName();
}
