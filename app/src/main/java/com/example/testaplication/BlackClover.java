package com.example.testaplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class BlackClover extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_black_clover);
        listView = findViewById(R.id.listviewblack);
        List<String> list = new ArrayList<>();
        list.add("Chapter 1");
        list.add("Chapter 2");
        list.add("Chapter 3");
        list.add("Chapter 4");
        list.add("Chapter 5");
        list.add("Chapter 6");
        list.add("Chapter 7");
        list.add("Chapter 8");
        list.add("Chapter 9");
        list.add("Chapter 10");
        list.add("Chapter 11");
        ArrayAdapter adapter = new ArrayAdapter(BlackClover.this, android.R.layout.simple_expandable_list_item_1,list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if(i==0){
                    Intent intent = new Intent(BlackClover.this,BlackCloverChap1.class);
                    startActivity(intent);
                }
            }
        });


    }
    private ListView listView;
}