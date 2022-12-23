package com.example.ttdaa;

import android.app.Activity;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Random;


public class Quenstion_de extends  Activity{
    //    private static final long COUNTDOWN_IN_MILLIS = 30000;
    private ColorStateList textColorDefaultRb;
    private ColorStateList textColorDefaultCd;
    private CountDownTimer countDownTimer;
    private long timeLeftInMillis = START_TIME_IN_MILLIS;
    Button b_back,b_submit;
    RadioButton b_answer1, b_answer2,b_answer3,b_answer4;
    ImageButton btnplaysong;
    ImageView iv_player;
    List<com.example.ttdaa.StateModel> list;
    TextView textViewCountDown;
    Random r ;
    int turn = 1;
    int rightAnswers=0;
    private static final long START_TIME_IN_MILLIS = 15000;
    private boolean TimerRunning;
//    MediaPlayer mediaPlayer;
//    MediaPlayer MP;



    protected  void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.de);
        r = new Random();
        iv_player =(ImageView) findViewById(R.id.iv_player);
        textViewCountDown= (TextView) findViewById(R.id.textViewTime);
//        MP = MediaPlayer.create(Quenstion_de.this, R.raw.buttonsound);
        int socauhoi = getIntent().getIntExtra("socauhoi", 0);
        b_answer1 =  findViewById(R.id.RdbA);
        b_answer2 =  findViewById(R.id.RdbB);
        b_answer3 =  findViewById(R.id.RdbC);
        b_answer4 =  findViewById(R.id.RdbD);
        b_back =  findViewById(R.id.BtnGameBack);
        b_submit =  findViewById(R.id.Btnsubmit);
        textColorDefaultCd = textViewCountDown.getTextColors();


        list = new ArrayList<>();

        for(int i = 0; i< new com.example.ttdaa.Database_de().answers.length; i++){
            list.add(new com.example.ttdaa.StateModel(new com.example.ttdaa.Database_de().answers[i],new com.example.ttdaa.Database_de().player[i]));
            Collections.shuffle(list);


        }
        newQuestion(turn);
        timeLeftInMillis=START_TIME_IN_MILLIS;
        countDownTimer = new CountDownTimer(timeLeftInMillis,1500) {
            @Override
            public void onTick(long millisUntilFinished) {
                timeLeftInMillis=millisUntilFinished;
                updateCountDownText();
            }

            @Override
            public void onFinish() {
                TimerRunning=false;
                newQuestion(turn);
                pauseTimer();
                resetTimer();
                startTimer();
            }
        };
        startTimer();

//        mediaPlayer = MediaPlayer.create(Quenstion_de.this, R.raw.ale);
//        mediaPlayer.start();
//        mediaPlayer.setLooping(false);



        b_answer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                MP.start();
                pauseTimer();
                resetTimer();
                startTimer();

                if(b_answer1.getText().toString().equalsIgnoreCase(list.get(turn-1).getName())){
                    rightAnswers = rightAnswers +1;
                    Toast.makeText(Quenstion_de.this,"Đúng",Toast.LENGTH_SHORT).show();
                    turn++;
                    if(turn <= socauhoi){
                        newQuestion(turn);
                    }
                }else{
                    Toast.makeText(Quenstion_de.this,"SAI",Toast.LENGTH_SHORT).show();
                    turn++;
                }
                if(turn <= socauhoi){
                    newQuestion(turn);
                }
                if(turn>socauhoi){
                    b_submit.setVisibility(View.VISIBLE);
//                    mediaPlayer.reset();
//                    mediaPlayer.stop();
                    getResults();
                }
            }
        });
        b_answer2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                MP.start();

                pauseTimer();
                resetTimer();
                startTimer();

                if(b_answer2.getText().toString().equalsIgnoreCase(list.get(turn-1).getName())){
                    rightAnswers = rightAnswers +1;
                    Toast.makeText(Quenstion_de.this,"Đúng",Toast.LENGTH_SHORT).show();
                    turn++;
                    if(turn<=socauhoi){
                        newQuestion(turn);
                    }
                }else{
                    Toast.makeText(Quenstion_de.this,"SAI",Toast.LENGTH_SHORT).show();
                    turn++;
                }
                if(turn<=socauhoi){
                    newQuestion(turn);
                }
                if(turn>socauhoi){
                    b_submit.setVisibility(View.VISIBLE);
//                    mediaPlayer.reset();
//                    mediaPlayer.stop();
                    getResults();
                }
            }
        });
        b_answer3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                MP.start();

                pauseTimer();
                resetTimer();
                startTimer();

                if(b_answer3.getText().toString().equalsIgnoreCase(list.get(turn-1).getName())){
                    rightAnswers = rightAnswers +1;
                    Toast.makeText(Quenstion_de.this,"Đúng",Toast.LENGTH_SHORT).show();
                    turn++;
                    if(turn<=socauhoi){
                        newQuestion(turn);

                    }
                }else{
                    Toast.makeText(Quenstion_de.this,"SAI",Toast.LENGTH_SHORT).show();
                    turn++;
                }
                if(turn<=socauhoi){
                    newQuestion(turn);
                }
                if(turn>socauhoi){
                    b_submit.setVisibility(View.VISIBLE);
//                    mediaPlayer.reset();
//                    mediaPlayer.stop();
                    getResults();
                }
            }
        });
        b_answer4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                MP.start();

                pauseTimer();
                resetTimer();
                startTimer();

                if(b_answer4.getText().toString().equalsIgnoreCase(list.get(turn-1).getName())){
                    rightAnswers = rightAnswers +1;
                    Toast.makeText(Quenstion_de.this,"Đúng",Toast.LENGTH_SHORT).show();
                    turn++;
                    if(turn<=socauhoi){
                        newQuestion(turn);
                    }
                }else{
                    Toast.makeText(Quenstion_de.this,"SAI",Toast.LENGTH_SHORT).show();
                    turn++;
                }
                if(turn<=socauhoi){
                    newQuestion(turn);

                }
                if(turn>socauhoi){
                    b_submit.setVisibility(View.VISIBLE);
//                    mediaPlayer.reset();
//                    mediaPlayer.stop();
                    getResults();
                }
            }
        });
        b_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Quenstion_de.this, com.example.ttdaa.activity_result.class);
                startActivity(intent);
                if(TimerRunning){
                    pauseTimer();
                }
                getResults();
