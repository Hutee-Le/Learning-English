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
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Random;

public class Question_kho extends Activity {

    private ColorStateList textColorDefaultRb;
    private ColorStateList textColorDefaultCd;
    private CountDownTimer countDownTimer;
    private static final long START_TIME_IN_MILLIS = 30000;
    private boolean TimerRunning;
    private long timeLeftInMillis = START_TIME_IN_MILLIS;
    TextView textViewCountDown,questionText;
    ImageView iv_player,star1,star2,star3;
    List<StateModel_kho> list;
    EditText test;
    Random r;
    int rightAnswers = 0;
    int number = 4;
    int vt = 0;
    int socaudalam = 0;
    Button butNext,b_Back,b_submit;
    EditText edt;
    TextView textView;
    public int counter= 800;
//    MediaPlayer mediaPlayer;
//    MediaPlayer MP;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        MP = MediaPlayer.create(Question_kho.this, R.raw.buttonsound);
        setContentView(R.layout.kho);
        r = new Random();
        textViewCountDown= (TextView) findViewById(R.id.textViewTime);
        iv_player = (ImageView) findViewById(R.id.iv_player);
        star1 = (ImageView) findViewById(R.id.star1);
        star2 = (ImageView) findViewById(R.id.star2);
        star3 = (ImageView) findViewById(R.id.star3);
        butNext = (Button) findViewById(R.id.BtnNext);
        b_Back = (Button) findViewById(R.id.BtnGameBack);
        edt = (EditText) findViewById(R.id.editText);
        b_submit=(Button) findViewById(R.id.Btnsubmit);
        questionText = (TextView) findViewById((R.id.questionText));
        test = (EditText) findViewById((R.id.editText));
        textColorDefaultCd = textViewCountDown.getTextColors();



        list = new ArrayList<>();
        for(int i = 0; i < new com.example.ttdaa.Database_kho().answers.length; i++){
            list.add(new com.example.ttdaa.StateModel_kho(new com.example.ttdaa.Database_kho().answers[i],new Database_kho().question[i],new com.example.ttdaa.Database_kho().image[i]));
            Collections.shuffle(list);
        }

        timeLeftInMillis=START_TIME_IN_MILLIS;
        for (int i = 0; i< list.size(); i++)
        {
            if(countChar(list.get(i).getQuestion(),number))
            {
                vt = i;
            }
        }
        iv_player.setImageResource(list.get(vt).getImage());
        funcQuestion(list.get(vt).getQuestion());

        countDownTimer = new CountDownTimer(timeLeftInMillis,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timeLeftInMillis=millisUntilFinished;
                updateCountDownText();
            }

            @Override
            public void onFinish() {
                TimerRunning=false;
                Toast.makeText(Question_kho.this,"Wrong",Toast.LENGTH_SHORT).show();
                rightAnswers -=1;
                number -=1;
                if(number < 4)
                {
                    number = 4;
                }
                socaudalam++;
                list.remove(vt);
                for (int i = 0; i< list.size(); i++)
                {
                    if(countChar(list.get(i).getQuestion(),number))
                    {
                        vt = i;
                    }
                }

                if(socaudalam != 10 && rightAnswers != -3){
                    iv_player.setImageResource(list.get(vt).getImage());
                    funcQuestion(list.get(vt).getQuestion());
                    edt.setText("");
                    pauseTimer();
                    resetTimer();
                    startTimer();
                }else {
                    getResults();
                }

            }
        };

        startTimer();


//        mediaPlayer = MediaPlayer.create(Question_kho.this, R.raw.edm);
//        mediaPlayer.start();
//        mediaPlayer.setLooping(false);

        b_Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                MP.start();
                Intent intent = new Intent(Question_kho.this, com.example.ttdaa.choingay_next.class);
                startActivity(intent);
            }
        });

        butNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                MP.start();

                if (edt.getText().toString().equalsIgnoreCase(list.get(vt).getAnswer())) {
                    Toast.makeText(Question_kho.this,"Right",Toast.LENGTH_SHORT).show();
                    rightAnswers += 1;
                    if(number >= 6)
                    {
                        number = 6;
                    }else{
                        number += 1;
                    }

                    if(rightAnswers >= 3 && rightAnswers <6)
                    {
                        checkStar(star1,120,120);
                    }
                    else if(rightAnswers >= 6 && rightAnswers < 9)
                    {
                        checkStar(star1,120,120);
                        checkStar(star2,120,120);
                    }
                    else if(rightAnswers >= 9){
                        checkStar(star3,120,120);

                    }
                    else{
                        checkStar(star1,0,0);
                    }
                    list.remove(vt);
                }else{
                    Toast.makeText(Question_kho.this,"Wrong",Toast.LENGTH_SHORT).show();
                    rightAnswers -=1;
                    number -=1;
                    if(number < 4)
                    {
                        number = 4;
                    }
                    list.remove(vt);
                }
                socaudalam++;

                pauseTimer();
                resetTimer();
                startTimer();


                for (int i = 0; i< list.size(); i++)
                {
                    if(countChar(list.get(i).getQuestion(),number))
                    {
                        vt = i;
                    }
                }

                if( socaudalam != 10 && rightAnswers != -3){
                    iv_player.setImageResource(list.get(vt).getImage());
                    funcQuestion(list.get(vt).getQuestion());
                    edt.setText("");
                }else{
                    getResults();
                }


            }
        });//butNext



    }//onCreate
    private void pauseTimer() {
        countDownTimer.cancel();
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
        int minutes=(int)(timeLeftInMillis/1000)/60;
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

    public void getResults () {
        Intent intent = new Intent(getApplicationContext(), com.example.ttdaa.activity_result.class);
        if(rightAnswers <= 0)
        {
            rightAnswers = 0;
        }

        intent.putExtra("rightAnswers",rightAnswers);
        intent.putExtra("socauhoi",10);
        startActivity(intent);
    }

    public void checkStar (ImageView imageView,int width,int height)
    {
        imageView.getLayoutParams().width = width;
        imageView.getLayoutParams().height = height;
        imageView.requestLayout();
    }

    public void funcQuestion (String str) {
        List<Character> chars = new ArrayList<>();
        for (char ch : str.toCharArray()) {
            chars.add(ch);
        }
        Collections.shuffle(chars);
        for(int i = 0; i < chars.size(); i++)
        {
            if(i%2==1)
            {
                chars.add(i,'/');
            }
        }

        StringBuilder sb = new StringBuilder();
        for (Character ch : chars) {
            sb.append(ch);
        }

        String question = sb.toString();
        questionText.setText(question);
    }

    public boolean countChar(String str,int number)
    {
        List<Character> chars = new ArrayList<>();
        for (char ch : str.toCharArray()) {
            chars.add(ch);
        }
        if(chars.size() == number)
        {
            return true;
        }else{
            return false;
        }
    }



}//Question_kho
