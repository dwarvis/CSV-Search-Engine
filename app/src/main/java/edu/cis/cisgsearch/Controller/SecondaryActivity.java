package edu.cis.cisgsearch.Controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import edu.cis.cisgsearch.Model.GoogleSearch.TARestProfile;
import edu.cis.cisgsearch.Model.GoogleSearch.Util;
import edu.cis.cisgsearch.Model.Visualization.VizBinarySearchTree;
import edu.cis.cisgsearch.Model.Visualization.VizTreeNode;
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

        VizBinarySearchTree tree = treeView.load(Util.readCSV(getBaseContext()));


        if (type.equals("search"))
        {
            VizTreeNode tempNode = tree.searchPub(BinaryTreeView.toASCII(nameFromOtherView));
            if (tempNode != null)
            {
                displayText = tempNode.getProf().getName();
            }
            else
            {
                displayText = "Couldn't find restaurant name.";
            }
        }

        if (type.equals("find"))
        {
            TARestProfile temp = tree.find(BinaryTreeView.toASCII(nameFromOtherView));
            if (temp != null)
            {
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
        Intent intent = new Intent(getBaseContext(), SecActivity.class);
        startActivity(intent);
    }
}
