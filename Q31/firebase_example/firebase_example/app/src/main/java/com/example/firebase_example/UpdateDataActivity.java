package com.example.firebase_example;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.firestore.FirebaseFirestore;

public class UpdateDataActivity extends AppCompatActivity {

    EditText editId, editName, editAge;
    Button btnUpdateData;
    FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_data);

        db = FirebaseFirestore.getInstance();

        editId = findViewById(R.id.editTextId);
        editName = findViewById(R.id.editTextName);
        editAge = findViewById(R.id.editTextAge);
        btnUpdateData = findViewById(R.id.buttonUpdate);

        btnUpdateData.setOnClickListener(v -> {
            String id = editId.getText().toString();
            String name = editName.getText().toString();
            String ageText = editAge.getText().toString();

            if (!id.isEmpty() && !name.isEmpty() && !ageText.isEmpty()) {
                db.collection("users").document(id)
                        .update("name", name, "age", Integer.parseInt(ageText))
                        .addOnSuccessListener(aVoid -> Toast.makeText(UpdateDataActivity.this, "Data Updated", Toast.LENGTH_SHORT).show())
                        .addOnFailureListener(e -> Toast.makeText(UpdateDataActivity.this, "Update Failed", Toast.LENGTH_SHORT).show());
            } else {
                Toast.makeText(UpdateDataActivity.this, "Please enter all fields", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
