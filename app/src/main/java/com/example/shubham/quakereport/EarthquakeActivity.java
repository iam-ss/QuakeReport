package com.example.shubham.quakereport;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Date;

public class EarthquakeActivity extends AppCompatActivity {

    private ArrayList<EarthQuake> earthQuakeArrayList;

    private void setInformationUsingJSON(){
        earthQuakeArrayList = QueryUtils.extractEarthquakes();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quake_list_view);

        setInformationUsingJSON();
        ListView listView = (ListView)findViewById(R.id.QuakeListView);
        QuakeInfoAdapter quakeInfoAdapter = new QuakeInfoAdapter(getApplicationContext(), earthQuakeArrayList);
        listView.setAdapter(quakeInfoAdapter);
    }
}
