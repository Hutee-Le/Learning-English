package com.example.ttdaa;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class activity_highscore extends AppCompatActivity {
    TextView Txt1;
    int HighScore;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_highscore);
        Txt1 = (TextView)findViewById(R.id.TxtHighscore);
        LoadHighScore();
        Txt1.setText(""+ HighScore);
    }
    void LoadHighScore(){
        SharedPreferences sharedPreferences = getSharedPreferences("MyData", Context.MODE_PRIVATE);
        if (sharedPreferences !=null){
            HighScore = sharedPreferences.getInt("H",0);
        }
    }
}