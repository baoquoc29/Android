package com.example.testaplication;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {
    private BottomNavigationView bottomNavigationView;
    private ViewPager2 viewPager;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigationView = findViewById(R.id.bottom_nav);
        viewPager = findViewById(R.id.mviewPager);
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(this);
        viewPager.setAdapter(viewPagerAdapter);
        viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                switch (position){
                    case 0:
                        bottomNavigationView.getMenu().findItem(R.id.action_home).setChecked(true);
                        break;
                    case 1:
                        bottomNavigationView.getMenu().findItem(R.id.favorite).setChecked(true);
                        break;
                    case 2:
                        bottomNavigationView.getMenu().findItem(R.id.person).setChecked(true);
                        break;
                }
            }
        });
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
               if(item.getItemId() == R.id.action_home){
                   viewPager.setCurrentItem(0);
               }
               if(item.getItemId() == R.id.favorite){
                   viewPager.setCurrentItem(1);
               }
                if(item.getItemId() == R.id.person){
                    viewPager.setCurrentItem(2);
                }
               return  true;
            }
        });
    }

}