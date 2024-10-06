package com.example.sql_example;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ViewAllDataActivity extends AppCompatActivity {

    DatabaseHelper myDb;
    TextView textViewData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_all_data);

        // Initialize DatabaseHelper
        myDb = new DatabaseHelper(this);

        // Link the XML elements to Java code
        textViewData = findViewById(R.id.textViewData);

        // Retrieve and display all data from the database
        viewAllData();
    }

    private void viewAllData() {
        Cursor res = myDb.getAllData();

        if (res.getCount() == 0) {
            // Show message if no data is found
            Toast.makeText(ViewAllDataActivity.this, "No Data Found", Toast.LENGTH_SHORT).show();
            textViewData.setText("");
            return;
        }

        // Build the data string
        StringBuilder data = new StringBuilder();
        while (res.moveToNext()) {
            data.append("ID: ").append(res.getInt(0)).append("\n");
            data.append("Name: ").append(res.getString(1)).append("\n");
            data.append("Age: ").append(res.getInt(2)).append("\n\n");
        }

        // Display data in TextView
        textViewData.setText(data.toString());
    }
}
