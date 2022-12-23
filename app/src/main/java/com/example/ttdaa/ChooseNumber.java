package com.example.ttdaa;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;

public class ChooseNumber extends Activity {
    public static int cauhoi;
    EditText socauhoi;
    Button bt;
    Button tieptheo;
//    MediaPlayer MP;
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choose_number_question);
        final MediaPlayer MP = MediaPlayer.create(this,R.raw.buttonsound);

        bt = (Button) findViewById(R.id.BtnBack);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                MP.start();
                Intent intent = new Intent(ChooseNumber.this, MainActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.enter2,R.anim.exit2);
            }
        });
        socauhoi = (EditText) findViewById(R.id.Edtsocau);
        tieptheo=(Button)findViewById(R.id.BtnNext);
        socauhoi.addTextChangedListener(numberTextWathcer);
        tieptheo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                MP.start();
                cauhoi = Integer.parseInt(socauhoi.getText().toString());

                if (cauhoi < 5 || cauhoi >10 ) {
                    socauhoi.setError("Please enter 5 to 8 only!");
                    socauhoi.requestFocus();
                    return;
                }

                else {
                    Intent intent = new Intent(ChooseNumber.this, Quenstion_de.class);
                    intent.putExtra("socauhoi",cauhoi);
                    startActivity(intent);
                    overridePendingTransition(R.anim.enter,R.anim.exit);
                    finish();
                }
            }
        });
    }
    private TextWatcher numberTextWathcer = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            String socauhoiInput = socauhoi.getText().toString().trim();
            tieptheo.setEnabled(!socauhoiInput.isEmpty());
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };

    @Override
    public void onBackPressed() {
        finish();
        Intent intent = new Intent(ChooseNumber.this, MainActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.enter2,R.anim.exit2);
    }
}
