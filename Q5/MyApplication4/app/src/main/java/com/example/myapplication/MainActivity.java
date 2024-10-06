package com.example.myapplication;

import android.os.Bundle;
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
    EditText e1, e2;
    Button b;
    TextView t;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        e1 = (EditText) findViewById(R.id.e1);
        e2 = (EditText) findViewById(R.id.e2);
        b = (Button) findViewById(R.id.button);
        t = (TextView) findViewById(R.id.t2);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double n1 = Double.parseDouble(e1.getText().toString());
                double n2 = Double.parseDouble(e2.getText().toString());

                t.setText(String.valueOf(n1+n2));
            }
        });
    }
}