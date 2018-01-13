package br.com.gopromos.android.interactions.authentication;

import android.support.annotation.NonNull;

import br.com.gopromos.android.App;
import br.com.gopromos.android.R;
import br.com.gopromos.android.interactions.ViewPresenter;

class OAuthPresenter extends ViewPresenter<OAuthView> {
	OAuthPresenter(@NonNull OAuthView view) {
		super(view);
	}

	void loadService(String serviceName) {
		String fbID = App.getInstance().getResources().getString(R.string.facebook_app_id);
		String service = "facebook";

		getView().showService(new LoginServiceConfiguration("", service, fbID));
	}
}
