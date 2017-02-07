package jpa.utils.jhy.sohyun2.fcm;

import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONObject;

import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by hayoung on 2017. 1. 6..
 * gkduduu@naver.com
 */

public class FcmSender extends AsyncTask<String,Integer,Integer>{

    public final static String AUTH_KEY_FCM = "AAAALwTzbi8:APA91bHZNe8GAAbL4bTjW-c7EmjiDe0jF2eeIoCc1H0P7Uz83iRVY22Q1UcGi7KSwDS4oznerYORh8vilCt1m-xjRtmoOpKATD835dz9XNmrQ_-J330uJxr59cCzGkM3q-3EO3F6UJSU";
    public final static String API_URL_FCM = "https://fcm.googleapis.com/fcm/send";

    public FcmSender() {
        super();
    }

    private String msg = "";

    public void setMsg (String m){
        this.msg = m;
    }

    @Override
    protected Integer doInBackground(String... params) {
        pushFCMNotification(params[0]);
        return null;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected void onPostExecute(Integer integer) {
        super.onPostExecute(integer);
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected void onCancelled(Integer integer) {
        super.onCancelled(integer);
    }

    @Override
    protected void onCancelled() {
        super.onCancelled();
    }

    public static void pushFCMNotification(String text) {

        String authKey = AUTH_KEY_FCM;   // You FCM AUTH key
        String FMCurl = API_URL_FCM;

        try {
            URL url = new URL(FMCurl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setUseCaches(false);
            conn.setDoInput(true);
            conn.setDoOutput(true);

            conn.setRequestMethod("POST");
            conn.setRequestProperty("Authorization", "key=" + authKey);
            conn.setRequestProperty("Content-Type", "application/json");
            JSONObject json = new JSONObject();
            json.put("to", "/topics/vubyiausd89v7sd0897vasd897c0a7e8uv9accue89ca98c");
            JSONObject info = new JSONObject();
            info.put("title", "Notificatoin Title");   // Notification title
            info.put("msg", text); // Notification body
            json.put("data", info);

            OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
            wr.write(json.toString());
            wr.flush();
        }catch (Exception e) {
        }
    }
}
