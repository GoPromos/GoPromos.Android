package br.com.gopromos.android.interactions.authentication;

import android.accounts.AccountAuthenticatorResponse;
import android.accounts.AccountManager;
import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;

import br.com.gopromos.android.R;
import br.com.gopromos.android.databinding.LoginActivityBinding;
import br.com.gopromos.android.interactions.AbstractActivity;

public class LoginActivity extends AbstractActivity {
	private static final String EXTRA_ERROR_MESSAGE = "br.com.gopromos.android.interactions.authentication.LoginActivity.ERROR_MESSAGE";
	private static final String EXTRA_IS_NEW_TASK = "br.com.gopromos.android.interactions.authentication.LoginActivity.NEW_TASK";

	LoginActivityBinding binding;
	private AccountAuthenticatorResponse mAccountAuthenticatorResponse = null;
	private Bundle mResultBundle = null;

	//region Navigation
	public static Intent newClearIntent(@NonNull Context context) {
		Intent intent = new Intent(context, LoginActivity.class);
		intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
		intent.putExtra(EXTRA_IS_NEW_TASK, true);

		return intent;
	}

	public static Intent newIntent(@NonNull Context context) {
		return new Intent(context, LoginActivity.class);
	}

	public static Intent newIntentWithError(@NonNull Context context, @NonNull String error) {
		Intent intent = newClearIntent(context);
		intent.putExtra(EXTRA_ERROR_MESSAGE, error);

		return intent;
	}
	//endregion

	public final void setAccountAuthenticatorResult(Bundle result) {
		mResultBundle = result;
	}

	@NonNull
	@Override
	protected View root() {
		return binding.getRoot();
	}

	//region Activity Events
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		setTheme(R.style.AppTheme);
		super.onCreate(savedInstanceState);

		binding = DataBindingUtil.setContentView(this, R.layout.login_activity);

		loaded();
	}

	@Override
	public void finish() {
		if (mAccountAuthenticatorResponse != null) {
			if (mResultBundle != null) {
				mAccountAuthenticatorResponse.onResult(mResultBundle);
			} else {
				mAccountAuthenticatorResponse.onError(AccountManager.ERROR_CODE_CANCELED, "canceled");
			}

			mAccountAuthenticatorResponse = null;
		}

		super.finish();
	}
	//endregion
}
