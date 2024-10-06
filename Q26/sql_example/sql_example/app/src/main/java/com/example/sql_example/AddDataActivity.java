package com.example.sql_example;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AddDataActivity extends AppCompatActivity {

    DatabaseHelper myDb;
    EditText editName, editAge;
    Button btnAddData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_data);

        // Initialize DatabaseHelper
        myDb = new DatabaseHelper(this);

        // Link the XML elements to Java code
        editName = findViewById(R.id.editTextName);
        editAge = findViewById(R.id.editTextAge);
        btnAddData = findViewById(R.id.buttonAdd);

        // Set onClick listener for the Add Data button
        btnAddData.setOnClickListener(v -> {
            String name = editName.getText().toString();
            String ageText = editAge.getText().toString();

            // Ensure the age is entered and is a valid integer
            if (name.isEmpty() || ageText.isEmpty()) {
                Toast.makeText(AddDataActivity.this, "Please enter all fields", Toast.LENGTH_SHORT).show();
            } else {
                int age = Integer.parseInt(ageText);
                boolean isInserted = myDb.insertData(name, age);

                // Display message based on the result
                if (isInserted) {
                    Toast.makeText(AddDataActivity.this, "Data Inserted", Toast.LENGTH_SHORT).show();
                    // Clear the input fields
                    editName.setText("");
                    editAge.setText("");
                } else {
                    Toast.makeText(AddDataActivity.this, "Insertion Failed", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
