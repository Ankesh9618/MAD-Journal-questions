package com.example.list_view_array_adapter;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private final String []fruits = {"Apple", "Orange","Banana", "Pineapple","Guvava"};
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.list);

        ArrayAdapter<String> adapt = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, fruits);

        listView.setAdapter(adapt);


    }
}