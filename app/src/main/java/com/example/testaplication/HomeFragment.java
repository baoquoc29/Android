package com.example.testaplication;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.Dialog;
import android.content.ClipData;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;


import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import me.relex.circleindicator.CircleIndicator;

public class HomeFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.homefragment,container,false);
        viewPager = view.findViewById(R.id.viewPager);
        indicator = view.findViewById(R.id.cricleIndicator);
        photoAdapter = new PhotoAdapter(getActivity(),getList());
        viewPager.setAdapter(photoAdapter);
        indicator.setViewPager(viewPager);
        gridView = view.findViewById(R.id.gridView);
        photoAdapter.registerDataSetObserver(indicator.getDataSetObserver());
        auto_slide();
        listCustom.add(new CustomPhoto(R.drawable.aot,"Attack On Titan","Isayama Hajime"));
        listCustom.add(new CustomPhoto(R.drawable.fb,"Fruit Backest"," Natsuki Takaya"));
        listCustom.add(new CustomPhoto(R.drawable.aa,"Spy x Family","Anya Forger"));
        listCustom.add(new CustomPhoto(R.drawable.blcv,"Black Clover","Tabata Suichi"));
        listCustom.add(new CustomPhoto(R.drawable.naruto,"Naruto ","Nastuoki Ore"));
        listCustom.add(new CustomPhoto(R.drawable.onepice,"One Piece","Muichiro Oda"));
        AdapterCustom adapter = new AdapterCustom(getActivity(),R.layout.custom_list_view,listCustom);
        gridView.setAdapter(adapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String url;
                if(i==0){
                    url = "https://danet.vn/dai-chien-nguoi-khong-lo-1556852718.html";
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse(url));
                    startActivity(intent);
                }
                if(i==1){
                    url = "https://animevietsub.moe/phim/fruits-basket-2019-a3446/";
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse(url));
                    startActivity(intent);
                }
                if(i==2){
                    url = "https://vieon.vn/spy-x-family-gia-dinh-diep-vien.html";
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse(url));
                    startActivity(intent);
                }
                if(i==3){
                    url = "https://animevietsub.moe/phim/the-gioi-phep-thuat-a474/";
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse(url));
                    startActivity(intent);
                }
                if(i==4){
                    url = "https://pops.vn/series/naruto-5fc5f17fca8af00034b846ae";
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse(url));
                    startActivity(intent);
                }
                if(i==5){
                    url = "https://www.iq.com/album/one-piece-dao-hai-tac-1999-1bk9icvr331?lang=vi_vn";
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse(url));
                    startActivity(intent);
                }
            }
        });
        return view;
    }

    private List<Photo> getList(){
        listPhoto.add(new Photo(R.drawable.aot));
        listPhoto.add(new Photo(R.drawable.fb));
        listPhoto.add(new Photo(R.drawable.blcv));
        listPhoto.add(new Photo(R.drawable.kmy));
        listPhoto.add(new Photo(R.drawable.naruto));
        listPhoto.add(new Photo(R.drawable.onepice));
        return listPhoto;
    }


    private void auto_slide(){
        if(listPhoto == null || viewPager == null || listPhoto.isEmpty()){
            return;
        }
        // init timer;
        if(timer == null){
            timer = new Timer();
        }
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    @Override
                    public void run() {
                        int current = viewPager.getCurrentItem();
                        int total = listPhoto.size()-1;
                        if(current < total){
                            ++current;
                            viewPager.setCurrentItem(current);
                        }
                        else{
                            // khi đã lướt tới cuối cùng
                            viewPager.setCurrentItem(0);
                        }
                    }
                });
            }
        },500,3000);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if(timer!=null){
            timer.cancel();
            timer = null;
        }
    }

    private Button btnLogin;
    private Button btnSignup;
    private TextView datalogin;
    private TextView textUsername;
    private TextView textPassword;
    private ViewPager viewPager;
    private CircleIndicator indicator;
    private PhotoAdapter photoAdapter;
    private Timer timer;
    private List<Photo> listPhoto = new ArrayList<>();
    private List<CustomPhoto> listCustom = new ArrayList<>();
    private GridView gridView;

}