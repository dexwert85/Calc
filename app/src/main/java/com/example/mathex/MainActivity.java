package com.example.mathex;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private Button mulBtn, t20Btn, testBtn, checkBtn;
    private TextView tvCor, tvNCor, tvN1, tvN2;
    private EditText etAnswer;
    private int x, y;
    private int cor, ncor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mulBtn = findViewById(R.id.multiply);
        t20Btn = findViewById(R.id.t20);
        testBtn = findViewById(R.id.test);
        checkBtn = findViewById(R.id.check);
        tvCor = findViewById(R.id.cor);
        tvNCor = findViewById(R.id.ncor);
        tvN1 = findViewById(R.id.num1);
        tvN2 = findViewById(R.id.num2);
        etAnswer = findViewById(R.id.answer);

        mulBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                x = (int)(Math.random() * 9) + 1;
                y = (int)(Math.random() * 9) + 1;

                tvN1.setText(x + "");
                tvN2.setText(y + "");
            }
        });

        t20Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                x = (int)(Math.random() * 19) + 1;
                y = (int)(Math.random() * 19) + 1;

                tvN1.setText(x + "");
                tvN2.setText(y + "");
            }
        });

        testBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                x = (int)(Math.random() * 99) + 1;
                y = (int)(Math.random() * 99) + 1;

                tvN1.setText(x + "");
                tvN2.setText(y + "");
            }
        });

        checkBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int rightAnswer = x * y;
                int answer = Integer.parseInt(etAnswer.getText().toString());

                if (rightAnswer == answer) {
                    Toast.makeText(MainActivity.this, "Right", Toast.LENGTH_SHORT).show();
                    cor++;
                    tvCor.setText(cor + "");
                }

                if (rightAnswer != answer) {
                    Toast.makeText(MainActivity.this, "Wrong", Toast.LENGTH_SHORT).show();
                    ncor++;
                    tvNCor.setText(ncor + "");
                }
            }
        });
    }
}