//                MP.start();

//                if(mediaPlayer.isPlaying()){
//                    mediaPlayer.reset();
//                    mediaPlayer.stop();
//                }
            }
        });
        b_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Quenstion_de.this, choingay_next.class);
                startActivity(intent);
//                MP.start();

//                if(mediaPlayer.isPlaying()){
//                    mediaPlayer.reset();
//                    mediaPlayer.stop();
//                }
            }
        });

    }

    private void pauseTimer() {
        countDownTimer.cancel();
        TimerRunning=false;
    }

    private void startTimer() {
        countDownTimer.start();
        TimerRunning= true;
    }

    private void resetTimer() {

        timeLeftInMillis=START_TIME_IN_MILLIS;
        updateCountDownText();

    }

    private void updateCountDownText(){
        int minutes = (int)(timeLeftInMillis/1000)/60;
        int seconds = (int)(timeLeftInMillis/1000)%60;
        String timeFormatted = String.format(Locale.getDefault(),"%02d:%02d",minutes,seconds);
        textViewCountDown.setText(timeFormatted);
        if (timeLeftInMillis<10000){
            textViewCountDown.setTextColor(Color.RED);
        }else{
            textViewCountDown.setTextColor(Color.GREEN);
        }
    }
    @Override
    protected void onDestroy(){
        super.onDestroy();
        if(countDownTimer!=null){
            countDownTimer.cancel();
        }
    }

    private void newQuestion(int number){
        iv_player.setImageResource(list.get(number).getImage());

        int correct_answer = r.nextInt(4)+1;
        int firstButton = number -1;
        int secondButton;
        int thirdButton;
        int fourthButton;



        switch(correct_answer){
            case 1:
                b_answer1.setText(list.get(firstButton).getName());

                do{
                    secondButton = r.nextInt(list.size());
                }while (secondButton == firstButton);
                do{
                    thirdButton = r.nextInt(list.size());
                }while(thirdButton == firstButton || thirdButton == secondButton);
                do {
                    fourthButton = r.nextInt(list.size());
                }while (fourthButton == firstButton || fourthButton == secondButton || fourthButton == thirdButton);
                b_answer2.setText(list.get(secondButton).getName());
                b_answer3.setText(list.get(thirdButton).getName());
                b_answer4.setText(list.get(fourthButton).getName());

                break;
            case 2:
                b_answer2.setText(list.get(firstButton).getName());
                do{
                    secondButton = r.nextInt(list.size());
                }while (secondButton == firstButton);
                do{
                    thirdButton = r.nextInt(list.size());
                }while(thirdButton == firstButton || thirdButton == secondButton);
                do {
                    fourthButton = r.nextInt(list.size());
                }while (fourthButton == firstButton || fourthButton == secondButton || fourthButton == thirdButton);
                b_answer1.setText(list.get(secondButton).getName());
                b_answer3.setText(list.get(thirdButton).getName());
                b_answer4.setText(list.get(fourthButton).getName());
                break;
            case 3:
                b_answer3.setText(list.get(firstButton).getName());
                do{
                    secondButton = r.nextInt(list.size());
                }while (secondButton == firstButton);
                do{
                    thirdButton = r.nextInt(list.size());
                }while(thirdButton == firstButton || thirdButton == secondButton);
                do {
                    fourthButton = r.nextInt(list.size());
                }while (fourthButton == firstButton || fourthButton == secondButton || fourthButton == thirdButton);
                b_answer2.setText(list.get(secondButton).getName());
                b_answer1.setText(list.get(thirdButton).getName());
                b_answer4.setText(list.get(fourthButton).getName());
                break;
            case 4:
                b_answer4.setText(list.get(firstButton).getName());
                do{
                    secondButton = r.nextInt(list.size());
                }while (secondButton == firstButton);
                do{
                    thirdButton = r.nextInt(list.size());
                }while(thirdButton == firstButton || thirdButton == secondButton);
                do {
                    fourthButton = r.nextInt(list.size());
                }while (fourthButton == firstButton || fourthButton == secondButton || fourthButton == thirdButton);
                b_answer2.setText(list.get(secondButton).getName());
                b_answer3.setText(list.get(thirdButton).getName());
                b_answer1.setText(list.get(fourthButton).getName());
                break;
        }
    }



    public void getResults () {
        Intent intent = new Intent(getApplicationContext(), com.example.ttdaa.activity_result.class);
        intent.putExtra("rightAnswers",rightAnswers);
        int socauhoi = getIntent().getIntExtra("socauhoi", 0);
        intent.putExtra("socauhoi",socauhoi);
        startActivity(intent);
    }
}

