package com.example.myapplication;

import static android.content.ContentValues.TAG;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class ex4Activity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);//will hide the title not the title bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);//int flag, int mask
        setContentView(R.layout.ex4);

        randomAndCheckPrime();
    }

    private void randomAndCheckPrime() {
        Random random = new Random();
        int[] numbers = new int[10];

        // Sinh mảng 10 số ngẫu nhiên
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = random.nextInt(100) + 1; // Sinh số ngẫu nhiên từ 1 đến 100
        }

        // Kiểm tra từng số xem có phải là số nguyên tố không
        for (int number : numbers) {
            boolean isPrime = checkPrime(number);
            Log.d(TAG, "Số: " + number + " là số nguyên tố: " + isPrime);
        }
    }

    // Hàm kiểm tra số nguyên tố
    private boolean checkPrime(int number) {
        if (number <= 1) {
            return false; // Các số <= 1 không phải là số nguyên tố
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false; // Nếu chia hết cho i thì không phải là số nguyên tố
            }
        }
        return true; // Số nguyên tố
    }
}
