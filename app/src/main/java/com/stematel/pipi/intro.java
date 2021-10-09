package com.stematel.pipi;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class intro extends AppCompatActivity {

    ImageView logo,splashing;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intro);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

        logo = findViewById(R.id.ico_intro);
        splashing = findViewById(R.id.bg_intro);

        splashing.animate().translationY(-3200).setDuration(1000).setStartDelay(2900);
        logo.animate().translationY(1400).setDuration(1000).setStartDelay(2900);

        final Handler handler = new Handler();
        handler.postDelayed(() -> {
            startActivity(new Intent(getApplicationContext(), LoginActivity.class));
            overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            finish();
        }, 4000L); //3000 L = 3 detik

        }
    }

