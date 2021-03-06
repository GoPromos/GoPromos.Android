package br.com.gopromos.android.api;

import br.com.gopromos.android.uava.api.UavaCallAdapterFactory;
import com.google.gson.Gson;

import java.io.File;

import io.reactivex.annotations.NonNull;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public final class ApiBuilder {
	static Api api = null;

	public static Api get(
		@NonNull OkHttpClient.Builder okBuilder,
		@NonNull Gson gson,
		@NonNull Config config) {
		if (api == null) {
			api = build(okBuilder, gson, config);
		}

		return api;
	}

	public static Api build(
		@NonNull OkHttpClient.Builder okBuilder,
		@NonNull Gson gson,
		@NonNull Config config) {

		File httpCacheDirectory = new File(config.getCacheDir(), config.getCacheName());
		int cacheSize = config.getCacheSize();
		Cache cache = new Cache(httpCacheDirectory, cacheSize);

		okBuilder
			.cache(cache)
			.followRedirects(true)
			.followSslRedirects(true);

		return new Retrofit.Builder()
			.baseUrl(config.getUri())
			.addConverterFactory(GsonConverterFactory.create(gson))
			.addCallAdapterFactory(new UavaCallAdapterFactory())
			.addCallAdapterFactory(RxJava2CallAdapterFactory.create())
			.client(okBuilder.build())
			.build()
			.create(Api.class);
	}
}
