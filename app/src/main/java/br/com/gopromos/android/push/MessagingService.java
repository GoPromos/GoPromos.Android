package br.com.gopromos.android.push;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import br.com.gopromos.android.logger.CLog;

public class MessagingService extends FirebaseMessagingService {
	@Override
	public void onMessageReceived(RemoteMessage remoteMessage) {
		CLog.d(remoteMessage.getFrom());
	}
}
