package com.example.bd_app;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.bd_app.db.MyDataBase;
import com.example.bd_app.db.MyDbManeger;

public class MainActivity extends AppCompatActivity {
    private MyDbManeger myDbManeger;
    private EditText edTitle,edComment;
    private TextView tvText;
    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myDbManeger = new MyDbManeger(this);
        edTitle = findViewById(R.id.edTitle);
        edComment = findViewById(R.id.edComment);
        tvText = findViewById(R.id.tvText);
    }

    @Override
    protected void onResume() {
        super.onResume();
        myDbManeger.openDb();
        for (String title:myDbManeger.getFromDb()){
            tvText.append(title+"\n");
        }
    }

    public void onClickSave(View view){
        myDbManeger.insertToDb(edTitle.getText().toString(),edComment.getText().toString());
        for (String title:myDbManeger.getFromDb()){
            tvText.append(title+"\n");
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        myDbManeger.closeDb();
    }
}