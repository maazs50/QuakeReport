package com.example.android.quakereport;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by Mohammed Maaz S on 22-03-18.
 */

public class EarthQuakeAdapter extends ArrayAdapter<EarthQuake> {
    public EarthQuakeAdapter(Context context, ArrayList<EarthQuake> earthQuakeAdapter) {
        super(context, 0,earthQuakeAdapter);
    }

    @Override
    public View getView(int position,  View convertView, ViewGroup parent) {
View listItemView=convertView;
if (listItemView==null){
    listItemView= LayoutInflater.from(getContext()).inflate(R.layout.list,parent,false);
}
EarthQuake currentEarthQuake=getItem(position);
        TextView magnitude=(TextView)listItemView.findViewById(R.id.magnitude);
        String mag=String.valueOf(currentEarthQuake.getMagnitude());
        magnitude.setText(mag);
        TextView city=(TextView)listItemView.findViewById(R.id.city);
        city.setText(currentEarthQuake.getCity());

        TextView date=(TextView)listItemView.findViewById(R.id.date);
        date.setText(currentEarthQuake.getDate());
        return listItemView;
    }
}
