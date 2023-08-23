package com.example.testaplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.AbsListView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;
public class BlackCloverChap1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_black_clover_chap1);
        add_list();
        listView = findViewById(R.id.recyleView);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,1);
        listView.setLayoutManager(gridLayoutManager);
        PhotoAdapter1 adapter = new PhotoAdapter1(list);
        listView.setAdapter(adapter);
    }
    private void add_list(){
        list.add(new urlimage("https://i2.bumcheo1.info/147/147235/001.jpg"));
        list.add(new urlimage("https://i2.bumcheo1.info/147/147235/002.jpg"));
        list.add(new urlimage("https://i2.bumcheo1.info/147/147235/003.jpg"));
        list.add(new urlimage("https://i2.bumcheo1.info/147/147235/004.jpg"));
        list.add(new urlimage("https://i2.bumcheo1.info/147/147235/005.jpg"));
        list.add(new urlimage("https://i2.bumcheo1.info/147/147235/006.jpg"));
        list.add(new urlimage("https://i2.bumcheo1.info/147/147235/007.jpg"));
        list.add(new urlimage("https://i2.bumcheo1.info/147/147235/008.jpg"));
        list.add(new urlimage("https://i2.bumcheo1.info/147/147235/009.jpg"));
        list.add(new urlimage("https://i2.bumcheo1.info/147/147235/010.jpg"));
        list.add(new urlimage("https://i2.bumcheo1.info/147/147235/011.jpg"));
        list.add(new urlimage("https://i2.bumcheo1.info/147/147235/012.jpg"));
        list.add(new urlimage("https://i2.bumcheo1.info/147/147235/013.jpg"));
        list.add(new urlimage("https://i2.bumcheo1.info/147/147235/014.jpg"));
        list.add(new urlimage("https://i2.bumcheo1.info/147/147235/015.jpg"));
        list.add(new urlimage("https://i2.bumcheo1.info/147/147235/016.jpg"));
        list.add(new urlimage("https://i2.bumcheo1.info/147/147235/017.jpg"));
        list.add(new urlimage("https://i2.bumcheo1.info/147/147235/018.jpg"));
        list.add(new urlimage("https://i2.bumcheo1.info/147/147235/019.jpg"));
        list.add(new urlimage("https://i2.bumcheo1.info/147/147235/020.jpg"));
        list.add(new urlimage("https://i2.bumcheo1.info/147/147235/021.jpg"));
        list.add(new urlimage("https://i2.bumcheo1.info/147/147235/022.jpg"));
        list.add(new urlimage("https://i2.bumcheo1.info/147/147235/023.jpg"));
        list.add(new urlimage("https://i2.bumcheo1.info/147/147235/024.jpg"));
        list.add(new urlimage("https://i2.bumcheo1.info/147/147235/025.jpg"));
        list.add(new urlimage("https://i2.bumcheo1.info/147/147235/026.jpg"));
        list.add(new urlimage("https://i2.bumcheo1.info/147/147235/027.jpg"));
        list.add(new urlimage("https://i2.bumcheo1.info/147/147235/028.jpg"));
        list.add(new urlimage("https://i2.bumcheo1.info/147/147235/029.jpg"));
        list.add(new urlimage("https://i2.bumcheo1.info/147/147235/030.jpg"));
        list.add(new urlimage("https://i2.bumcheo1.info/147/147235/031.jpg"));
        list.add(new urlimage("https://i2.bumcheo1.info/147/147235/032.jpg"));
        list.add(new urlimage("https://i2.bumcheo1.info/147/147235/033.jpg"));
        list.add(new urlimage("https://i2.bumcheo1.info/147/147235/034.jpg"));
        list.add(new urlimage("https://i2.bumcheo1.info/147/147235/035.jpg"));
        list.add(new urlimage("https://i2.bumcheo1.info/147/147235/036.jpg"));
        list.add(new urlimage("https://i2.bumcheo1.info/147/147235/037.jpg"));
        list.add(new urlimage("https://i2.bumcheo1.info/147/147235/038.jpg"));
        list.add(new urlimage("https://i2.bumcheo1.info/147/147235/039.jpg"));
        list.add(new urlimage("https://i2.bumcheo1.info/147/147235/040.jpg"));
        list.add(new urlimage("https://i2.bumcheo1.info/147/147235/041.jpg"));
        list.add(new urlimage("https://i2.bumcheo1.info/147/147235/042.jpg"));
        list.add(new urlimage("https://i2.bumcheo1.info/147/147235/043.jpg"));
        list.add(new urlimage("https://i2.bumcheo1.info/147/147235/044.jpg"));
        list.add(new urlimage("https://i2.bumcheo1.info/147/147235/045.jpg"));
        list.add(new urlimage("https://i2.bumcheo1.info/147/147235/046.jpg"));
        list.add(new urlimage("https://i2.bumcheo1.info/147/147235/047.jpg"));
        list.add(new urlimage("https://i2.bumcheo1.info/147/147235/048.jpg"));
        list.add(new urlimage("https://i2.bumcheo1.info/147/147235/049.jpg"));
        list.add(new urlimage("https://i2.bumcheo1.info/147/147235/050.jpg"));
        list.add(new urlimage("https://i2.bumcheo1.info/147/147235/051.jpg"));
    }
    private RecyclerView listView;
    private List<urlimage> list = new ArrayList<>();
}



