package com.example.phone_call;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    EditText e;
    Button b;
    ActivityResultLauncher<String> requestPermissionLauncher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        e = findViewById(R.id.editTextText);
        b = findViewById(R.id.button);

        // Initialize the permission launcher
        requestPermissionLauncher = registerForActivityResult(
                new ActivityResultContracts.RequestPermission(),
                isGranted -> {
                    if (isGranted) {
                        makePhoneCall();
                    } else {
                        Toast.makeText(this, "Permission Denied", Toast.LENGTH_SHORT).show();
                    }
                }
        );

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkSelfPermission(Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {
                    makePhoneCall();
                } else {
                    // Request permission
                    requestPermissionLauncher.launch(Manifest.permission.CALL_PHONE);
                }
            }
        });
    }

    private void makePhoneCall() {
        String number = e.getText().toString();
        Intent phoneCall = new Intent(Intent.ACTION_CALL);
        phoneCall.setData(Uri.parse("tel:" + number));
        startActivity(phoneCall);
    }
}
