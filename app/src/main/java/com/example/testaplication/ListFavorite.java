package com.example.testaplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

public class ListFavorite extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_favorite);
        list = findViewById(R.id.list_view_favorite);
        PhotoCustomListView adapter = new PhotoCustomListView(ListFavorite.this,R.layout.custom_listview,FragmentList.list_Favorite);
        list.setAdapter(adapter);
    }
    private ListView list;

}