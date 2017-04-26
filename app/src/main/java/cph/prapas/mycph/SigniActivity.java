package cph.prapas.mycph;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SigniActivity extends AppCompatActivity implements View.OnClickListener {//

    private EditText nameEditText, userEditText, passEditText;
    private Button button;
    private String nameString,userString,passwordString;


    @Override
    protected void onCreate(Bundle savedInstanceState) {//
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signi);

        initialview();
        controler();
    } // method

    private void controler() {
        button.setOnClickListener(SigniActivity.this);
    }


    private void initialview() {
        nameEditText = (EditText) findViewById(R.id.edtname);
        userEditText = (EditText) findViewById(R.id.edtuser);
        passEditText = (EditText) findViewById(R.id.edtprassword);


    }


    @Override
    public void onClick(View v) {

        if (v == button) {

            // get value Form Text
            nameString = nameEditText.getText().toString().trim();
            userString = userEditText.getText().toString().trim();
            passwordString = passEditText.getText().toString().trim();

            // check space
            if (nameString.equals("")|| userString.equalsIgnoreCase("")|| passwordString.equals("")) {
                // have space
                Myalert myalert = new Myalert(SigniActivity.this);
                myalert.myDialog("มีช่องว่า ","กรุณษใส่ช่องว่างค่ะ");

            }else {
                // no spsce
                try {

                    PosData PosData = new PosData(SigniActivity.this);
                    PosData.execute(userString,nameString,passwordString);

                    String result = PosData.get();
                    Log.d("26Aprilv1","result ==>" + result);

                } catch (Exception e) {
                    Log.d("26Aprilv1","e SigniActivity ==>" + e.toString());
                }

            }

        }

    }
} // class
