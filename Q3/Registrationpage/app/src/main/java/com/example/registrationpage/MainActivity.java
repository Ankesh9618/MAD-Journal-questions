package com.example.registrationpage;

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

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    EditText f,l,a,m,e;

    Button b;

    TextView o;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        f = (EditText) findViewById(R.id.f);
        l = (EditText) findViewById(R.id.l);
        a = (EditText) findViewById(R.id.a);
        m = (EditText) findViewById(R.id.m);
        e = (EditText) findViewById(R.id.e);

        b = (Button) findViewById(R.id.b);

        o = (TextView) findViewById(R.id.o);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                o.setText(f.getText().toString()+'\n'+l.getText().toString()+'\n'+a.getText().toString()+'\n'+m.getText().toString()+'\n'+e.getText().toString());
            }
        });

    }
}