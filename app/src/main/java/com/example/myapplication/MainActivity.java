package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);//will hide the title not the title bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);//int flag, int mask
        setContentView(R.layout.activity_main);

        Button openSecondActivityButton = findViewById(R.id.button);
        openSecondActivityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Khi người dùng nhấn nút, mở SecondActivity
                Intent intent = new Intent(MainActivity.this, ex4Activity.class);
                startActivity(intent);
            }
        });

        Button ex5button = findViewById(R.id.button2);
        ex5button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Khi người dùng nhấn nút, mở SecondActivity
                Intent intent = new Intent(MainActivity.this, ex5Activity.class);
                startActivity(intent);
            }
        });
    }
}