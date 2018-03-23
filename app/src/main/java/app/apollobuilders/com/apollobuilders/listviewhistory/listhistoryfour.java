package app.apollobuilders.com.apollobuilders.listviewhistory;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import app.apollobuilders.com.apollobuilders.R;

/**
 * Created by Varun on 5/17/2016.
 */
public class listhistoryfour extends ArrayAdapter<String> {

    private ArrayList<String> date;
    private ArrayList<String> subject;
    Activity c;

    public listhistoryfour(Activity context, ArrayList<String> date,ArrayList<String> subject) {
        super(context, R.layout.rowhistory, date);
        this.c=context;
        this.date=date;
        this.subject=subject;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        LayoutInflater layoutInflater=c.getLayoutInflater();
        View listview=layoutInflater.inflate(R.layout.rowhistory, parent, false);

        TextView t1=(TextView)listview.findViewById(R.id.date);
        t1.setText(date.get(position));

        TextView t2=(TextView)listview.findViewById(R.id.subject);
        t2.setText(subject.get(position));




        return listview;
    }
}

