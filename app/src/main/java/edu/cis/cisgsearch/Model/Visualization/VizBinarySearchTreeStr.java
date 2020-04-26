package edu.cis.cisgsearch.Model.Visualization;

import android.graphics.Canvas;

import java.util.ArrayList;

import edu.cis.cisgsearch.Model.GoogleSearch.TARestProfile;

public class VizBinarySearchTreeStr
{
    private VizTreeNodeStr root = null;
    public VizBinarySearchTreeStr()
    {
    }

    public void insert(String value, TARestProfile info)
    {
        /**
         **
         **  TODO 1 : Check if binary tree is empty, if not call VizTreeNode's insert()
         **            //method and pass in the root and the value. Set root to the Node returned.
         **           // If empty, just set the root to be a new VizTreeNode.
         **
         **/
        if (root == null)
        {
            root = new VizTreeNodeStr(value, info);
        }
        if (root != null)
        {
            root = root.insert(root, value, info);
        }
    }

    private VizTreeNodeStr search(String value)
    {

        /**
         **
         **  TODO 3: Search through the tree for the value. Return the Node with the correct value.
         **           //complete the searchHelper function and use it here.
         **           //Once you complete this make sure to test your solution by running the app.
         **           //See video on website for expected behavior.
         **
         **/
        return searchHelper(root, value);
    }

    public VizTreeNodeStr searchPub(String value)
    {
        return searchHelper(root, value);
    }

    /**
     **
     **  Recursively searches through the Tree, looking for the value.
     **
     **/
    private VizTreeNodeStr searchHelper(VizTreeNodeStr root, String value)
    {
        if (root == null || root.getValue() == value)
        {
            return root;
        }
        if (aLargerThanB(root.getValue(), value))
        {
            return searchHelper(root.left, value);
        }
        if (aSmallerThanB(root.getValue(), value))
        {
            return searchHelper(root.right, value);
        }
        return root;
    }

    private boolean aLargerThanB(String a, String b)
    {
        //a character is larger than another character if its closer to the start of the alphabet
        //eg. a > b, aa > ab, lagos > steveJobs
//        System.out.println(a + b + a.compareTo(b));
        if (a.compareTo(b) > 0)
        {
            return true;
        }
        return false;
    }

    private boolean aSmallerThanB(String a, String b)
    {
//        System.out.println(a + b + a.compareTo(b));
        if (a.compareTo(b) < 0)
        {
            return true;
        }
        return false;
    }
}
