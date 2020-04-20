package edu.cis.cisgsearch.Controller;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import edu.cis.cisgsearch.Model.GoogleSearch.Util;
import edu.cis.cisgsearch.R;
import edu.cis.cisgsearch.View.BinaryTreeView;

public class SecActivity extends AppCompatActivity
{
    EditText nameEditText;
    String nameFromUser;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sec);

        nameEditText = findViewById(R.id.editText2);

        nameFromUser = nameEditText.getText().toString();

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

    }

    public void goBackToMain(View v)
    {
        Intent intent = new Intent(getBaseContext(), MainActivity.class);
        startActivity(intent);
    }

    public void goToDisplayScreen(View v)
    {
        //change this
        Intent intent = new Intent(getBaseContext(), SecondaryActivity.class);
        //send over the results
        //"You create a new activity that lets the user search through the data that you have added to the binary tree."
        intent.putExtra("name", nameFromUser);
        intent.putExtra("type", "search");
        startActivity(intent);
    }

    public void goToDisplayScreenFind(View v)
    {
        //change this
        Intent intent = new Intent(getBaseContext(), SecondaryActivity.class);
        //send over the results
        //"You create a new activity that lets the user search through the data that you have added to the binary tree."
        intent.putExtra("name", nameFromUser);
        intent.putExtra("type", "find");
        startActivity(intent);
    }

}
