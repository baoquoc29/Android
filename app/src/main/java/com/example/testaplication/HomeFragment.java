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
                    list_history.add(listCustom.get(0));
                }
                if(i==1){
                    url = "https://animevietsub.moe/phim/fruits-basket-2019-a3446/";
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse(url));
                    startActivity(intent);
                    list_history.add(listCustom.get(1));
                }
                if(i==2){
                    url = "https://vieon.vn/spy-x-family-gia-dinh-diep-vien.html";
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse(url));
                    startActivity(intent);
                    list_history.add(listCustom.get(2));
                }
                if(i==3){
                    url = "https://animevietsub.moe/phim/the-gioi-phep-thuat-a474/";
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse(url));
                    startActivity(intent);
                    list_history.add(listCustom.get(3));
                }
                if(i==4){
                    url = "https://pops.vn/series/naruto-5fc5f17fca8af00034b846ae";
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse(url));
                    startActivity(intent);
                    list_history.add(listCustom.get(4));
                }
                if(i==5){
                    url = "https://www.iq.com/album/one-piece-dao-hai-tac-1999-1bk9icvr331?lang=vi_vn";
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse(url));
                    startActivity(intent);
                    list_history.add(listCustom.get(5));
                }
            }
        });
        anya = view.findViewById(R.id.anya);
        naruto = view.findViewById(R.id.naruto);
        levi = view.findViewById(R.id.levi);
        tanjiro = view.findViewById(R.id.Tanjiro);
        asta = view.findViewById(R.id.asta);
        eren = view.findViewById(R.id.eren);
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        anya.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                builder.setTitle("Thông Tin Về Nhân Vật Anya");
                builder.setMessage("Một cô bé có thể đọc được suy nghĩ của người khác, Anya là người duy nhất biết được tình hình chung của gia đình mình. Tuổi thật sự của cô bé tầm khoảng 4 hoặc 5 tuổi, nhưng lại nói là 6 tuổi vì trường chỉ nhận trẻ 6 tuổi trở lên. Ban đầu, cô bé là một đối tượng thử nghiệm trên người được đặt tên là \"Vật thí nghiệm 007\" (被検体007?), cô đã trốn đi bởi vì ở đó cô phải học mà không được chơi. Sau đó tự đặt tên là \"Anya.\" ");
                builder.show();
            }
        });
        naruto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                builder.setTitle("Thông Tin Về Nhân Vật Naruto");
                builder.setMessage("Uzumaki Naruto là nhân vật hư cấu trong bộ manga và anime Naruto của tác giả người Nhật Masashi Kishimoto. Anh là một ninja trẻ tuổi từ làng Lá — một ngôi làng giả tưởng và đóng vai trò là nhân vật chính trong bộ truyện cùng tên");
                builder.show();
            }
        });
        asta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                builder.setTitle("Thông Tin Về Nhân Vật Asta");
                builder.setMessage("Được dịch từ tiếng Anh-Asta là một nhân vật hư cấu và là nhân vật chính của loạt manga Black Clover do Yūki Tabata tạo ra. Là một nông dân mồ côi bị bỏ lại tại một nhà thờ, anh khao khát trở thành Vua pháp sư tiếp theo.");
                builder.show();
            }
        });
        tanjiro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                builder.setTitle("Thông Tin Về Nhân Vật Tanjiro");
                builder.setMessage("Kamado Tanjirō là một nhân vật hư cấu và là nhân vật chính trong loạt manga Thanh gươm diệt quỷ của tác giả Gotōge Koyoharu. Tanjirō trở thành kiếm sĩ để đưa em gái hóa quỷ của mình là Nezuko trở lại thành người và trả thù cho những người thân bị quỷ tàn sát");
                builder.show();
            }
        });
        levi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                builder.setTitle("Thông Tin Về Nhân Vật Levi");
                builder.setMessage("Được dịch từ tiếng Anh-Levi Ackerman là một nhân vật hư cấu trong bộ truyện tranh Attack on Titan của Hajime Isayama. Levi là một người lính làm việc cho Đội Hoạt động Đặc biệt của Quân đoàn Khảo sát, còn được gọi là Biệt đội Levi, một đội gồm bốn người lính tinh nhuệ với thành tích chiến đấu ấn tượng do chính tay anh tuyển chọn.");
                builder.show();
            }
        });
        eren.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                builder.setTitle("Thông Tin Về Nhân Vật Eren");
                builder.setMessage("Eren Yeager, hay Eren Jaeger trong bản phụ đề và lồng tiếng của anime Đại chiến Titan, là một nhân vật hư cấu và là nhân vật chính trong loạt manga Đại chiến Titan của tác giả Isayama Hajime");
                builder.show();
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
    public static List<CustomPhoto> list_history = new ArrayList<>();
    private de.hdodenhof.circleimageview.CircleImageView asta;
    private de.hdodenhof.circleimageview.CircleImageView naruto;
    private de.hdodenhof.circleimageview.CircleImageView tanjiro;
    private de.hdodenhof.circleimageview.CircleImageView anya;
    private de.hdodenhof.circleimageview.CircleImageView eren;
    private de.hdodenhof.circleimageview.CircleImageView levi;

}