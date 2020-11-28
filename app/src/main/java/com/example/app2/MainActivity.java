package com.example.app2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

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
    private TextView textView;
    public static String KEY = "key";
    int result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupUi();
    }

    public void setupUi() {
        btn = findViewById(R.id.btn1);
        sum = findViewById(R.id.etText);
        sum1 = findViewById(R.id.etText1);
        sum2 = findViewById(R.id.etText2);
        textView = findViewById(R.id.text1);

        btn.setOnClickListener(v -> {
            if (TextUtils.isEmpty(sum.getText().toString()) &&
                    TextUtils.isEmpty(sum1.getText().toString()) &&
                    TextUtils.isEmpty(sum2.getText().toString())) {
                Toast.makeText(this, "Неправильно ввели данные", Toast.LENGTH_SHORT).show();
            } else {
                int int1 = Integer.parseInt(sum.getText().toString());
                int int2 = Integer.parseInt(sum1.getText().toString());
                int int3 = Integer.parseInt(sum2.getText().toString());
                result = (int1 + int2 + int3);
            }
        });
    }
    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(KEY, String.valueOf(result ++));
    }
    @Override
    protected void onRestoreInstanceState(@NonNull Bundle saveInstanceState) {
        super.onRestoreInstanceState(saveInstanceState);
        String tx = saveInstanceState.getString(KEY);
        textView.setText(tx);
    }
}