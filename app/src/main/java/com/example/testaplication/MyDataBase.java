package com.example.testaplication;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class MyDataBase extends SQLiteOpenHelper {
    public static final String DATA_NAME = "mydatabase.db";
    public static final String TABLE_NAME = "Account";
    public static final String COLUMN_USERNAME = "username";
    public static final String COLUMN_PASSWORD = "password";
    public static final String COLUMN_GMAIL = "gmail";
    public static final String CREATE_TABLE_QUERY =
            "CREATE TABLE " + TABLE_NAME + " (" +
                    COLUMN_USERNAME + " TEXT PRIMARY KEY, " +
                    COLUMN_PASSWORD + " TEXT NOT NULL, " +
                    COLUMN_GMAIL + " TEXT)";
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
            sqLiteDatabase.execSQL(CREATE_TABLE_QUERY);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public MyDataBase(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }
    public MyDataBase(@Nullable Context context) {
        super(context, DATA_NAME,null,1);
    }
    public void Insert_Data(String username, String password , String gmail){
        SQLiteDatabase db = this.getWritableDatabase();
        String insertQuery = "INSERT INTO " + TABLE_NAME +
                "(" + COLUMN_USERNAME + "," + COLUMN_PASSWORD + "," + COLUMN_GMAIL + ")" +
                " VALUES('" + username + "','" + password + "','" + gmail + "')";
        db.execSQL(insertQuery);
        db.close();
    }
    public Cursor get_data(String sql){
        SQLiteDatabase db = getReadableDatabase();
        return db.rawQuery(sql,null);
    }

}
