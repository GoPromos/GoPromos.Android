package br.com.gopromos.android.logger;

import android.util.Log;

public final class CLog {
	public static void d(String log, Object... args) {
		if (BuildConfig.DEBUG) {
			Log.d(getTag(), String.format(log, args));
		}
	}

	public static void d(Throwable throwable) {
		if (BuildConfig.DEBUG) {
			Log.d(getTag(), throwable.getMessage(), throwable);
		}
	}

	public static void d(Throwable throwable, String log, Object... args) {
		if (BuildConfig.DEBUG) {
			Log.d(getTag(), String.format(log, args), throwable);
		}
	}

	public static void w(String log, Object... args) {
		if (BuildConfig.DEBUG) {
			Log.w(getTag(), String.format(log, args));
		}
	}

	public static void w(Throwable throwable) {
		if (BuildConfig.DEBUG) {
			Log.w(getTag(), throwable.getMessage(), throwable);
		}
	}

	public static void w(Throwable throwable, String log, Object... args) {
		if (BuildConfig.DEBUG) {
			Log.w(getTag(), String.format(log, args), throwable);
		}
	}

	public static void e(String log, Object... args) {
		if (BuildConfig.DEBUG) {
			Log.e(getTag(), String.format(log, args));
		}
	}

	public static void e(Throwable throwable) {
		if (BuildConfig.DEBUG) {
			Log.e(getTag(), throwable.getMessage(), throwable);
		}
	}

	public static void e(Throwable throwable, String log, Object... args) {
		if (BuildConfig.DEBUG) {
			Log.e(getTag(), String.format(log, args), throwable);
		}
	}

	private static String getTag() {
		StackTraceElement[] elements = Thread.currentThread().getStackTrace();

		if (elements.length >= 5) {
			return getSimpleName(elements[4].getClassName());
		} else {
			return "[ Android Boilerplate ]";
		}
	}

	private static String getSimpleName(String className) {
		int idx = className.lastIndexOf('.');
		return className.substring(idx + 1);
	}
}
