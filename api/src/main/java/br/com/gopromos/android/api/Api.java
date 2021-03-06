package br.com.gopromos.android.api;

import android.support.annotation.Nullable;

import br.com.gopromos.android.api.dtos.OAuthResponse;
import br.com.gopromos.android.uava.api.ApiResponse;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface Api {
	@POST("oauth/token")
	@FormUrlEncoded
	Observable<ApiResponse<OAuthResponse>> getToken(
		@Field("client_id") String client_id,
		@Field("state") String state,
		@Field("grant_type") String grant_type,
		@Field("username") String username,
		@Field("password") String password);

	@POST("oauth/token?grant_type=refresh_token")
	@FormUrlEncoded
	Observable<ApiResponse<OAuthResponse>> refreshToken(
		@Field("client_id") String client_id,
		@Field("state") String state,
		@Nullable @Field("access_token") String access_token,
		@Nullable @Field("refresh_token") String refresh_token);
}
