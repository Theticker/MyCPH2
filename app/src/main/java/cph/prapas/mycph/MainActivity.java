package cph.prapas.mycph;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.menu.MenuAdapter;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

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

        }
    }
}// main class
