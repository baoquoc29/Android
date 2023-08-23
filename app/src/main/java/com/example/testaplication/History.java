package com.example.testaplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;
import java.util.List;

public class History extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        list_view_history = findViewById(R.id.list_item_history);
        PhotoCustomListView adapter = new PhotoCustomListView(History.this,R.layout.custom_listview,HomeFragment.list_history);
        list_view_history.setAdapter(adapter);
        int count = HomeFragment.list_history.size();
        if(count == 0){
            Toast.makeText(History.this, "Hôm Nay Bạn Chưa Xem Gì Cả", Toast.LENGTH_SHORT).show();
        }
        list_view_history.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int location, long l) {
                AlertDialog.Builder builder = new AlertDialog.Builder(History.this);
                int index = location;
                builder.setTitle("Xóa Khỏi Lịch Sử Xem");
                builder.setCancelable(true);
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        HomeFragment.list_history.remove(index);
                        adapter.notifyDataSetChanged();
                        Toast.makeText(History.this, "Xóa Thành Công", Toast.LENGTH_SHORT).show();
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