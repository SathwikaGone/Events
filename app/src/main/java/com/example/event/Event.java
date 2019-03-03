package com.example.event;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class Event<String> extends ArrayAdapter<String> {
String name;
int count;

    public Event(Context context, int resource, int textViewResourceId, List<String> objects) {
        super(context, resource, textViewResourceId, objects);
    }


    @Override
    public View getView(int count, View convertView, ViewGroup parent) {
        View v= super.getView(count, convertView, parent);
        TextView hoursTV = v.findViewById(android.R.id.text2);
        hoursTV.setText(MainActivity.countt.get(count).toString());
        return v;
    }
}
