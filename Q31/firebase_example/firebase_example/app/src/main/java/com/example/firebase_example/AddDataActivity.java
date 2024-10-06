package com.example.firebase_example;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class AddDataActivity extends AppCompatActivity {

    EditText editName, editAge;
    Button btnAddData;
    FirebaseFirestore db;
    CollectionReference usersCollection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_data);

        db = FirebaseFirestore.getInstance();
        usersCollection = db.collection("users");

        editName = findViewById(R.id.editTextName);
        editAge = findViewById(R.id.editTextAge);
        btnAddData = findViewById(R.id.buttonAdd);

        btnAddData.setOnClickListener(v -> {
            String name = editName.getText().toString();
            String ageText = editAge.getText().toString();

            if (!name.isEmpty() && !ageText.isEmpty()) {
                Map<String, Object> user = new HashMap<>();
                user.put("name", name);
                user.put("age", Integer.parseInt(ageText));

                usersCollection.add(user)
                        .addOnSuccessListener(documentReference -> {
                            Toast.makeText(AddDataActivity.this, "Data Inserted", Toast.LENGTH_SHORT).show();
                            editName.setText("");
                            editAge.setText("");
                        })
                        .addOnFailureListener(e -> Toast.makeText(AddDataActivity.this, "Insertion Failed", Toast.LENGTH_SHORT).show());
            } else {
                Toast.makeText(AddDataActivity.this, "Please enter all fields", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
