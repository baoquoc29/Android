package com.example.testaplication;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.ListFragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.testaplication.HomeFragment;

public class ViewPagerAdapter extends FragmentStateAdapter {

    public ViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0:
                return new HomeFragment();
            case 1:
                return new FragmentList();
            case 2:
                return  new Settings();
            default:
                return new HomeFragment();
        }

    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
