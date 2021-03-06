package br.com.gopromos.android.uava;

import android.support.annotation.Nullable;

public class Optional<T> {
	private final T value;

	private Optional(T value) {
		this.value = value;
	}

	public boolean isPresent() {
		return value != null;
	}

	public boolean isNotPresent() {
		return value == null;
	}

	public static <T> Optional<T> from(T value) {
		if (value == null) {
			throw new NullPointerException();
		}

		return new Optional<>(value);
	}

	public static <T> Optional<T> fromNullable(@Nullable T value) {
		return new Optional<>(value);
	}

	public static <T> Optional<T> empty() {
		return new Optional<>(null);
	}

	public T get() {
		return value;
	}

	public T getOrDefault(T defaultValue) {
		if (isPresent()) {
			return value;
		}

		return defaultValue;
	}
}
