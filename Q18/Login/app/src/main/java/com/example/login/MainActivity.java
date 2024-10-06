package com.example.login;

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
    static final String username = "mca";
    static final String password = "android";

    EditText u,p;
    Button s;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        u = (EditText) findViewById(R.id.editTextText);
        p = (EditText) findViewById(R.id.editTextText2);
        
        s = (Button) findViewById(R.id.button);
        
        s.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = u.getText().toString();
                String pass = p.getText().toString();
                
                if(username.equals(user) && password.equals(pass)){
                    Toast.makeText(MainActivity.this, "Username and Password is correct. \nWelcome!!!", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this, "Username or Password is incorrect. \nPlease try again!!", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}