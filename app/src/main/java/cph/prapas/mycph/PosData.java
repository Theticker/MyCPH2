package cph.prapas.mycph;


import android.content.Context;
import android.os.AsyncTask;
import android.speech.tts.Voice;
import android.util.Log;

import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

public class PosData extends AsyncTask<String, Void ,String>{

    private Context context;
    //private static  final String urlPHP = "//http://swiftcodingthai.com/cph/addUserPrapas.php";
    private static  final String urlPHP = "//http://swiftcodingthai.com/cph/addUserMater.php";

    public PosData(Context context) {
        this.context = context;
    }

    @Override
    protected String doInBackground(String... params) {

        try {

            OkHttpClient okHttpClient = new OkHttpClient();
            RequestBody requestBody  = new FormEncodingBuilder()
                    .add("isAss","true")
                    .add("User", params[0])
                    .add("Name",params[1])
                    .add("Password",params[2])
                    .build();
            Request.Builder builder = new  Request.Builder();
            Request request = builder.url(urlPHP).post(requestBody).build();
            Response response = okHttpClient.newCall(request).execute();
            return response.body().string();




        } catch (Exception e) {
            Log.d("26Aprilv1","e doin ==>" + e.toString());
            return null;

        }

    }
}
