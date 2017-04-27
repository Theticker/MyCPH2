package cph.prapas.mycph;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;

public class Service extends AppCompatActivity {

    private TextView textView;
    private ImageView imageView;
    private ListView listView;
    private String[] loginStrings;
    private String[] nameStrings,DateStrings,DetailStrings, QRcodeStrings;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);

        initialView();
        getvalueformeintent();

        createlistview();

    }

    private void createlistview() {

        String tag = "27Aprilv2";
        String urlPHP = "http://swiftcodingthai.com/cph/getProduct.php";
        try {

            GetDate getDate = new GetDate(Service.this);
            getDate.execute(urlPHP);
            String strJSON = getDate.get();
            Log.d(tag,"JSON ==>" + strJSON);

            JSONArray jsonArray = new JSONArray(strJSON);
            nameStrings = new String[jsonArray.length()];
            DateStrings = new String[jsonArray.length()];
            DetailStrings = new String[jsonArray.length()];
            QRcodeStrings = new String[jsonArray.length()];

            for (int i=0;i<jsonArray.length();i++){
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                nameStrings[i] = jsonObject.getString("Name");
                DateStrings[i] = jsonObject.getString("Date_Receive");
                DetailStrings[i] = jsonObject.getString("Description");
                QRcodeStrings[i] = jsonObject.getString("QR_code");

            }

            MyAdapter myAdapter = new MyAdapter(Service.this, nameStrings, DateStrings, DetailStrings);
            listView.setAdapter(myAdapter);



        }catch (Exception e){
            Log.d(tag," e createlistview ==>" + e.toString());


        }
    }

    private void getvalueformeintent() {
        loginStrings = getIntent().getStringArrayExtra("Loigin");
        textView.setText(loginStrings[1]);
    }

    private void initialView() {

        textView = (TextView) findViewById(R.id.textName);
        imageView = (ImageView) findViewById(R.id.imageView);
        listView = (ListView) findViewById(R.id.livProduct);
    }
}
