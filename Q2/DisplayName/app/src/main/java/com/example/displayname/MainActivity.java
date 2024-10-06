package com.example.displayname;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    EditText e;
    TextView t;
    Button b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        e = (EditText) findViewById(R.id.e);
        t = (TextView) findViewById(R.id.t);
        b = (Button) findViewById(R.id.b);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                t.setText(e.getText().toString());
            }
        });
    }
}