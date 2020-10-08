package com.example.timetables;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView list;

    public void generateTable(int table)
    {
        ArrayList<String> tableValues = new ArrayList<>();
        for(int i=1; i <=10; i++)
        {
            tableValues.add(i+" X "+table+" = "+i*table);
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, tableValues);
        list.setAdapter(adapter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final SeekBar seek = findViewById(R.id.seekBar);
        list = findViewById(R.id.listView);
        final TextView heading = findViewById(R.id.heading);

        seek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                int min = 1;
                int timesTable;
                if(progress<min)
                {
                    timesTable=min;
                    seek.setProgress(min);
                }
                else
                {
                    timesTable=progress;
                }

                heading.setText("Your are reading the table of "+timesTable);
                generateTable(timesTable);


            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        generateTable(10);
    }
}