package br.com.gopromos.android.authenticator;

import android.support.annotation.WorkerThread;

import io.reactivex.Completable;

@FunctionalInterface
public interface LogoutService {
	@WorkerThread
	Completable logout();
}
