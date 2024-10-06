package com.example.bluetooth_control;

import android.Manifest;
import android.annotation.SuppressLint;
import android.bluetooth.BluetoothAdapter;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

public class MainActivity extends AppCompatActivity {
    private static final int REQUEST_BLUETOOTH_PERMISSION = 1;
    Button toggle;
    TextView t1;
    BluetoothAdapter bluetoothAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toggle = findViewById(R.id.button2);
        t1 = findViewById(R.id.textView2);

        bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();

        toggle.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                if (bluetoothAdapter == null) {
                    t1.setText("Bluetooth not supported");
                    return;
                }

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
                    // Android 12+ requires BLUETOOTH_CONNECT permission
                    if (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.BLUETOOTH_CONNECT)
                            != PackageManager.PERMISSION_GRANTED) {
                        ActivityCompat.requestPermissions(MainActivity.this,
                                new String[]{Manifest.permission.BLUETOOTH_CONNECT}, REQUEST_BLUETOOTH_PERMISSION);
                    } else {
                        toggleBluetooth();
                    }
                } else {
                    // For Android versions below 12, we don't need BLUETOOTH_CONNECT permission
                    toggleBluetooth();
                }
            }
        });
    }

    // Toggle Bluetooth state
    private void toggleBluetooth() {
        if (bluetoothAdapter.isEnabled()) {
            bluetoothAdapter.disable();
            t1.setText("Bluetooth is Off");
        } else {
            bluetoothAdapter.enable();
            t1.setText("Bluetooth is On");
        }
    }

    // Handle permission result
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == REQUEST_BLUETOOTH_PERMISSION) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                toggleBluetooth();
            } else {
                t1.setText("Permission denied");
            }
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }
}
