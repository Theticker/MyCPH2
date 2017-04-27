package cph.prapas.mycph;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.menu.MenuAdapter;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    // Explicit

    private EditText userEditText,passEditText;
    private TextView textView;
    private Button button;

    private String userString,passwordString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {



        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initial view
        initialView();
        // controller
        controller();

    } // mail method

    private void controller() {
        textView.setOnClickListener(MainActivity.this);
        button.setOnClickListener(MainActivity.this);
    }


    private void initialView() {

        userEditText = (EditText) findViewById(R.id.edtuser);
        passEditText = (EditText) findViewById(R.id.edtprassword);
        textView = (TextView) findViewById(R.id.textRegis);
        button = (Button) findViewById(R.id.btnLogin);


    }


    @Override
    public void onClick(View v) {

        // for textView

        if (v == textView) {
            //intent to Signup
            Intent intent = new Intent(MainActivity.this,SigniActivity.class);
            startActivity(intent);

        }

        // For button
        if (v == button) {

            //get value form editext
            userString = userEditText.getText().toString().trim();
            passwordString = passEditText.getText().toString().trim();
            //ccheck space

            if ( userString.equals("")||passwordString.equals("")) {

                Myalert myalert = new Myalert(MainActivity.this);
                myalert.myDialog(" have space "," pleas fill all every B");
            }else{
                        checkuserAnPass();

            }



        }
    }

    private void checkuserAnPass() {

      try {
        //  String urlJSON = "http://swiftcodingthai.com/cph/get_data_prapas.php";
          String urlJSON = "http://swiftcodingthai.com/cph/getDataMaster.php";
          boolean b = true;
          String[] columnString = new String[]{"id", "Name", "User", "Password"};
          String[] LOginString = new String[columnString.length];




          GetDate getDate = new GetDate(MainActivity.this);
          getDate.execute(urlJSON);
          String strJSON = getDate.get();
          Log.d("27Aprilv1", "JSON ==>" + strJSON);

          JSONArray jsonArray = new JSONArray(strJSON);

          for (int i=0;i<jsonArray.length();i++) {
              JSONObject jsonObject = jsonArray.getJSONObject(i);
              if (userString.equals(jsonObject.getString("columnString[2]"))){
                  b=false;

                  for (int i1=0;i1<columnString.length;i1++){
                      LOginString[i1] = jsonObject.getString(columnString[i1]);
                      Log.d("27April1","LOginString" + i1 + ") ==>" + LOginString[i1]);


                  }
              }

          }


          if (b) {
              // User False
              Myalert myalert = new Myalert(MainActivity.this);
              myalert.myDialog("User False","No This User in my Database");

          } else if (passwordString.equals(LOginString [3])) {
              Toast.makeText(MainActivity.this, "Welcome" + LOginString[1],
                      Toast.LENGTH_SHORT).show();

              Intent intent = new Intent(MainActivity.this, Service.class);
              intent.putExtra("Login", LOginString);
              startActivity(intent);
              finish();

          } else {
              Myalert myalert = new Myalert(MainActivity.this);
              myalert.myDialog("Password False","Please Try Again Password False");

          }

      }catch ( Exception e){
          Log.d("27Aprilv1", "e checkuserAnPass ==>" + e.toString());

      }

    }
}// main class
