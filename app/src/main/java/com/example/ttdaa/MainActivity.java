package com.example.ttdaa;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;


public class MainActivity extends Activity {

    Button BT1, BT2, BT3, btnBack;
    ImageButton btnbacksong,btnplaysong,btnpausesong,btnnextsong,btnstopsong;
    TextView txtTittle;
    int pos = 0 ;   // position (vị trí thứ tự của nhạc)
    MediaPlayer mediaPlayer;
    MediaPlayer MP;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final MediaPlayer MP = MediaPlayer.create(this,R.raw.buttonsound);

        BT1 = (Button) findViewById(R.id.BtnPlay);
        BT2 = (Button) findViewById(R.id.BtnTutorial);
        BT3 = (Button) findViewById(R.id.BtnBack);

        btnplaysong = (ImageButton) findViewById(R.id.imgbtnPlay);
        btnstopsong=(ImageButton) findViewById(R.id.imgbtnStop);
        mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.ale);
        mediaPlayer.start();
        mediaPlayer.setLooping(true);


        btnplaysong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mediaPlayer.isPlaying()){
                    // nếu đang chạy > click vào thì pause > button thành play
                    mediaPlayer.pause();
                    btnplaysong.setImageResource(R.drawable.play);
                } else {
                    mediaPlayer.start();
                    btnplaysong.setImageResource(R.drawable.pause);
                }
            }
        });
        btnstopsong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.reset();
                mediaPlayer.stop();
                btnplaysong.setImageResource(R.drawable.play);
            }
        });

        BT1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MP.start();
                //Sử dụng Intent để mở activity chon cau hoi
                Intent intent = new Intent(MainActivity.this, choingay_next.class);
                startActivity(intent);
            }
        });
        BT2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MP.start();
                Intent intent = new Intent(MainActivity.this, com.example.ttdaa.huongdan.class);
                startActivity(intent);

            }
        });
        BT3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MP.start();

                mediaPlayer.reset();
                mediaPlayer.stop();
            }
        });
    }

}