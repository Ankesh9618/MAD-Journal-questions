package com.example.sql_example;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class DeleteDataActivity extends AppCompatActivity {

    DatabaseHelper myDb;
    EditText editId;
    Button btnDeleteData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_data);

        // Initialize DatabaseHelper
        myDb = new DatabaseHelper(this);

        // Link the XML elements to Java code
        editId = findViewById(R.id.editTextId);
        btnDeleteData = findViewById(R.id.buttonDelete);

        // Set onClick listener for the Delete Data button
        btnDeleteData.setOnClickListener(v -> {
            String idText = editId.getText().toString();

            // Ensure the ID field is filled
            if (idText.isEmpty()) {
                Toast.makeText(DeleteDataActivity.this, "Please enter the ID", Toast.LENGTH_SHORT).show();
            } else {
                int id = Integer.parseInt(idText);
                Integer deletedRows = myDb.deleteData(id);

                // Display message based on the result
                if (deletedRows > 0) {
                    Toast.makeText(DeleteDataActivity.this, "Data Deleted", Toast.LENGTH_SHORT).show();
                    // Clear the input field
                    editId.setText("");
                } else {
                    Toast.makeText(DeleteDataActivity.this, "Deletion Failed", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
