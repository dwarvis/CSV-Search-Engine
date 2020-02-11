package edu.cis.cisgsearch.Model.Visualization;

import android.graphics.Canvas;

public class VizBinarySearchTree {
    private VizTreeNode root = null;

    public VizBinarySearchTree()
    {
    }

    public void insert(int value)
    {

        /**
         **
         **  TODO 1 : Check if binary tree is empty, if not call VizTreeNode's insert()
         **            //method and pass in the root and the value. Set root to the Node returned.
         **           // If empty, just set the root to be a new VizTreeNode.
         **
         **/
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
         **           //Once you complete this you MUST test your solution by running the app.
         **
         **/

        return null;
    }

    /**
     **
     **  Recursively searches through the Tree, looking for the value.
     **
     **/
    private VizTreeNode searchHelper(VizTreeNode root, int value)
    {
        return null;
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
