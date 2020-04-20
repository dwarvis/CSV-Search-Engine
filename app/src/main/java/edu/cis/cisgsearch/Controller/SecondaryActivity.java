package edu.cis.cisgsearch.Controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import edu.cis.cisgsearch.R;

public class SecondaryActivity extends AppCompatActivity {
    TextView nameTextField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondary);

        nameTextField = findViewById(R.id.resultsTextView);

        String nameFromOtherView = getIntent().getStringExtra("name");
        nameTextField.setText(nameFromOtherView);
    }

    public void goBackToSearch(View v)
    {
        Intent intent = new Intent(getBaseContext(), SecActivity.class);
        startActivity(intent);
    }
}
