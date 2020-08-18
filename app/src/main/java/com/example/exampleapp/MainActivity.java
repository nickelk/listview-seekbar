package com.example.exampleapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ListView list;
    private SeekBar seek;
    private String [] names = new String[] {"John", "Bob", "George", "Alex"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list();
    }

    public void list(){
        list = (ListView)findViewById(R.id.listView);
        ArrayAdapter <String> adapter = new ArrayAdapter <String>(this, R.layout.names, names);
        list.setAdapter(adapter);
        seek = (SeekBar)findViewById(R.id.seekBar);
        list.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        String val = (String)list.getItemAtPosition(i);
                        Toast.makeText(
                                MainActivity.this,
                                "Позиция" + i + ", значение: " + val + ", прогресс - " + seek.getProgress(),
                                Toast.LENGTH_LONG
                        ).show();
                    }
                }
        );
    }
}