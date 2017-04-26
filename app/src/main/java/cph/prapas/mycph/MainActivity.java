package cph.prapas.mycph;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // Explicit

    private EditText userEditText,passEditText;
    private TextView textView;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        // Initial view
        initialView();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    } // mail method

    private void initialView() {

        userEditText = (EditText) findViewById(R.id.edtuser);
        passEditText = (EditText) findViewById(R.id.edtprassword);
        textView = (TextView) findViewById(R.id.textRegis);
        button = (Button) findViewById(R.id.btnLogin);


    }


}// main class
