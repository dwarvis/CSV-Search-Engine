package edu.cis.cisgsearch.Controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

import edu.cis.cisgsearch.Model.GoogleSearch.TARestProfile;
import edu.cis.cisgsearch.Model.GoogleSearch.Util;
import edu.cis.cisgsearch.Model.Visualization.VizBinarySearchTree;
import edu.cis.cisgsearch.Model.Visualization.VizBinarySearchTreeStr;
import edu.cis.cisgsearch.Model.Visualization.VizTreeNode;
import edu.cis.cisgsearch.Model.Visualization.VizTreeNodeStr;
import edu.cis.cisgsearch.R;
import edu.cis.cisgsearch.View.BinaryTreeView;

public class SecondaryActivity extends AppCompatActivity {
    TextView nameTextField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        TextView textView = (TextView) findViewById(R.id.messageView);

        BinaryTreeView treeView = new BinaryTreeView(this, textView);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondary);

        nameTextField = findViewById(R.id.resultsTextView);

        String nameFromOtherView = getIntent().getStringExtra("name");

        String displayText = "";

        String type = getIntent().getStringExtra("type");

        ArrayList<TARestProfile> profList = Util.readCSV(getBaseContext());


        if (type.equals("search"))
        {
            ArrayList<String> tree = treeView.loadCusine(profList, nameFromOtherView);
            displayText = tree.toString();

        }
        else if (type.equals("find"))
        {
            VizBinarySearchTreeStr tree = treeView.load(profList);
            VizTreeNodeStr tempNode = tree.searchPub(nameFromOtherView);
            if (tempNode != null)
            {
                TARestProfile temp = tempNode.getProf();
                displayText = temp.getName() + ", " +
                        temp.getCity() + ", " +
                        temp.getCustyle() + ", " +
                        temp.getRanking() + ", " +
                        temp.getRating() + ", " +
                        temp.getpRange() + ", " +
                        temp.getNOR() + ", " +
                        temp.getReviews() + ", " +
                        temp.getUrl() + ", " +
                        temp.getId();
            }
            else
            {
                displayText = "Couldn't find restaurant name.";
            }
        }

        nameTextField.setText(displayText);
    }

    public void goBackToSearch(View v)
    {
        this.finish();
        Intent intent = new Intent(getBaseContext(), SecActivity.class);
        startActivity(intent);
    }
}
