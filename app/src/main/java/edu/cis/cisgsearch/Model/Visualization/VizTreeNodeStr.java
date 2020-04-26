package edu.cis.cisgsearch.Model.Visualization;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import edu.cis.cisgsearch.Model.GoogleSearch.TARestProfile;
import edu.cis.cisgsearch.Model.TConst;

public class VizTreeNodeStr
{
    private String value;
    private int height;
    protected VizTreeNodeStr left, right;
    private boolean showValue;
    private int x, y;
    private TARestProfile prof;

    public VizTreeNodeStr(String value, TARestProfile info)
    {
        this.value = value;
        this.height = 0;
        showValue = false;
        left = null;
        right = null;
        prof = info;
    }


    public VizTreeNodeStr insert(VizTreeNodeStr node, String valueToInsert, TARestProfile info)
    {
        /**
         **
         **  TODO 2 : Use recursion to insert the value.
         **
         **/

        VizTreeNodeStr temp = new VizTreeNodeStr(valueToInsert, info);

        if (aSmallerThanB(valueToInsert, node.getValue())) //smaller
        {
            //termination condition and recursion
            node.left = (node.left == null) ? temp : insert(node.left, valueToInsert, info);
        }
        else if (aLargerThanB(valueToInsert, node.getValue())) //larger
        {
            node.right = (node.right == null) ? temp : insert(node.right, valueToInsert, info);
        }
        else //equal
        {
            //do nothing
        }



        /**
         **
         **  TODO 7: Find and update the height for this node. It should be one greater than the
         *           max between the heights of its left and right nodes.
         **
         **/
        node.height = max(getHeight(node.left), getHeight(node.right)) + 1;



        /**
         **
         **  TODO 8: Find the balance of this node and store it in a variable.
         **
         **/
        int balance = getHeight(node.left) - getHeight(node.right);

        /**
         **
         **  TODO 9: Rebalance the tree depending on the balance found and valueToInsert.
         *            //Look at writeup
         **
         **/
        if (balance > 1 && aSmallerThanB(valueToInsert, node.left.getValue()))
        {
            return rightRotate(node);
        }
        if (balance < -1 && aLargerThanB(valueToInsert, node.right.getValue()))
        {
            return leftRotate(node);
        }
        if (balance > 1 && aLargerThanB(valueToInsert, node.left.getValue()))
        {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }
        if (balance < -1 && aSmallerThanB(valueToInsert, node.right.getValue()))
        {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }


        //If no cases match imbalance, then just return the original node.
        return node;
    }

    private boolean aLargerThanB(String a, String b)
    {
        //a character is larger than another character if its closer to the start of the alphabet
        //eg. a > b, aa > ab, lagos > stevejobs
        if (a.compareTo(b) > 0)
        {
            return true;
        }
        return false;
    }

    private boolean aSmallerThanB(String a, String b)
    {
        if (a.compareTo(b) < 0)
        {
            return true;
        }
        return false;
    }

    // A utility function to right rotate subtree rooted with y
    // See the diagram given above.
    VizTreeNodeStr rightRotate(VizTreeNodeStr y)
    {
        VizTreeNodeStr x = y.left;
        VizTreeNodeStr T2 = x.right;

        // Perform rotation
        x.right = y;
        y.left = T2;

        // Update heights
        y.height = max(getHeight(y.left), getHeight(y.right)) + 1;
        x.height = max(getHeight(x.left), getHeight(x.right)) + 1;

        // Return new root
        return x;
    }

    // A utility function to left rotate subtree rooted with x
    VizTreeNodeStr leftRotate(VizTreeNodeStr x)
    {
        VizTreeNodeStr y = x.right;
        VizTreeNodeStr T2 = y.left;

        // Perform rotation
        y.left = x;
        x.right = T2;

        //  Update heights
        x.height = max(getHeight(x.left), getHeight(x.right)) + 1;
        y.height = max(getHeight(y.left), getHeight(y.right)) + 1;

        // Return new root
        return y;
    }


    /**
     **
     **  TODO 4: Complete helper to Return the max of two values, returns left value if equal.
     **
     **/
    private int max (int left, int right)
    {
        if (left >= right)
        {
            return left;
        }
        return right;
    }

    /**
     **
     **  TODO 5: Helper to return the height of a node, return 0 if null.
     **
     **/
    private int getHeight(VizTreeNodeStr node)
    {
        if (node == null)
        {
            return 0;
        }
        if (node.left == null && node.right == null)
        {
            return 1;
        }
        return node.height;
    }

    /**
     **
     **  TODO 6: Method that returns the difference between the node's children's height.
     *           Return 0 if nodes are null.
     **
     **/
    private int getBalance(VizTreeNodeStr node)
    {
        if (node.right == null || node.left == null)
        {
            return 0;
        }
        int h1 = getHeight(node.right);
        int h2 = getHeight(node.left);
        return (h1 > h2) ? h1-h2 : h2-h1;
    }

    public String getValue()
    {
        return value;
    }

    public TARestProfile getProf()
    {
        return prof;
    }
}
