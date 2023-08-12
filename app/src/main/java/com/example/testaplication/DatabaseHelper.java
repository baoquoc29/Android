package com.example.testaplication;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.testaplication.MyDataBase;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;

    public static final String TABLE_LIST = "InformationManga";
    public static final String NAME_ANIME = "nameManga";
    public static final String TOP_ANIME = "topManga";

    private static final String CREATE_TABLE_LIST = "CREATE TABLE " + TABLE_LIST + "("
            + NAME_ANIME + " TEXT,"
            + TOP_ANIME + " TEXT)";

    public DatabaseHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_LIST);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_LIST);
        onCreate(db);
    }
    public void Insert_Data(String name, String top) {
        SQLiteDatabase db = this.getWritableDatabase();
        String insertQuery = "INSERT INTO " + TABLE_LIST +
                "(" + NAME_ANIME + "," + TOP_ANIME + ")" +
                " VALUES('" + name + "','" + top + "')";
        db.execSQL(insertQuery);
        db.close();
    }
    public Cursor get_data_list(String sql){
        SQLiteDatabase db = getReadableDatabase();
        return db.rawQuery(sql,null);
    }



}
