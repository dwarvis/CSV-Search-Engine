package edu.cis.cisgsearch.Model.Visualization;

import android.graphics.Canvas;

import edu.cis.cisgsearch.Model.GoogleSearch.TARestProfile;

public class VizBinarySearchTree {
    private VizTreeNode root = null;

    public VizBinarySearchTree()
    {
    }

    public void insert(int value, TARestProfile info)
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
            root = new VizTreeNode(value);
        }
        if (root != null)
        {
            root = root.insert(root, value, info);
        }
    }

    public void positionNodes(int width)
    {
        if (root != null)
            root.positionSelf(0, width, 0);
    }

    public void draw(Canvas c) {
        root.draw(c);
    }

    public int click(float x, float y, int target) {
        return root.click(x, y, target);
    }

    private VizTreeNode search(int value)
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

    public TARestProfile find(int value)
    {
        return search(value).getProf();

    }

    public VizTreeNode searchPub(int value)
    {
        return searchHelper(root, value);
    }

    /**
     **
     **  Recursively searches through the Tree, looking for the value.
     **
     **/
    private VizTreeNode searchHelper(VizTreeNode root, int value)
    {
        if (root == null || root.getValue() == value)
        {
            return root;
        }
        if (root.getValue() > value)
        {
            return searchHelper(root.left, value);
        }
        if (root.getValue() < value)
        {
            return searchHelper(root.right, value);
        }
        return root;
    }

    public void invalidateNode(int targetValue)
    {
        VizTreeNode target = search(targetValue);
        if (target != null)
        {
            target.invalidate();
        }
    }
}
