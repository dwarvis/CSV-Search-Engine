package edu.cis.cisgsearch.Controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import edu.cis.cisgsearch.Model.GoogleSearch.TARestProfile;
import edu.cis.cisgsearch.Model.GoogleSearch.Util;
import edu.cis.cisgsearch.R;
import edu.cis.cisgsearch.View.BinaryTreeView;

public class MainActivity extends AppCompatActivity {

    EditText nameTextField;
    String nameFromUser;
    BinaryTreeView treeView = null;
    private ArrayList<TARestProfile> TARPList;

    /**
     * is called when the app is opened,
     * sets the screen orientation to horizontal and sets the layouts
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        setContentView(R.layout.activity_main);
        LinearLayout layout = (LinearLayout) findViewById(R.id.mainLayout);
        nameTextField = findViewById(R.id.editText);


        TextView textView = (TextView) findViewById(R.id.messageView);
        treeView = new BinaryTreeView(this, textView);


        treeView.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT));

        layout.addView(treeView);
    }

    public void goToNextScreen(View v)
    {
        nameFromUser = nameTextField.getText().toString();

        Intent intent = new Intent(getBaseContext(), SecActivity.class);
        intent.putExtra("name", nameFromUser);
        startActivity(intent);
    }

    /**
     * when the start button is pressed
     * @param view the corresponding view
     * @return true
     */
    public boolean onPressStart(View view) {
        treeView.initialize();
        return true;
    }
}
