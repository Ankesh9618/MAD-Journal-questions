package com.example.numberarithmetic;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText e1, e2;
    Button add, sub, div, mul;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        e1 = (EditText) findViewById(R.id.editTextText);
        e2 = (EditText) findViewById(R.id.editTextText2);

        add = (Button) findViewById(R.id.button);
        sub = (Button) findViewById(R.id.button2);
        div = (Button) findViewById(R.id.button4);
        mul = (Button) findViewById(R.id.button3);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float x = Float.parseFloat(String.valueOf(e1));
                float y = Float.parseFloat(String.valueOf(e2));

                Toast.makeText(MainActivity.this, String.valueOf(x+y), Toast.LENGTH_SHORT).show();
            }
        });

        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float x = Float.parseFloat(String.valueOf(e1));
                float y = Float.parseFloat(String.valueOf(e2));

                Toast.makeText(MainActivity.this, String.valueOf(x-y), Toast.LENGTH_SHORT).show();
            }
        });

        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float x = Float.parseFloat(String.valueOf(e1));
                float y = Float.parseFloat(String.valueOf(e2));

                if(y!=0) {
                    Toast.makeText(MainActivity.this, String.valueOf(x / y), Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this, "Cannot divide by ZERO", Toast.LENGTH_SHORT).show();
                }
            }
        });

        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float x = Float.parseFloat(String.valueOf(e1));
                float y = Float.parseFloat(String.valueOf(e2));

                Toast.makeText(MainActivity.this, String.valueOf(x*y), Toast.LENGTH_SHORT).show();
            }
        });
    }
}