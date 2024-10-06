package com.example.changetext;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    TextView t;
    Button b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        t = (TextView) findViewById(R.id.t);
        b= (Button) findViewById(R.id.b);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                t.setText("Hello");
            }
        });
    }
}