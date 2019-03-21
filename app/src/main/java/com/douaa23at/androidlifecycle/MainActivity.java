package com.douaa23at.androidlifecycle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private static final String CURENT_POSITION = "CURRENT POSITION";
    private Button newItem;
    private TextView item;
    private String [] listOfItems = {"JAVA","C","C++","Python","COBOL","PHP","C#","HTML"};
    private int currentPosition = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        newItem = findViewById(R.id.newItem);
        item = findViewById(R.id.randomItem);
        item.setText(listOfItems[currentPosition]);
        newItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                item.setText(newItem());
            }
        });
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(CURENT_POSITION,currentPosition);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        currentPosition = savedInstanceState.getInt(CURENT_POSITION);
        item.setText(listOfItems[currentPosition]);
    }

    private String newItem(){
        currentPosition = new Random().nextInt(6);
        return listOfItems[currentPosition];
    }

}
