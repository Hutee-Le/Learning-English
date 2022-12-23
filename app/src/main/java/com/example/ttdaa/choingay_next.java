package com.example.ttdaa;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;


public class choingay_next extends Activity {
    Button BT,BTDe,BTTb,BTKho,BtBack;
//    MediaPlayer mediaPlayer;
//    MediaPlayer MP;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choingay_next);
//        final MediaPlayer Mp = MediaPlayer.create(this,R.raw.buttonsound);
        BTDe = (Button) findViewById(R.id.BtnDe);
        BTKho = (Button) findViewById(R.id.BtnKho);
        BTTb = (Button) findViewById(R.id.BtnTrungBinh);
        BtBack = (Button) findViewById(R.id.BtnBack);

        BTDe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(choingay_next.this, com.example.ttdaa.ChooseNumber.class);
                startActivity(intent);
//                mediaPlayer.reset();
//                mediaPlayer.stop();

            }
        });

        BtBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(choingay_next.this, com.example.ttdaa.MainActivity.class);
                startActivity(intent);
//                MP.start();
//                mediaPlayer.reset();
//                mediaPlayer.stop();
            }
        });


        BTKho.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(choingay_next.this, Question_kho.class);
                startActivity(intent);

//                mediaPlayer.reset();
//                mediaPlayer.stop();
            }
        });
    }

}
