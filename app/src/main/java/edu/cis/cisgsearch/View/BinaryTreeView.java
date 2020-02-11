package edu.cis.cisgsearch.View;

import android.content.Context;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;

import edu.cis.cisgsearch.Model.TConst;
import edu.cis.cisgsearch.Model.Visualization.VizBinarySearchTree;

public class BinaryTreeView extends View
{


    private VizBinarySearchTree tree = null;
    private ArrayList<Integer> searchSequence = null;
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
        for (int value : generateRandomSequence(TConst.TREE_SIZE))
        {
            tree.insert(value);
        }
        tree.positionNodes(this.getWidth());
        searchSequence = generateRandomSequence(TConst.TREE_SIZE);
        searchPosition = 0;
        updateMessage();
        invalidate();
    }

    private ArrayList<Integer> generateRandomSequence(int size)
    {
        ArrayList<Integer> numbers = new ArrayList<>(size);
        for (int i = 0 ; i < size; i++)
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
                    int targetValue = searchSequence.get(searchPosition);
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
