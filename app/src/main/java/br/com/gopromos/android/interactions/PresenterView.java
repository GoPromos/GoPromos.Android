package br.com.gopromos.android.interactions;

import br.com.gopromos.android.uava.interfaces.RetryCallback;

public interface PresenterView {
	void showLoading();

	void loaded();

	void error(Throwable throwable);

	void errorWithRetry(Throwable throwable, RetryCallback retryAction);
}
