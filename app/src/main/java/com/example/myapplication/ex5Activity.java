package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ex5Activity extends AppCompatActivity {
    private EditText edtArraySize;
    private Button btnCalculate;
    private TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ex5);

        edtArraySize = findViewById(R.id.edtArraySize);
        btnCalculate = findViewById(R.id.btnCalculate);
        tvResult = findViewById(R.id.tvResult);

        // Xử lý sự kiện khi nhấn Button
        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Lấy số phần tử mảng từ EditText
                String input = edtArraySize.getText().toString();

                // Kiểm tra người dùng có nhập số phần tử hay không
                if (input.isEmpty()) {
                    Toast.makeText(ex5Activity.this, "Vui lòng nhập số phần tử", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Chuyển đổi chuỗi sang số nguyên
                int arraySize = Integer.parseInt(input);
                ArrayList<Integer> numbers = new ArrayList<>();

                // Tạo mảng số nguyên từ 1 đến arraySize
                for (int i = 1; i <= arraySize; i++) {
                    numbers.add(i);
                }

                // Lọc các số chính phương và hiển thị kết quả
                ArrayList<Integer> perfectSquares = getPerfectSquares(numbers);
                StringBuilder result = new StringBuilder("Các số chính phương: ");

                for (int number : perfectSquares) {
                    result.append(number).append(" ");
                }

                // Hiển thị kết quả lên TextView
                tvResult.setText(result.toString());

                // Hiển thị Toast các số chính phương
                Toast.makeText(ex5Activity.this, "Các số chính phương: " + result.toString(), Toast.LENGTH_LONG).show();
            }
        });
    }

    // Hàm kiểm tra và trả về danh sách các số chính phương
    private ArrayList<Integer> getPerfectSquares(ArrayList<Integer> numbers) {
        ArrayList<Integer> perfectSquares = new ArrayList<>();
        for (int number : numbers) {
            if (isPerfectSquare(number)) {
                perfectSquares.add(number);
            }
        }
        return perfectSquares;
    }

    // Hàm kiểm tra số chính phương
    private boolean isPerfectSquare(int num) {
        int sqrt = (int) Math.sqrt(num);
        return sqrt * sqrt == num;
    }
}
