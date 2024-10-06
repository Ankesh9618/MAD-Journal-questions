package com.example.firebase_example;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.firestore.FirebaseFirestore;

public class DeleteDataActivity extends AppCompatActivity {

    EditText editId;
    Button btnDeleteData;
    FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_data);

        db = FirebaseFirestore.getInstance();

        editId = findViewById(R.id.editTextId);
        btnDeleteData = findViewById(R.id.buttonDelete);

        btnDeleteData.setOnClickListener(v -> {
            String id = editId.getText().toString();

            if (!id.isEmpty()) {
                db.collection("users").document(id)
                        .delete()
                        .addOnSuccessListener(aVoid -> {
                            Toast.makeText(DeleteDataActivity.this, "Data Deleted", Toast.LENGTH_SHORT).show();
                            editId.setText("");
                        })
                        .addOnFailureListener(e -> Toast.makeText(DeleteDataActivity.this, "Deletion Failed", Toast.LENGTH_SHORT).show());
            } else {
                Toast.makeText(DeleteDataActivity.this, "Please enter the ID", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
