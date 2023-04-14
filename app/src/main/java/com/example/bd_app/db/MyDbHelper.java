package com.example.bd_app.db;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;


public class MyDbHelper extends SQLiteOpenHelper {

    public MyDbHelper(@Nullable Context context) {
        super(context, MyDataBase.db_name, null, MyDataBase.db_version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(MyDataBase.table_structure);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int OldVersion, int NewVersion) {
        db.execSQL(MyDataBase.drop_table);
        onCreate(db);
    }
}
