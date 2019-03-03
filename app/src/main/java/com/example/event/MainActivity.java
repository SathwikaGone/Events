package com.example.event;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public  class MainActivity extends AppCompatActivity {
    private int count1;
    private String name;
    private int pt=-1;
    protected static ArrayList<String> evnt=new ArrayList<String>();
    protected static ArrayList<Integer> countt = new ArrayList<Integer>();
 //
private void initmodel(){
    this.count1=0;

}


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Event<String> eventAdapter = new Event<>(this, android.R.layout.simple_list_item_2, android.R.id.text1, evnt);
        final ListView eventview = findViewById(R.id.eventview);
        eventview.setAdapter(eventAdapter);
        eventview.setOnItemClickListener(new ListView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                initmodel();
                pt=position;
                EventAdapter event1=new EventAdapter(name);
                event1.plusone(position);
                Toast.makeText(getApplicationContext(), "Event name is " + evnt.get(position) , Toast.LENGTH_LONG).show();
                eventview.invalidateViews();

            }
        });
    }



        public void AddEvent(View v) {
            final ListView eventview = findViewById(R.id.eventview);
            EditText et = (EditText) findViewById(R.id.editText);
            name = et.getText().toString();
            evnt.add(name);
            countt.add(0);
            eventview.invalidateViews();
        }
    public void Sort(View v) {
Event<String> eventAdapter = new Event<>(this, android.R.layout.simple_list_item_1, android.R.id.text1, evnt);
      final ListView eventview = findViewById(R.id.eventview);
//        List<String> list=new ArrayList<String>(Arrays.asList(evnt));
//        Collections.sort(evnt);
        Collections.sort(evnt, new Comparator<String>(){
           public int compare(String ob1,String ob2 ){
               return ob1.toString().compareToIgnoreCase(ob2.toString());
           }
        });

//            Comparator<String> order = new Comparator<String>(){
//                public int compare(String ob1,String ob2){
//                    int res= String.CASE_INSENSITIVE_ORDER.compare(ob1.toString(),ob2.toString());
//                    return res;
//                }
//            };
           // Collections.sort(evnt,order);
        eventview.setAdapter(eventAdapter);
        eventview.invalidateViews();
     //   eventAdapter.notifyDataSetChanged();
    }
    public void delete(View v) {
        Event<String> eventAdapter = new Event<>(this, android.R.layout.simple_list_item_1, android.R.id.text1, evnt);
        final ListView eventview = findViewById(R.id.eventview);
        if (pt != -1) {
            evnt.remove(pt);
            countt.remove(pt);
            pt = -1;
        } else {
            Toast.makeText(getApplicationContext(), "No Event name is selected", Toast.LENGTH_LONG).show();
        }
            eventview.invalidateViews();

    }
    }





