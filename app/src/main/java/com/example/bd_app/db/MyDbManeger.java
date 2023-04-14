package com.example.bd_app.db;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.mtp.MtpConstants;

import java.util.ArrayList;
import java.util.List;

public class MyDbManeger {
    private Context context;
    private MyDbHelper MyDbHelper;
    private SQLiteDatabase db;
    // Конструктор
    public MyDbManeger(Context context){
        this.context = context;
        MyDbHelper = new MyDbHelper(context);
    }
    // Открытие базыы данных
    public void openDb(){
        db = MyDbHelper.getWritableDatabase();
    }
    // функция записи в бд
    public void insertToDb(String title , String comment) {
        ContentValues cv = new ContentValues();
        cv.put(MyDataBase.title,title);
        cv.put(MyDataBase.comment,comment);
        db.insert(MyDataBase.table_name,null,cv);
    }
    public List<String> getFromDb(){
        List<String> tempList = new ArrayList<>();
        Cursor cursor = db.query(MyDataBase.table_name,null, null,
                null, null,null,null);
        while (cursor.moveToNext())
        {
            @SuppressLint("Range") String title = cursor.getString(cursor.getColumnIndex(MyDataBase.title));
            tempList.add(title);
        }
        cursor.close();
        return tempList;
    }
    public void closeDb(){
        MyDbHelper.close();
    }
}
