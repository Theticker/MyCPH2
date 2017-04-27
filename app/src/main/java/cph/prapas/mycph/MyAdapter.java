package cph.prapas.mycph;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * Created by Prapas on 27-Apr-17.
 */

public class MyAdapter extends BaseAdapter {

    private Context context;
    private String[] nameStrings,DateStrings,DetailStrings;

    public MyAdapter(Context context, String[] nameStrings, String[] dateStrings, String[] detailStrings) {
        this.context = context;
        this.nameStrings = nameStrings;
        DateStrings = dateStrings;
        DetailStrings = detailStrings;

    }

    @Override
    public int getCount() {
        return nameStrings.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.mylisview, parent, false);


        TextView nameTextView = (TextView) view.findViewById(R.id.textName);
        TextView dateTextView = (TextView) view.findViewById(R.id.txtDate);
        TextView detailTextView = (TextView) view.findViewById(R.id.txtDetail);

        nameTextView.setText(nameStrings[position]);
        dateTextView.setText(DateStrings[position]);
        detailTextView.setText(DetailStrings[position]);

        return view;


    }
}
