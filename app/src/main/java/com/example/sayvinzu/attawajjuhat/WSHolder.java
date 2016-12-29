package com.example.sayvinzu.attawajjuhat;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by SAYVINZU on 22/07/2016.
 */
public class WSHolder extends RecyclerView.ViewHolder {

    TextView a,b;
    private int size;

    public WSHolder(View itemView) {
        super(itemView);

        atur am = new atur();
        size = am.getAngka();

        a = (TextView)itemView.findViewById(R.id.ayat);
        a.setTextSize(size);
        b = (TextView)itemView.findViewById(R.id.terjemah);

    }

}