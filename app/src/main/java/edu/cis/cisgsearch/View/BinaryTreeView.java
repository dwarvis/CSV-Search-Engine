package edu.cis.cisgsearch.View;

import android.content.Context;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;

import edu.cis.cisgsearch.Model.GoogleSearch.TARestProfile;
import edu.cis.cisgsearch.Model.TConst;
import edu.cis.cisgsearch.Model.Visualization.VizBinarySearchTree;
import edu.cis.cisgsearch.Model.Visualization.VizBinarySearchTreeStr;

public class BinaryTreeView extends View
{


    private VizBinarySearchTree tree = null;
    private VizBinarySearchTreeStr treeStr = null;
    private ArrayList<Double> searchSequence = null;
    private int searchPosition;
    private TextView textView;

    public BinaryTreeView(Context context, TextView textView)
    {
        super(context);
        this.textView = textView;
    }

    public void initialize()
    {
        tree = new VizBinarySearchTree();
        for (double value : generateRandomSequence(TConst.TREE_SIZE))
        {
            tree.insert(value, null);
        }
        tree.positionNodes(this.getWidth());
        searchSequence = generateRandomSequence(TConst.TREE_SIZE);
        searchPosition = 0;
        updateMessage();
        invalidate();
    }

    public VizBinarySearchTreeStr load(ArrayList<TARestProfile> TARPList)
    {
        treeStr = new VizBinarySearchTreeStr();
        ArrayList<String> temp = new ArrayList<>();
        for (TARestProfile t : TARPList)
        {
            String name = t.getName();
            temp.add(name);
            treeStr.insert(name, t);
        }
//        searchSequence = temp;
        searchPosition = 0;
        return treeStr;
    }

    public VizBinarySearchTreeStr loadBest(ArrayList<TARestProfile> TARPList)
    {
        //this load loads in only the top 10 best restaurants
        treeStr = new VizBinarySearchTreeStr();
        ArrayList<String> temp = new ArrayList<>();
        for (TARestProfile t : TARPList)
        {
            if (Integer.parseInt(t.getRanking()) <= 10)
            {
                String name = t.getName();
                temp.add(name);
                treeStr.insert(name, t);
            }
        }
//        searchSequence = temp;
        searchPosition = 0;
        return treeStr;
    }

    public ArrayList<String> loadCusine(ArrayList<TARestProfile> TARPList, String cuisine)
    {
        //this load loads in only a certain cuisine
        ArrayList<String> temp = new ArrayList<>();
        for (TARestProfile t : TARPList)
        {
            if (t.getCustyle().contains(cuisine))
            {
                String name = t.getName();
                temp.add(name);
            }
        }
        return temp;
    }

    private ArrayList<Double> generateRandomSequence(int size)
    {
        ArrayList<Double> numbers = new ArrayList<>(size);
        for (double i = 0 ; i < size; i++)
        {
            numbers.add(i+1);
        }
        Collections.shuffle(numbers);
        System.out.println(numbers.toString());
        return numbers;
    }

    @Override
    public void onDraw(Canvas canvas)
    {
        if (tree != null)
        {
            tree.draw(canvas);
        }
    }

    private void updateMessage()
    {
        if (searchPosition < searchSequence.size())
            textView.setText("Looking for node " + searchSequence.get(searchPosition));
        else
            textView.setText("Done!");
    }

    //http://easyonlineconverter.com/codes/java_codes/convert-strin-to-ASCII-value-in-java.html
    public static double toASCII (String s)
    {
        String temp = "";
        int nameLength = s.length();
        for(int i = 0; i < nameLength ; i++){
            char character = s.charAt(i);
            int ascii = (int) character;
            temp = temp + ascii;
        }
        return Double.parseDouble(temp);
    }

    /**
     **
     **   Remove any hitValues from the search sequence so that they
     *    won't appear twice.
     **
     **/
    public boolean onTouchEvent(MotionEvent event)
    {
        if (tree != null && searchPosition < searchSequence.size())
        {
            switch(event.getAction())
            {
                case MotionEvent.ACTION_DOWN:
                    double targetValue = searchSequence.get(searchPosition);
                    int hitValue = tree.click(event.getX(), event.getY(), targetValue);
                    if (hitValue != -1)
                    {
                        invalidate();
                        if (hitValue != targetValue)
                        {
                            tree.invalidateNode(targetValue);
                        }
                        searchPosition++;
                        updateMessage();
                        return true;
                    }
            }
        }
        return super.onTouchEvent(event);
    }
}
