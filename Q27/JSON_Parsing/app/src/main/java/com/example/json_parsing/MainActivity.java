package com.example.json_parsing;


import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    TextView textView;

    // JSON string that we'll parse
    String jsonString = "{\"id\":1, \"name\":\"John\", \"email\":\"john@example.com\"}";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);

        // Parsing the JSON object
        parseJSON();
    }

    private void parseJSON() {
        try {
            // Convert jsonString into a JSONObject
            JSONObject user = new JSONObject(jsonString);

            // Extract data from the object
            int id = user.getInt("id");
            String name = user.getString("name");
            String email = user.getString("email");

            // Format the extracted data
            String formattedData = "ID: " + id + "\nName: " + name + "\nEmail: " + email;

            // Display the parsed data in the TextView
            textView.setText(formattedData);

        } catch (JSONException e) {
            e.printStackTrace();
            textView.setText("Error parsing JSON");
        }
    }
}
