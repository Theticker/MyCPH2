package cph.prapas.mycph;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;


public class Myalert {

    private Context context;

    public Myalert(Context context) {

        this.context = context;
    }

    public void myDialog(String strTitle, String strMessage){

        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setCancelable(false);
        builder.setIcon(R.mipmap.ic_name);
        builder.setTitle(strTitle);
        builder.setMessage(strMessage);
        builder.setPositiveButton("ok ", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.show();

    }
}// class
