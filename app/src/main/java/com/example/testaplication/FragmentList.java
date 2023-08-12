package com.example.testaplication;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import android.app.SearchManager;
import android.database.Cursor;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class FragmentList extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_fragment_list,container,false);
        listViewItem = view.findViewById(R.id.ListViewItem);
        Toolbar toolbar = view.findViewById(R.id.toolbar);
        AppCompatActivity activity = (AppCompatActivity) getActivity();
        if (activity != null) {
            activity.setSupportActionBar(toolbar);
            setHasOptionsMenu(true); // Bật sử dụng menu tùy chọn
        }

        list.add(new CustomPhoto(R.drawable.naruto,"Naruto","Top 5 Manga List"));
        list.add(new CustomPhoto(R.drawable.blcv,"Black CLover","Top 2 Manga List"));
        list.add(new CustomPhoto(R.drawable.onepice,"One Piece","Top 1 Manga List"));
        list.add(new CustomPhoto(R.drawable.aot,"Attack On Titan","Top 25 Manga List"));
        list.add(new CustomPhoto(R.drawable.aa,"Spy x Family","Top 32 Manga List"));
        list.add(new CustomPhoto(R.drawable.kmy,"Kimetsu No Yaiba","Top 12 Manga List"));
        list.add(new CustomPhoto(R.drawable.fb,"Fruit Kiss","Top 22 Manga List"));
        list.add(new CustomPhoto(R.drawable.eren,"Imortal Demon","Top 3 Manga List"));
        list.add(new CustomPhoto(R.drawable.asta,"Dementry Dezus","Top 77 Manga List"));
        list.add(new CustomPhoto(R.drawable.mangaimg,"Dragon Ball","Top 4 Manga List"));
         adapter = new PhotoCustomListView(getActivity(),R.layout.custom_listview,list);
        listViewItem.setAdapter(adapter);

        return view;
    }


    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.search_menu, menu);
        SearchManager searchManager = (SearchManager)getActivity().getSystemService(getActivity().SEARCH_SERVICE);
        searchView = (SearchView) menu.findItem(R.id.action_search).getActionView();
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getActivity().getComponentName()));
        searchView.setMaxWidth(Integer.MAX_VALUE);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                adapter.getFilter().filter(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);
                return false;
            }
        });
        super.onCreateOptionsMenu(menu, inflater);
    }

    private List<CustomPhoto> list = new ArrayList<>();
    private ListView listViewItem;
    private  PhotoCustomListView adapter;
    private DatabaseHelper databaseHelper ;
    private SearchView searchView;

}