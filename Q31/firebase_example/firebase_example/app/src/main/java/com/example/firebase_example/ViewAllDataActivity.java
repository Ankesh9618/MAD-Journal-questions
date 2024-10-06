package com.example.firebase_example;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

public class ViewAllDataActivity extends AppCompatActivity {

    TextView textViewData;
    FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_all_data);

        db = FirebaseFirestore.getInstance();

        textViewData = findViewById(R.id.textViewData);

        viewAllData();
    }

    private void viewAllData() {
        db.collection("users")
                .get()
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        StringBuilder data = new StringBuilder();
                        QuerySnapshot documents = task.getResult();
                        for (DocumentSnapshot document : documents) {
                            data.append("ID: ").append(document.getId()).append("\n");
                            data.append("Name: ").append(document.getString("name")).append("\n");
                            data.append("Age: ").append(document.getLong("age")).append("\n\n");
                        }
                        textViewData.setText(data.toString());
                    } else {
                        Toast.makeText(ViewAllDataActivity.this, "Failed to load data", Toast.LENGTH_SHORT).show();
                    }
                });
    }
}
