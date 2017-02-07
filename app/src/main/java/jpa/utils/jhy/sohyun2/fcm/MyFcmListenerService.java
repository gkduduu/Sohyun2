package jpa.utils.jhy.sohyun2.fcm;

import android.content.Intent;
import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import java.util.Map;

import jpa.utils.jhy.sohyun2.LetterActivity;

/**
 * Created by hayoung on 2017. 1. 6..
 * gkduduu@naver.com
 */

public class MyFcmListenerService extends FirebaseMessagingService {

    @Override
    public void onMessageReceived(RemoteMessage message) {
        Map<String, String> data = message.getData();
        String title = data.get("title");
        String msg = data.get("msg");
        Log.i("jhy",title + " / " + msg + " / " + message.getData().get("title"));
        startActivity(new Intent(this,LetterActivity.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK).putExtra("msg",msg));

        // 전달 받은 정보로 뭔가를 하면 된다.
    }

}
