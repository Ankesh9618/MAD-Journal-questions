package com.example.maxnumber;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {
    EditText e1,e2,e3;
    Button b;
    TextView t;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        e1 = (EditText) findViewById(R.id.e1);
        e2 = (EditText) findViewById(R.id.e2);
        e3 = (EditText) findViewById(R.id.e3);

        t = (TextView) findViewById(R.id.t);

        b = (Button) findViewById(R.id.b);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int x,y,z;
                if(e1.getText().toString().isEmpty() && e2.getText().toString().isEmpty() &&e3.getText().toString().isEmpty()){
                    t.setText("No number was entered");
                }

                x = Integer.parseInt(e1.getText().toString());
                y = Integer.parseInt(e2.getText().toString());
                z = Integer.parseInt(e3.getText().toString());

                try{
                    if(x>=y && x>=z){
                        t.setText(String.valueOf(x));
                    }else if(y>=x && y>=z){
                        t.setText(String.valueOf(y));
                    } else if (z>=x && z>=y) {
                        t.setText(String.valueOf(z));
                    }
                }catch(Exception e){
                    System.out.println(e);
                }

            }
        });

    }
}