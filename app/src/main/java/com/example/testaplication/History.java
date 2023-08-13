package com.example.testaplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class History extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        list_view_history = findViewById(R.id.list_item_history);
        PhotoCustomListView adapter = new PhotoCustomListView(History.this,R.layout.custom_listview,HomeFragment.list_history);
        list_view_history.setAdapter(adapter);
        if(HomeFragment.list_history.isEmpty()){
            Toast.makeText(History.this, "Hôm Nay Bạn Chưa Xem Gì", Toast.LENGTH_SHORT).show();
        }
        list_view_history.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int pos, long l) {
                int index = pos;
                AlertDialog.Builder builder = new AlertDialog.Builder(History.this);
                builder.setTitle("Xóa Khỏi Lịch Sử Xem!");
                builder.setMessage("Bạn Có Chắc Chắn Muốn Xóa?");
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        HomeFragment.list_history.remove(index);
                        adapter.notifyDataSetChanged();
                    }
                });
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.cancel();
                    }
                });
                builder.show();
            }
        });
    }
    private ListView list_view_history;
}