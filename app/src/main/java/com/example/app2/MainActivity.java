package com.example.app2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText sum;
    private EditText sum1;
    private EditText sum2;
    private Button btn;
    private TextView result;
    public static String KEY = "key";
    int resultCalculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupUi();
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }

    public void setupUi() {
        btn = findViewById(R.id.btn1);
        sum = findViewById(R.id.etText);
        sum1 = findViewById(R.id.etText1);
        sum2 = findViewById(R.id.etText2);
        result = findViewById(R.id.text2);
        KEY = "key";

        btn.setOnClickListener(v -> {
            if (TextUtils.isEmpty(sum.getText().toString()) &&
                    TextUtils.isEmpty(sum1.getText().toString()) &&
                    TextUtils.isEmpty(sum2.getText().toString())) {
                Toast.makeText(this, "Неправильно ввели данные", Toast.LENGTH_SHORT).show();
            } else {
                int int1 = Integer.parseInt(sum.getText().toString());
                int int2 = Integer.parseInt(sum1.getText().toString());
                int int3 = Integer.parseInt(sum2.getText().toString());
                resultCalculate = (int1 + int2 + int3);
                result.setText(Integer.toString(resultCalculate));
            }
        });
    }
    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(KEY, result.getText().toString());
    }
    @Override
    protected void onRestoreInstanceState(@NonNull Bundle saveInstanceState) {
        super.onRestoreInstanceState(saveInstanceState);
        String tx = saveInstanceState.getString(KEY);

        result.setText(tx);
    }

}