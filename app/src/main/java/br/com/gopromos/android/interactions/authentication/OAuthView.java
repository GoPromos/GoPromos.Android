package br.com.gopromos.android.interactions.authentication;

import br.com.gopromos.android.interactions.PresenterView;

public interface OAuthView extends PresenterView {
	void showService(LoginServiceConfiguration oauthConfig);

	void close();

	void showLoginDone();

	void showLoginError();
}
