package edu.cis.cisgsearch.Model.Visualization;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import edu.cis.cisgsearch.Model.TConst;

public class VizTreeNode
{

    private int value, height;
    protected VizTreeNode left, right;
    private boolean showValue;
    private int x, y;
    private int color = Color.rgb(150, 150, 250);

    public VizTreeNode(int value)
    {
        this.value = value;
        this.height = 0;
        showValue = false;
        left = null;
        right = null;
    }


    public VizTreeNode insert(VizTreeNode node, int valueToInsert)
    {
        /**
         **
         **  TODO 2 : Use recursion to insert the value.
         **
         **/

        /**
         **
         **  TODO 7: Find and update the height for this node. It should be one greater than the
         *           max between the heights of its left and right nodes.
         **
         **/


        /**
         **
         **  TODO 8: Find the balance of this node and store it in a variable.
         **
         **/


        /**
         **
         **  TODO 9: Rebalance the tree depending on the balance found and valueToInsert.
         *            //Look at writeup
         **
         **/


        //If no cases match imbalance, then just return the original node.
        return node;
    }

    // A utility function to right rotate subtree rooted with y
    // See the diagram given above.
    VizTreeNode rightRotate(VizTreeNode y)
    {
        VizTreeNode x = y.left;
        VizTreeNode T2 = x.right;

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
    VizTreeNode leftRotate(VizTreeNode x)
    {
        VizTreeNode y = x.right;
        VizTreeNode T2 = y.left;

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
        return 0;
    }

    /**
     **
     **  TODO 5: Helper to return the height of a node, return 0 if null.
     **
     **/
    private int getHeight(VizTreeNode node)
    {
        return 0;
    }

    /**
     **
     **  TODO 6: Method that returns the difference between the node's children's height.
     *           Return 0 if nodes are null.
     **
     **/
    private int getBalance(VizTreeNode node)
    {
        return 0;
    }

    public int getValue()
    {
        return value;
    }

    public void positionSelf(int x0, int x1, int y)
    {
        this.y = y;
        x = (x0 + x1) / 2;

        if(left != null)
        {
            left.positionSelf(x0, right == null ? x1 - 2 * TConst.VIZ_REC_MARGIN : x, y + TConst.VIZ_REC_SIZE + TConst.VIZ_REC_MARGIN);
        }
        if (right != null)
        {
            right.positionSelf(left == null ? x0 + 2 * TConst.VIZ_REC_MARGIN : x, x1, y + TConst.VIZ_REC_SIZE + TConst.VIZ_REC_MARGIN);
        }
    }

    public void draw(Canvas c)
    {
        Paint linePaint = new Paint();
        linePaint.setStyle(Paint.Style.STROKE);
        linePaint.setStrokeWidth(3);
        linePaint.setColor(Color.GRAY);
        if (left != null)
            c.drawLine(x, y + TConst.VIZ_REC_SIZE/2, left.x, left.y + TConst.VIZ_REC_SIZE/2, linePaint);
        if (right != null)
            c.drawLine(x, y + TConst.VIZ_REC_SIZE/2, right.x, right.y + TConst.VIZ_REC_SIZE/2, linePaint);

        Paint fillPaint = new Paint();
        fillPaint.setStyle(Paint.Style.FILL);
        fillPaint.setColor(color);
        c.drawRect(x- TConst.VIZ_REC_SIZE/2, y, x+ TConst.VIZ_REC_SIZE/2, y+ TConst.VIZ_REC_SIZE, fillPaint);

        Paint paint = new Paint();
        paint.setColor(Color.BLACK);
        paint.setTextSize(TConst.VIZ_REC_SIZE * 2/3);
        paint.setTextAlign(Paint.Align.CENTER);
        c.drawText(showValue ? String.valueOf(value) : "?", x, y + TConst.VIZ_REC_SIZE * 3/4, paint);

        if (height > 0)
        {
            Paint heightPaint = new Paint();
            heightPaint.setColor(Color.MAGENTA);
            heightPaint.setTextSize(TConst.VIZ_REC_SIZE * 2 / 3);
            heightPaint.setTextAlign(Paint.Align.LEFT);
            c.drawText(String.valueOf(height), x + TConst.VIZ_REC_SIZE / 2 + 10, y + TConst.VIZ_REC_SIZE * 3 / 4, heightPaint);
        }

        if (left != null)
            left.draw(c);
        if (right != null)
            right.draw(c);
    }

    public int click(float clickX, float clickY, int target)
    {
        int hit = -1;
        if (Math.abs(x - clickX) <= (TConst.VIZ_REC_SIZE / 2) && y <= clickY && clickY <= y + TConst.VIZ_REC_SIZE)
        {
            if (!showValue)
            {
                if (target != value)
                {
                    color = Color.RED;
                }
                else
                {
                    color = Color.GREEN;
                }
            }
            showValue = true;
            hit = value;
        }
        if (left != null && hit == -1)
            hit = left.click(clickX, clickY, target);
        if (right != null && hit == -1)
            hit = right.click(clickX, clickY, target);
        return hit;
    }

    public void invalidate()
    {
        color = Color.CYAN;
        showValue = true;
    }
}

