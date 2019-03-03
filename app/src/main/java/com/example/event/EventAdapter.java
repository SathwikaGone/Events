package com.example.event;


import static com.example.event.MainActivity.countt;

public class EventAdapter {
    private String name;
    private int count;

    public EventAdapter(String name) {
        this.name = name;
        this.count=0;
    }
    public void plusone(int position){
        int p=countt.get(position);
        int q=p+1;
        countt.set(position,q);
    }


}
