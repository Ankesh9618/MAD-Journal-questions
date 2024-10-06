package com.example.evenodd;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText e;
    TextView t;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        e = (EditText) findViewById(R.id.e);
        t = (TextView) findViewById(R.id.t);

        e.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                t.setText("Welcome to the app!");
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(Integer.parseInt(e.getText().toString()) % 2 == 0){
                    t.setText("Even");
                }else{
                    t.setText("Odd");
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }
}