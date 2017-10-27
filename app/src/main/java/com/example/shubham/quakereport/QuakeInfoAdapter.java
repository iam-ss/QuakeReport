
package com.example.shubham.quakereport;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import static android.view.Gravity.CENTER;
import static com.example.shubham.quakereport.R.attr.height;

/**
 * Created by SHUBHAM on 25-10-2017.
 */

public class QuakeInfoAdapter extends ArrayAdapter {

    public QuakeInfoAdapter(Context context, ArrayList<EarthQuake> earthQuakeArrayList) {
        super(context, 0, earthQuakeArrayList);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if(listItemView==null){
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.quake_item_layout,parent,false);
        }

        TextView magView = (TextView)listItemView.findViewById(R.id.magView);
        TextView placeView = (TextView)listItemView.findViewById(R.id.placeView);
        TextView mainPlaceView = (TextView) listItemView.findViewById(R.id.mainPlaceView);
        TextView dateView = (TextView) listItemView.findViewById(R.id.dateView);
        TextView timeView = (TextView) listItemView.findViewById(R.id.timeView);

        EarthQuake earthQuake = (EarthQuake) getItem(position);

        magView.setText(String.valueOf(earthQuake.getMagnitude()));
        String fullPlace = String.valueOf(earthQuake.getPlace()).toUpperCase();

        String coords,mainPlace;
        int breakingIndex = fullPlace.indexOf("OF");
        if(breakingIndex!=-1){
            coords=fullPlace.substring(0,breakingIndex+2);
            mainPlace=fullPlace.substring(breakingIndex+3);

            placeView.setText(coords);
            mainPlaceView.setText(mainPlace);

        }else{
            mainPlace=fullPlace;
            placeView.setHeight(0);
            mainPlaceView.setText(mainPlace);
        }

        DateFormat dateFormat = new SimpleDateFormat("MMM dd, yyyy");
        dateView.setText(dateFormat.format(earthQuake.getDate()));

        DateFormat timeFormat = new SimpleDateFormat("hh:mm a");
        timeView.setText(timeFormat.format(earthQuake.getDate()));

        Log.d("Inside QuakeInfoAdapter","getView() : ");

        return listItemView;
    }
}
