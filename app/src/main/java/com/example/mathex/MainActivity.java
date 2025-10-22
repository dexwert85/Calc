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
    private TextView tvCor, tvNCor, tvN1, tvN2, tvGrade;
    private EditText etAnswer;
    private int x, y;
    private int cor, ncor, grade;
    private boolean[] b;
    private int streak1, streak2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mulBtn = findViewById(R.id.multiply);
        tvGrade = findViewById(R.id.grade);
        t20Btn = findViewById(R.id.t20);
        testBtn = findViewById(R.id.test);
        checkBtn = findViewById(R.id.check);
        tvCor = findViewById(R.id.cor);
        tvNCor = findViewById(R.id.ncor);
        tvN1 = findViewById(R.id.num1);
        tvN2 = findViewById(R.id.num2);
        etAnswer = findViewById(R.id.answer);
        b = new boolean[3];
        streak1 = 0;
        streak2 = 0;

        mulBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                x = (int)(Math.random() * 9) + 1;
                y = (int)(Math.random() * 9) + 1;

                b[0] = true;
                b[1] = false;
                b[2] = false;

                tvN1.setText(x + "");
                tvN2.setText(y + "");
            }
        });

        t20Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (streak1 >= 10) {
                    x = (int) (Math.random() * 19) + 1;
                    y = (int) (Math.random() * 19) + 1;

                    b[0] = false;
                    b[1] = true;
                    b[2] = false;

                    tvN1.setText(x + "");
                    tvN2.setText(y + "");
                }
            }
        });

        testBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (streak2 >= 10) {
                    x = (int) (Math.random() * 99) + 1;
                    y = (int) (Math.random() * 99) + 1;

                    b[0] = false;
                    b[1] = false;
                    b[2] = true;

                    tvN1.setText(x + "");
                    tvN2.setText(y + "");
                }
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
                    if (b[0]) {
                        grade += 2;
                        streak1++;
                    } else if (b[1]) {
                        grade += 5;
                        streak2++;
                    } else {
                        grade += 10;
                    }

                    tvGrade.setText(grade + "");
                }

                if (rightAnswer != answer) {
                    cor = 0;
                    tvCor.setText(cor + "");
                    Toast.makeText(MainActivity.this, "Wrong", Toast.LENGTH_SHORT).show();
                    ncor++;
                    tvNCor.setText(ncor + "");
                    streak1 = 0;
                    streak2 = 0;
                }

                if (grade >= 100) {
                    finish();
                    System.exit(0);
                }
            }
        });
    }
}