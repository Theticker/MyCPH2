package cph.prapas.mycph;


import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

public class GetDate  extends AsyncTask<String,Void,String>{

    private Context context;

    public GetDate(Context context) {
        this.context = context;

    }

    @Override
    protected String doInBackground(String... params) {

        try {

            OkHttpClient okHttpClient = new OkHttpClient();
            Request.Builder builder = new Request.Builder();
            Request request = builder.url(params[0]).build();
            Response response = okHttpClient.newCall(request).execute();
            return response.body().string();

        } catch (Exception e) {
            Log.d("27Aprilv1", "e doInBackground ==>" + e.toString());
            return null;
        }

    }
}
